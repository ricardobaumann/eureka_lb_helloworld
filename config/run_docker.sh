#!/usr/bin/env bash
docker run -it -p 8888:8888       -e SPRING_CLOUD_CONFIG_SERVER_GIT_URI=https://github.com/spring-cloud-samples/config-repo       hyness/spring-cloud-config-server