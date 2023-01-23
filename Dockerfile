FROM ubuntu
ENV TZ=Asia/Kolkata
ENV DEBIAN_FRONTEND noninteractive
RUN apt-get update -y && apt-get upgrade -y
RUN apt-get -y install sudo
RUN  apt-get install tzdata
RUN sudo apt install -y openjdk-17-jdk
RUN mkdir /app
WORKDIR /app
COPY target/shop-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]

