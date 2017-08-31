[![Build Status](https://travis-ci.org/ryanmckaytx/java-docker-example.svg?branch=master)](https://travis-ci.org/ryanmckaytx/java-docker-example)
## Build docker image
```sh
$ ./gradlew buildDocker
$ docker images
REPOSITORY                      TAG                 IMAGE ID            CREATED              SIZE
ryanmckay/java-docker-example   latest              4bd58fcbb0b4        About a minute ago   115MB
```
## Run
```sh
$ docker run -p 8080:8080 -d ryanmckay/java-docker-example
$ curl localhost:8080/greeting
```
