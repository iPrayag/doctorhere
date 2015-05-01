doctorhere-engine
==================

<b>architecture</b>

```

|DoctorCountTool      |             | DoctorMapper  |        | DoctorReducer | 
|create a jobConf and |             | .collect      |        | .collect      |      
|add input            |             |               |        |               |
|set output           |
|set mapper           |
|                     |
|run jobConf          |

```


Run Hadoop Job (hadoop version 1.0.2) against a hadoop cluster
=================================================================


```

#enter hduser
su - hduser

#start hadoop cluster
/usr/local/hadoop-2.2.0/sbin/start-dfs.sh
/usr/local/hadoop-2.2.0/sbin/start-yarn.sh

#create doctorhere folder in hdfs

//There should be `/user/hduser`, otherwise hadoop fs -mkdir -p /user/[current login user]

hdfs dfs -mkdir -p /user/hduser/doctorhere

or 

hdfs dfs -mkdir -p doctorhere

hduser@prayagupd:~$ hdfs dfs -ls

#copy input to hdfs
hdfs dfs -copyFromLocal /packup/workspace.programming/workspace.jvm/doctorhere/doctorhere-engine/src/main/java/Resources/input.csv /user/hduser/doctorhere/

hduser@prayagupd:~$ hdfs dfs -cat doctorhere/input.csv
15/03/15 17:35:22 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Cancer AffectivePsychosis Asthma
COPD ChronicPain Cancer

#run the job from hdfs
hduser@prayagupd:/packup/workspace.programming/workspace.jvm/doctorhere/doctorhere-engine$ hadoop jar target/doctorhere-0.0.1-SNAPSHOT.jar com.zazzercode.doctorhere.DoctorCountMain
```

using maven
==============

`$ mvn exec:java -Dexec.mainClass="com.zazzercode.doctorhere.DoctorCountMain"`


output
------------

```
hduser@prayagupd:/packup/workspace.programming/workspace.jvm/doctorhere/doctorhere-engine$ hdfs dfs -ls /user/hduser/doctorhere/output
15/03/15 18:49:35 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Found 2 items
-rw-r--r--   1 hduser supergroup          0 2015-03-15 18:46 /user/hduser/doctorhere/output/_SUCCESS
-rw-r--r--   1 hduser supergroup         60 2015-03-15 18:46 /user/hduser/doctorhere/output/part-00000
```

```
$ hdfs dfs -cat /user/hduser/doctorhere/output/part-00000 
AffectivePsychosis 1
Asthma             1
COPD               1
Cancer             2
ChronicPain        1
```
