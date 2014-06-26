#!/bin/sh

docker rm bet_db

docker pull mysql
docker run --detach=true --name bet_db -e MYSQL_ROOT_PASSWORD=foo mysql
# --volume=$(pwd)/data/db:/data/db
