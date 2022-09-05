FROM alpine:latest

#USER root
#RUN yum -y install wget
#RUN wget https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_linux-x64_bin.tar.gz
#RUN tar xvf openjdk-17.0.2_linux-x64_bin.tar.gz
#RUN mv jdk-17.0.2/ /opt/jdk-17/
#ENV JAVA_HOME=/opt/jdk-17
#RUN export JAVA_HOME=/opt/jdk-17
#ENV PATH=$PATH:$JAVA_HOME/bin
#RUN  echo $JAVA_HOME
RUN apk --no-cache add openjdk17
RUN java -version