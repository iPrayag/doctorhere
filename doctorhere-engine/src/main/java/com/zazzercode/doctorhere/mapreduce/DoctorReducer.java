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
	public void reduce(Text keyFromMapper, Iterator<IntWritable> valuesForKey, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
        System.out.println("=========================================");
        System.out.println(" collecting results for : " + valuesForKey);
        System.out.println("=========================================");

        // sum all data for a key
        // (key, [value1, value2, value3])
        int sum = 0;
        while (valuesForKey.hasNext()) {
            sum +=  valuesForKey.next().get();
        }
        //write processed data to cassandra
        outputCollector.collect(keyFromMapper, new IntWritable(sum));
	}
}
