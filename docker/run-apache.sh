#!/bin/bash

cd ../api

WEB_PORT=2233

docker rm -f bam-apache &> /dev/null 
docker run -d --privileged --name bam-apache -v $(pwd):/var/www/html -p $WEB_PORT:80 bugatto/apache

echo "Apache is running on $WEB_PORT port"
