#!/bin/bash

docker rm -f bam-mysql > /dev/null
docker run --name bam-mysql -e MYSQL_DATABASE=bam -e MYSQL_USER=bamuser -e MYSQL_ROOT_PASSWORD=root -p 3322:3306 -d mysql
