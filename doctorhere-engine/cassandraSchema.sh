##
# cqlSH
# @see : http://wiki.apache.org/cassandra/gettingstarted
##

## from cqlsh
## CREATE space
CREATE KEYSPACE doctorhere
WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE doctorhere;

# whats the difference between creating a table and creating a columnfamily in cassandra?
# http://stackoverflow.com/a/18833933/432903
# create ColumnFamily/type
CREATE TABLE Doctors (
  doctorId int PRIMARY KEY,
  fName text,
  lName text, 
  specialities Set<text>,
  achievements map<text, text>,
  joinedDate timestamp
);

# DESC
DESCRIBE TABLE doctorhere.doctors 

CREATE TABLE doctors (
  doctorId int,
  fName text,
  lName text,
  specialities Set<text>,
  achievements map<text, text>,
  joinedDate timestamp,
  PRIMARY KEY (doctorId, joinedDate)
) WITH
  bloom_filter_fp_chance=0.010000 AND
  caching='KEYS_ONLY' AND
  comment='' AND
  dclocal_read_repair_chance=0.000000 AND
  gc_grace_seconds=864000 AND
  index_interval=128 AND
  read_repair_chance=0.100000 AND
  replicate_on_write='true' AND
  populate_io_cache_on_flush='false' AND
  default_time_to_live=0 AND
  speculative_retry='99.0PERCENTILE' AND
  memtable_flush_period_in_ms=0 AND
  compaction={'class': 'SizeTieredCompactionStrategy'} AND
  compression={'sstable_compression': 'LZ4Compressor'};


#insert document
INSERT INTO Doctors (doctorId,  fName, lName, specialities, achievements, joinedDate)
  VALUES (1745, 'john', 'smith', {'Psychologist'}, {'Discovered cancer medicine' : '2007'}, '1989-10-28');

INSERT INTO doctors (doctorId,  fName, lName, specialities, achievements, joinedDate)
  VALUES (1744, 'john', 'doe', {'ears', 'nose'},  {'Discovered cancer medicine' : '2007'}, '2010'); 
;;now()

INSERT INTO doctors (doctorId,  fName, lName, specialities, achievements, joinedDate)
  VALUES (1746, 'Rajesh', 'Hamal', {'nose'},  {'Discovered cancer medicine' : '2007'}, '2014'); 
;;dateof()


# fetch documents
# select * from doctors where doctorId=1745;
# select * from doctors where joinedDate>='1989' ALLOW FILTERING
cqlsh:doctorhere> select * from doctors ;

 doctorid | joineddate               | achievements                           | fname | lname | specialities
----------+--------------------------+----------------------------------------+-------+-------+------------------
     1745 | 1989-10-28 00:00:00+0545 | {'Discovered cancer medicine': '2007'} |  john | smith | {'Psychologist'}

(1 rows)



