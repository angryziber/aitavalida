#!/bin/bash

mkdir -p logs
docker logs aitavalida-aitavalida-1 2>&1 | gzip > logs/aitavalida-"$(date +%Y-%m-%d_%H:%m:%S)".log.gz
docker compose -f compose.yml -f compose.deploy.yml up -d
