package com.doctorhere.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.util.ToolRunner;
import org.elasticsearch.hadoop.mr.EsOutputFormat;
import org.slf4j.*;
import org.apache.hadoop.util.Tool;

import java.security.PrivilegedExceptionAction;

/**
 * @author prayagupd
 */

public class DiseaseCountJob extends Configured implements Tool {

    Logger logger = LoggerFactory.getLogger(DiseaseCountJob.class);

    public static void main(final String[] args) throws Exception{

        System.setProperty("HADOOP_USER_NAME", "hdfs");

        UserGroupInformation ugi = UserGroupInformation.createRemoteUser("hdfs");
        ugi.doAs(new PrivilegedExceptionAction<Object>() {
            public Void run() throws Exception {
                Configuration configuration = new Configuration();
                configuration.set("hadoop.job.ugi", "hdfs");
                ToolRunner.run(new DiseaseCountJob(), args);
                return null;
            }
        });
    }

    public int run(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.printf("Usage: %s [generic options] <input> <output>\n",
                    getClass().getSimpleName());
            ToolRunner.printGenericCommandUsage(System.err);
            return -1;
        }

        Job job = new Job();

        job.setJarByClass(DiseaseCountJob.class);
        job.setJobName("DiseaseCounter");
        logger.info("Input path " + args[0]);
        logger.info("Output path " + args[1]);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        Configuration configuration = job.getConfiguration();
        configuration.set("es.nodes","localhost:9200");
        configuration.set("es.resource","doctorhere/MemberHistory");

        job.setOutputFormatClass(EsOutputFormat.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(MapWritable.class);
        job.setMapperClass(DiseaseCountMapper.class);
        job.setReducerClass(DiseaseCountReducer.class);

        int returnValue = job.waitForCompletion(true) ? 0:1;
        System.out.println("job.isSuccessful " + job.isSuccessful());
        return returnValue;
    }

}
