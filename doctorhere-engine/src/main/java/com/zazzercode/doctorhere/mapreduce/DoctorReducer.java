/**
 * 
 */
package com.zazzercode.doctorhere.mapreduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Reducer.Context;

import com.zazzercode.doctorhere.services.CassandraConnector;

/**
 * @author prayag
 *
 */
public class DoctorReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{

	private IntWritable count = new IntWritable();
	
	@Override
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
		int sum = 0;
        while (values.hasNext()) {
            sum +=  values.next().get();
        }
	//write processed data to cassandra
        output.collect(key, new IntWritable(sum));
		
	}

}
