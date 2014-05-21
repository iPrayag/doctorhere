package zazzercode;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;
import org.apache.cassandra.thrift.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class DiseaseCountReducer extends 
        Reducer<Text, IntWritable, ByteBuffer, List<Mutation>> {
    
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        List<Mutation> columnsToAdd = new ArrayList<Mutation>();
        Integer wordCount = 0;
        for(IntWritable value : values) {
            wordCount += value.get();
        }
        Column countCol = new Column(ByteBuffer.wrap("count".getBytes()));
        countCol.setValue(ByteBuffer.wrap(wordCount.toString().getBytes()));
        countCol.setTimestamp(new Date().getTime());
        
        ColumnOrSuperColumn wordCosc = new ColumnOrSuperColumn();
        wordCosc.setColumn(countCol);
        
        Mutation countMut = new Mutation();
        countMut.column_or_supercolumn = wordCosc;
            
        columnsToAdd.add(countMut);
        context.write(ByteBuffer.wrap(key.toString().getBytes()), columnsToAdd);
    }
    
    private ByteBuffer longToByteBuffer(long number){
        byte b[] = new byte[8];
        ByteBuffer buf = ByteBuffer.wrap(b);
        buf.putLong(number);
        return buf;
    }
}
