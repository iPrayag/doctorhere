##
# @see : http://wiki.apache.org/cassandra/gettingstarted
##

##CREATE space
CREATE KEYSPACE doctorhere
WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE doctorhere;

#create type
CREATE TABLE Doctors (
  doctorId int PRIMARY KEY,
  fName text,
  lName text, 
  specialities text
);

#insert document
INSERT INTO Doctors (doctorId,  fName, lName, specialities)
  VALUES (1745, 'john', 'smith', "");
INSERT INTO users (doctorId,  fName, lName)
  VALUES (1744, 'john', 'doe', "");
INSERT INTO users (doctorId,  fName, lName)
  VALUES (1746, 'Rajesh', 'Hamal', "");


#fetch documents
SELECT * FROM Doctors;


