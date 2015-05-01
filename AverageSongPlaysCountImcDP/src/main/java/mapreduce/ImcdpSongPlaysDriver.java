package mapreduce;

/**
 * Q1. Write an in-mapper combiner (IMC DP) algorithm for the “average problem”.
 * Created by prayagupd
 * on 4/30/15.
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ImcdpSongPlaysDriver extends Configured implements Tool{

  @Override
  public int run(String[] args) throws Exception {
    Configuration conf = new Configuration();
    args = new GenericOptionsParser(conf, args).getRemainingArgs();
    final String hdfs = "/user/hduser/";
    String input = hdfs + "doctorhere/spotify.txt";//args[0];
    String output = hdfs + "doctorhere/output";//args[1];

    Job job = new Job(conf, "IMCDP");
    job.setJarByClass(ImcdpSongPlaysMapper.class);
    job.setInputFormatClass(TextInputFormat.class);
    job.setMapperClass(ImcdpSongPlaysMapper.class);
    job.setMapOutputKeyClass(IntWritable.class);
    job.setMapOutputValueClass(IntPair.class);

    job.setReducerClass(ImcdpAverageSongPlaysReducer.class);
    job.setOutputFormatClass(TextOutputFormat.class);
    job.setOutputKeyClass(IntWritable.class);
    job.setOutputValueClass(FloatWritable.class);

    FileInputFormat.setInputPaths(job, new Path(input));
    Path outPath = new Path(output);
    FileOutputFormat.setOutputPath(job, outPath);
    outPath.getFileSystem(conf).delete(outPath, true);

    job.waitForCompletion(true);
    return (job.waitForCompletion(true) ? 0 : 1);
  }

  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new ImcdpSongPlaysDriver(), args);
    System.exit(exitCode);
  }
}