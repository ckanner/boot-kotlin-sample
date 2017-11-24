# Description

Use spring boot 2.0 M6 and kotlin to render template.

# Usage

There are two ways to run the application. The way that running the application in the IDEA can succeed.

# Run with the jar

* clone the code
* enter the project ```cd boot-kotlin-sample```
* build the jar ```mvn clean compile package```
* exec the jar ```java -jar target/boot-kotlin-sample-master-SNAPSHOT-exec.jar```
* verify it ```curl http://127.0.0.1:8080/user```. Some error will occur.

# Run in the IDEA

* clone the code
* import the source code into the IDEA
* Run the application in the IDEA
* verify it ```curl http://127.0.0.1:8080/user```. It success.