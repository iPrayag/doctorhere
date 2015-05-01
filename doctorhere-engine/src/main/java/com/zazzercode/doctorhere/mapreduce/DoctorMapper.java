/**
 * 
 */
package com.zazzercode.doctorhere.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

/**
 * @author prayag
 *
 */
public class DoctorMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
	private final static IntWritable ONE = new IntWritable(1);
    private Text word = new Text();
 
    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
        String line = value.toString();
        System.out.println("=========================================");
        System.out.println("processing line : " + line);
        System.out.println("=========================================");

        //write count of each term as 1 from input documents
        StringTokenizer itr = new StringTokenizer(line);
        while (itr.hasMoreTokens()) {
        	String token = itr.nextToken();
          word.set(token);
          outputCollector.collect(word, ONE);
        }
    }

}
