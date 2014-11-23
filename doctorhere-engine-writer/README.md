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

Putting (Big) Data Into Hadoop  FS
--------------------------------------
    $ su - hduser
    $ /usr/local/hadoop/sbin/start-dfs.sh
    $ /usr/local/hadoop/sbin/start-yarn.sh
    $ jps

    ## create hdfs folder and copy local data to the same hdfs
    $ hdfs dfs -mkdir -p /user/hduser/
    $ hdfs dfs -copyFromLocal src/main/resources/shakespeare /usr/hduser/

    $ hdfs dfs -ls /usr/hduser/shakespeare
    14/11/22 20:49:16 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
    Found 5 items
    -rw-r--r--   1 hduser supergroup    1784616 2014-11-22 20:48 /usr/hduser/shakespeare/comedies
    -rw-r--r--   1 hduser supergroup      58976 2014-11-22 20:48 /usr/hduser/shakespeare/glossary
    -rw-r--r--   1 hduser supergroup    1479035 2014-11-22 20:48 /usr/hduser/shakespeare/histories
    -rw-r--r--   1 hduser supergroup     268140 2014-11-22 20:48 /usr/hduser/shakespeare/poems
    -rw-r--r--   1 hduser supergroup    1752440 2014-11-22 20:48 /usr/hduser/shakespeare/tragedies

Building The JAR
----------------

    $ mvn clean:clean
    $ mvn assembly:assembly

Running It On A Cluster
-----------------------

    $ hadoop jar target/doctorhere-engine-writer-1.0-jar-with-dependencies.jar /user/hduser/shakespeare

Further Readings
----------------

[Using the Cassandra Bulk Loader with Hadoop BulkOutputFormat](http://henning.kropponline.de/2012/11/15/using-cassandra-hadoopbulkoutputformat/)

start cassandra
-------------------

```
$ cqlsh
Connected to Test Cluster at localhost:9160.
[cqlsh 4.1.1 | Cassandra 2.0.7 | CQL spec 3.1.1 | Thrift protocol 19.39.0]
Use HELP for help.
cqlsh> 

```

1. see keyspaces

```
cqlsh> DESCRIBE keyspaces;
```

```bash
cqlsh> select * from system.schema_keyspaces;

 keyspace_name | durable_writes | strategy_class                              | strategy_options
---------------+----------------+---------------------------------------------+----------------------------
        system |           True |  org.apache.cassandra.locator.LocalStrategy |                         {}
 system_traces |           True | org.apache.cassandra.locator.SimpleStrategy | {"replication_factor":"2"}

```

2. show column families

```bash
cqlsh>USE system_traces;

cqlsh:system_traces> DESCRIBE COLUMNFAMILIES;

cqlsh:system_traces> DESCRIBE TABLES;

```

3. see columns

```bash
cqlsh:system_traces> SELECT * 
                     FROM system.schema_columns 
                     WHERE keyspace_name = 'system_traces' 
                     AND columnfamily_name = 'events';
```

4. show documents of a column_family, 

```
cqlsh:Usergrid> select * from "Applications" ;

 key                                                    | column1    | value
--------------------------------------------------------+------------+--------------------------------------------------------
           0x7072617961677570642d6f72672f73616e64626f78 | 0x6e616d65 |           0x7072617961677570642d6f72672f73616e64626f78
           0x7072617961677570642d6f72672f73616e64626f78 | 0x75756964 |                     0xa6a1d9d03c2c11e488c30d11d00ed727
             0x75736572677269642f64656661756c742d617070 | 0x6e616d65 |             0x75736572677269642f64656661756c742d617070
             0x75736572677269642f64656661756c742d617070 | 0x75756964 |                     0x00000000000000000000000000000010
               0x75736572677269642f6d616e6167656d656e74 | 0x6e616d65 |               0x75736572677269642f6d616e6167656d656e74
               0x75736572677269642f6d616e6167656d656e74 | 0x75756964 |                     0x00000000000000000000000000000001
 0x746573742d6f7267616e697a6174696f6e2f746573742d617070 | 0x6e616d65 | 0x746573742d6f7267616e697a6174696f6e2f746573742d617070
 0x746573742d6f7267616e697a6174696f6e2f746573742d617070 | 0x75756964 |                     0x382346a03c0011e4aea10dc2781b6c59
           0x70736575646f2d6f72672f736f6f74687361796572 | 0x6e616d65 |           0x70736575646f2d6f72672f736f6f74687361796572
           0x70736575646f2d6f72672f736f6f74687361796572 | 0x75756964 |                     0x4b6408105db811e4866a3526bfb1aeaf

(10 rows)

```
