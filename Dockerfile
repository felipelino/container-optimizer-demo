FROM openjdk:8-jdk

RUN apt-get update && apt-get install procps -y
RUN mkdir -p /usr/app
ADD ./target/container-optimizer-demo-1.1.0.jar /usr/app
WORKDIR /usr/app
CMD java -jar $JAVA_OPTS /usr/app/container-optimizer-demo-1.1.0.jar