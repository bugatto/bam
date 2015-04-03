#!/bin/bash

docker rm -f bam > /dev/null 
docker run -d --name bam -v $(pwd)/testpage:/var/www/html -p 2233:80 bugatto/apache
