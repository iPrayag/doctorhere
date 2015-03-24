package com.doctorhere.hadoop;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by prayagupd
 * on 3/23/15.
 */

public class DiseaseCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  Logger logger = LoggerFactory.getLogger(DiseaseCountMapper.class);
  private final IntWritable ONE = new IntWritable(1);
  private Text word = new Text();

  @Override
  protected void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    logger.debug("Entering DiseaseCountMapper.map() " + this);
    String line = value.toString();
    StringTokenizer st = new StringTokenizer(line," ");
    while(st.hasMoreTokens()){
      word.set(st.nextToken());
      context.write(word, ONE);
    }
    logger.debug("Exiting DiseaseCountMapper.map()");
  }

}
