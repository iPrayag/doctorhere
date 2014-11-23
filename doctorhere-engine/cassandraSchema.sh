##
# cqlSH
# @see : http://wiki.apache.org/cassandra/gettingstarted
##

##CREATE space
CREATE KEYSPACE doctorhere
WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE doctorhere;

#whats the difference between creating a table and creating a columnfamily in cassandra?
#http://stackoverflow.com/a/18833933/432903
#create type
CREATE TABLE Doctors (
  doctorId int PRIMARY KEY,
  fName text,
  lName text, 
  specialities text
);

#desc
DESCRIBE TABLE doctorhere.doctors 

CREATE TABLE doctors (
  doctorid int,
  fname text,
  lname text,
  specialities text,
  PRIMARY KEY (doctorid)
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
INSERT INTO Doctors (doctorId,  fName, lName, specialities)
  VALUES (1745, 'john', 'smith', "Psychologist");
INSERT INTO users (doctorId,  fName, lName)
  VALUES (1744, 'john', 'doe', "ears");
INSERT INTO users (doctorId,  fName, lName)
  VALUES (1746, 'Rajesh', 'Hamal', "nose");


#fetch documents
SELECT * FROM Doctors;


