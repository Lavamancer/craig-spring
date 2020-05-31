#!/usr/bin/env bash

docker stop craig
docker rm craig
docker rmi craig

cd /root/craig/project
bash -x gradlew buildDocker --no-daemon --stacktrace -Dprod -Pprofile=prod -x test
docker logs -f craig