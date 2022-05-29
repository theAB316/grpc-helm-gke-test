#!/bin/bash
sudo docker build -t basic-server -f image-build-deploy/DockerfileServer .

# tag the image accordingly
docker image tag basic-server aneeshbhat/basic-app/basic-server:latest

# push the image to dockerhub account 'aneeshbhat' and repo 'basic-app'
docker image push aneeshbhat/basic-app/basic-server:latest