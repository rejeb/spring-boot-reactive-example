FROM lwieske/java-8:jdk-8u152

VOLUME /USR/newtprod

VOLUME /USR/newtprod/spring-boot-reactive-example/conf

VOLUME /USR/newtprod/spring-boot-reactive-example/jars

COPY src/main/resources/application-dev.properties /USR/newtprod/spring-boot-reactive-example/conf/application.properties

COPY src/main/resources/logback-dev.xml /USR/newtprod/spring-boot-reactive-example/conf/logback-spring.xml

COPY target/spring-boot-reactive-example-api-0.1.0-SNAPSHOT-exec.jar /USR/newtprod/spring-boot-reactive-example/jars/spring-boot-reactive-example-api-0.1.0-SNAPSHOT-exec.jar

EXPOSE 10104

ENTRYPOINT ["java","-Xmx256m", "-cp", "/USR/newtprod/spring-boot-reactive-example/jars/*:/USR/newtprod/spring-boot-reactive-example/conf", "org.springframework.boot.loader.JarLauncher"]


