doctorhere-servlet
==================

This project is created using `maven-archetype-webapp`.

Add M2_REPO to eclipse classpath
==================

![M2_REPO](https://github.com/iPrayag/doctorhere-servlet/raw/master/snaps/ADD_M2_REPO_ECLIPSE.png)


Get the war at target
===================
The war name is defined at `<build>` section of `pom.xml`.

``
   <build>
    <finalName>doctorhere</finalName>
    [...]
   </build>
``


![war](https://github.com/iPrayag/doctorhere-servlet/raw/master/snaps/war.png)


HTTP Request/Response headers
=======
![headers](https://github.com/iPrayag/doctorhere-servlet/raw/master/snaps/index_headers.png)


Run Hadoop
==========
`mvn exec:java -Dexec.mainClass="com.zazzercode.doctorhere.models.hadoop.DoctorCountMain"`





