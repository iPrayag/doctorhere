doctorhere-engine
==================

Run Hadoop Job (hadoop version 1.0.2)
==============

`$ mvn exec:java -Dexec.mainClass="com.zazzercode.doctorhere.DoctorCountMain"`

```
|DoctorCountTool      |             | DoctorMapper  |        | DoctorReducer | 
|create a jobConf and |             | .collect      |        | .collect      |      
|add input            |             |               |        |               |
|set output           |
|set mapper           |
|                     |
|run jobConf          |
```

output
------------

```
$ cat output/part-00000 
AffectivePsychosis 1
Asthma             1
COPD               1
Cancer             2
ChronicPain        1
```
