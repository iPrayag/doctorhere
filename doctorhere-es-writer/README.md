start hadoop cluster
------------------------
```
su - hduser
start-dfs.sh && start-yarn.sh

```

start es
-------------
```
/usr/local/elasticsearch-1.0.0/bin/elasticsearch
```

create jar
----------------
```
mvn clean install
```

submit job
--------------

```
hadoop jar target/doctorhere-es-writer-1.0-SNAPSHOT.jar com.doctorhere.hadoop.DiseaseCountJob /user/hduser/doctorhere/input.csv /user/hduser/doctorhere
```

output
---------

```
curl http://localhost:9200/doctorhere/_search?pretty=true
{
  "took" : 2,
  "timed_out" : false,
  "_shards" : {
    "total" : 5,
    "successful" : 5,
    "failed" : 0
  },
  "hits" : {
    "total" : 5,
    "max_score" : 1.0,
    "hits" : [ {
      "_index" : "doctorhere",
      "_type" : "MemberHistory",
      "_id" : "l__6Q7r0SDKVRPS9t9posA",
      "_score" : 1.0, "_source" : {"Asthma":1}
    }, {
      "_index" : "doctorhere",
      "_type" : "MemberHistory",
      "_id" : "gGr7AmLAQ9OfEJtbp976Sg",
      "_score" : 1.0, "_source" : {"AffectivePsychosis":1}
    }, {
      "_index" : "doctorhere",
      "_type" : "MemberHistory",
      "_id" : "EKVkf5myQ8aRrr9qCj0q8A",
      "_score" : 1.0, "_source" : {"Cancer":2}
    }, {
      "_index" : "doctorhere",
      "_type" : "MemberHistory",
      "_id" : "dYGaTsg1RW22ErlpTUJFsw",
      "_score" : 1.0, "_source" : {"ChronicPain":1}
    }, {
      "_index" : "doctorhere",
      "_type" : "MemberHistory",
      "_id" : "bMvEq8B6QHq7g7SKdBq-0A",
      "_score" : 1.0, "_source" : {"COPD":1}
    } ]
  }
}

```
