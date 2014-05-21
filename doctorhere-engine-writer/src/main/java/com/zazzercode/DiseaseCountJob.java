package zazzercode;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.*;

public class DiseaseCountJob extends Configured implements Tool {

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new DiseaseCountJob(), args);
        System.exit(exitCode); 
    }

    @Override
    public int run(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.out.printf("Usage: %s [generic options] <input dir>\n", getClass().getSimpleName());
//            ToolRunner.printGenericCommandUsage(System.out);
//            return -1;
//        }

        Job job = new Job();
        job.setJobName(getClass().getName());
        job.setJarByClass(DiseaseCountJob.class);
        
        Configuration conf = job.getConfiguration();
        
        // cassandra bulk loader config
        conf.set("cassandra.output.keyspace", "doctorhere");
        conf.set("cassandra.output.columnfamily", "diseases");

        // OrderPreservingPartitioner for example could be used here too
        conf.set("cassandra.output.partitioner.class", "org.apache.cassandra.dht.RandomPartitioner");
        conf.set("cassandra.output.thrift.port","9160");    // default
        conf.set("cassandra.output.thrift.address", "127.0.0.1");
        conf.set("mapreduce.output.bulkoutputformat.streamthrottlembits", "400");

        job.setMapperClass(DiseaseCountMapper.class);
        job.setReducerClass(DiseaseCountReducer.class);
        
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        
	String baseDir = System.getProperty("user.dir");
	String input   = baseDir+"/src/main/resources/histories"; //args[0]
        FileInputFormat.setInputPaths(job, new Path(input));
        
        job.setOutputFormatClass(org.apache.cassandra.hadoop.BulkOutputFormat.class);

        return job.waitForCompletion(true) ? 0 : 1;
    }
}
