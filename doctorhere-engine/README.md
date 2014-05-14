doctorhere-engine
==================

This project is created using `maven-archetype-webapp`.

Add M2_REPO to eclipse classpath
==================

![M2_REPO](https://github.com/iPrayag/doctorhere-servlet/raw/master/snaps/ADD_M2_REPO_ECLIPSE.png)



Run Hadoop Job (hadoop version 1.0.2)
==============

`$ mvn exec:java -Dexec.mainClass="com.zazzercode.doctorhere.models.hadoop.DoctorCountMain"`

```
|DoctorCountTool      |             | DoctorMapper  |        | DoctorReducer | 
|create a jobConf and |             | .collect      |        | .collect      |      
|add input            |             |               |        |               |
|set output           |
|set mapper           |
|                     |
|run jobConf          |
```


