FROM ubuntu:latest
RUN apt-get update -y
RUN apt-get install -y default-jre
COPY springbootdocker.jar /home/
WORKDIR /home/
ENTRYPOINT java -jar springbootdocker.jar
EXPOSE 8080 8080