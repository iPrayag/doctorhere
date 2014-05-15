##
 #@see : http://wiki.apache.org/cassandra/GettingStarted
##

sudo mkdir /var/log/cassandra/
sudo mkdir /var/lib/cassandra/
sudo chmod 777 -R /var/log/cassandra
sudo chmod 777 -R /var/lib/cassandra
cassandra -f
