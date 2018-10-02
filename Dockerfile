FROM openjdk:8-jdk

RUN mkdir -p /usr/app
ADD ./target/container-optimizer-demo-1.0.0.jar /usr/app
WORKDIR /usr/app
CMD java -jar $JAVA_OPTS /usr/app/container-optimizer-demo-1.0.0.jar