FROM openjdk:8

#Uncomment below and Comment above line(i.e. FROM openjdk:8) for OS specific (e.g. Alpine OS ) docker base image
#FROM openjdk:8-jdk-alpine

copy CICD/target/CICD-*.jar CICD.jar

EXPOSE 9092

CMD ["java",,"-jar","CICD.jar"]
