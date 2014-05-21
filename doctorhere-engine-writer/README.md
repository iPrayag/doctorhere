doctorhere-engine-writer
==============

a basic example using the Cassandra BulkLoadFormat as an
output of a MapReduce job writen in Hadoop.


Requirements
------------

* Java SE 6
* Cassandra 1.1.1 or later
* Hadoop 0.20.205.0
* mvn 2 or later

Putting Shakespeare Into Hadoop  
-------------------------------

    % hadoop fs -copyFromLocal ${buildDir}/src/main/resources/shakespeare ${pathInHdfs}

Building The JAR
----------------

    % mvn clean:clean
    % mvn assembly:assembly

Running It On A Cluster
-----------------------

    % hadoop jar CassaWordCount-1.0-jar-with-dependencies.jar ${pathInHdfs}

Further Readings
----------------

[Using the Cassandra Bulk Loader with Hadoop BulkOutputFormat](http://henning.kropponline.de/2012/11/15/using-cassandra-hadoopbulkoutputformat/)
