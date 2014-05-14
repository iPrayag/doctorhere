doctorhere-servlet
==================

This project is created using `maven-archetype-webapp`.

`mvn clean install`

Add M2_REPO to eclipse classpath
==================

![M2_REPO](https://github.com/iPrayag/doctorhere-servlet/raw/master/doctorhere-servlet/snaps/ADD_M2_REPO_ECLIPSE.png)


Get the war at target
===================
The war name is defined at `<build>` section of `pom.xml`.

```
   <build>
    <finalName>doctorhere</finalName>
    [...]
   </build>
```



![war](https://github.com/iPrayag/doctorhere-servlet/raw/master/doctorhere-servlet/snaps/war.png)


run-app
------------------

```
$./run-app.sh
```

Goto `http://localhost:8080/doctorhere/index.jsp`


HTTP Request/Response headers
=======
![headers](https://github.com/iPrayag/doctorhere-servlet/raw/master/doctor-servlet/snaps/index_headers.png)
