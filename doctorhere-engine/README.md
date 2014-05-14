doctorhere-engine
==================

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


