FROM java:8-alpine
#RUN apt-get update -y
#RUN apt-get install -y default-jre
COPY springbootdocker.jar /home/
WORKDIR /home/
ENTRYPOINT java -jar springbootdocker.jar
EXPOSE 8080