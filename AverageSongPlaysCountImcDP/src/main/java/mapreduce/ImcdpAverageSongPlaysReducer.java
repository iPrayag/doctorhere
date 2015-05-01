package mapreduce;

import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Created by prayagupd
 * on 4/30/15.
 */

public class ImcdpAverageSongPlaysReducer extends
    Reducer<IntWritable, IntPair, IntWritable, FloatWritable> {

  protected void reduce(IntWritable key, Iterable<IntPair> values, Reducer<IntWritable, IntPair, IntWritable, FloatWritable>.Context context) throws
      IOException, InterruptedException {
    Integer bandCode = key.get();
    Integer sum = 0;
    Integer countOfIteration = 0;
    System.out.println(key+","+values);
    for (IntPair value:values) {
      sum = sum + value.getFirstInt();
      countOfIteration = countOfIteration + value.getSecondInt();
    }

    System.out.println(sum+","+countOfIteration);
    Float avgPlays = (float) (sum/countOfIteration);
    context.write(new IntWritable(bandCode), new FloatWritable(avgPlays));
  }
}
