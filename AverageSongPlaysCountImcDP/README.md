
```
mvn clean install

$HADOOP_HOME/sbin/start-dfs.sh
$HADOOP_HOME/sbin/start-yarn.sh

#onetime
hadoop fs -mkdir -p /user/hduser

hdfs dfs -mkdir -p /user/hduser/doctorhere

hdfs dfs -ls

```

submit job (tested in hadoop 2.7.0)
-------

```
hdfs dfs -copyFromLocal src/main/resources/spotify.txt /user/hduser/doctorhere/

hadoop jar target/AverageSongPlaysCountImcDP-1.0-SNAPSHOT.jar mapreduce.ImcdpSongPlaysDriver
```

output
----------

```
hduser@prayagupd:/packup/workspace.programming/workspace.jvm/AverageSongPlaysCountImcDP hdfs dfs -cat /user/hduser/doctorhere/output/part-r-00000
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/usr/local/hadoop-2.7.0/share/hadoop/common/lib/slf4j-log4j12-1.7.10.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/usr/local/hadoop-2.7.0/share/hadoop/httpfs/tomcat/webapps/webhdfs/WEB-INF/lib/slf4j-log4j12-1.7.10.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/usr/local/hadoop-2.7.0/share/hadoop/kms/tomcat/webapps/kms/WEB-INF/lib/slf4j-log4j12-1.7.10.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
1	23.0
2	12.0

```