#!/bin/bash

docker rm -f bam_apache > /dev/null 
docker run -d --name bam_apache -v $(pwd)/testpage:/var/www/html -p 2233:80 bugatto/apache
