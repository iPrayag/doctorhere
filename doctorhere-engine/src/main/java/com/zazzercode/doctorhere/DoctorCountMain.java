package com.zazzercode.doctorhere;

import java.util.logging.Logger;
import javax.print.Doc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.util.ToolRunner;
import com.zazzercode.doctorhere.mapreduce.DoctorCountTool;
import com.zazzercode.doctorhere.CassandraConnector;
/**
 * @author prayag
 * @see http://kickstarthadoop.blogspot.com/2011/04/word-count-hadoop-map-reduce-example.html
 * @see http://blogs.igalia.com/dpino/2012/10/14/starting-with-hadoop/
 */
public class DoctorCountMain {

	private static Logger logger = Logger.getLogger(DoctorCountMain.class.getName());
      
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int res = ToolRunner.run(new Configuration(), new DoctorCountTool(),args);
			System.exit(res);
		} catch (Exception e) {
			logger.warning("Exception : ");
			e.printStackTrace();
		}
	}
	
	public void sayHadoopOne(String args[]){
		IntWritable one = new IntWritable(1);
		logger.info("This is hadoop saying one : "+one);
		try {
			int res = ToolRunner.run(new Configuration(), new DoctorCountTool(), args);
			System.exit(res);
		} catch (Exception e) {
			logger.warning("Exception : ");
			e.printStackTrace();
		}
	}

}
