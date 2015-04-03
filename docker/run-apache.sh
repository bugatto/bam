#!/bin/bash

cd ../api

docker rm -f bam-apache &> /dev/null 
docker run -d --privileged --name bam-apache -v $(pwd):/var/www/html -p 2233:80 bugatto/apache
