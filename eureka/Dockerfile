FROM openjdk:13-jdk
COPY eureka.jar eureka.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","eureka.jar"]
