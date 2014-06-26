#!/bin/sh

docker rm bet_web

docker pull jolokia/tomcat-7.0
docker run --detach=true --volume=$(pwd)/../target:/maven --publish=8080:8080 --link bet_db:bet_db --name bet_web jolokia/tomcat-7.0
