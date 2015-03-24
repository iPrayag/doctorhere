package com.doctorhere.hadoop;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by prayagupd
 * on 3/23/15.
 */

public class DiseaseCountReducer extends Reducer<Text, IntWritable, Text, MapWritable> {
  Logger logger = LoggerFactory.getLogger(DiseaseCountReducer.class);

  @Override
  protected void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
    logger.debug("Entering DiseaseCountReducer.reduce() " + this);

    int sum = 0;
    Iterator<IntWritable> valuesIt = values.iterator();
    while(valuesIt.hasNext()){
      sum = sum + valuesIt.next().get();
    }
    logger.debug(key + " -> " + sum);
    MapWritable mapWritable = new MapWritable();
    mapWritable.put(key, new IntWritable(sum));
    context.write(key, mapWritable);
    logger.debug("Exiting DiseaseCountReducer.reduce()");
  }
}
