mvn clean install
docker build -t consumer:v1 .
docker run consumer:v1