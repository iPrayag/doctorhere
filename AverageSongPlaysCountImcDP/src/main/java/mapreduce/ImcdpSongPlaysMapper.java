package mapreduce;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Created by prayagupd
 * on 4/30/15.
 */

public class ImcdpSongPlaysMapper extends
    Mapper<LongWritable, Text, IntWritable, IntPair> {

  String record;
  private Map<Integer, Integer> partialSum = new HashMap<Integer, Integer>();
  private Map<Integer, Integer> recordCount = new HashMap<Integer, Integer>();

  protected void map(LongWritable key, Text value, Mapper.Context context) {
    record = value.toString();
    String[] fields = record.split(",");

    Integer bandCode = new Integer(fields[0]);
    Integer playCount = new Integer(fields[2].trim());
    inMapCombine(bandCode, playCount);

  } // end of map method

  private void inMapCombine(Integer bandCode, Integer playCount) {
    if (partialSum.containsKey(bandCode)) {
      Integer sum = (Integer) partialSum.get(bandCode) + playCount;
      partialSum.put(bandCode, sum);
    } else {
      partialSum.put(bandCode, playCount);
    }

    if (recordCount.containsKey(bandCode)) {
      Integer count = (Integer) recordCount.get(bandCode) + 1;
      recordCount.put(bandCode, count);
    } else {
      recordCount.put(bandCode, 1);
    }
  }

  protected void cleanup(Context context) throws IOException, InterruptedException {
    Iterator<Map.Entry<Integer, Integer>> sumIterator = partialSum.entrySet().iterator();

    while (sumIterator.hasNext()) {
      Map.Entry<Integer, Integer> entry1 = sumIterator.next();

      Integer bandCode1 = entry1.getKey();
      Integer partialSum1 = entry1.getValue();
      Integer recordCount1 = (Integer) recordCount.get(bandCode1);

      context.write(new IntWritable(bandCode1), new IntPair(partialSum1, recordCount1));
      System.out.println(bandCode1+","+partialSum1+","+recordCount1);
    }
  } // end of cleanup
} // end of mapper class
