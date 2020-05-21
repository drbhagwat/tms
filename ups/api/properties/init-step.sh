#!/bin/bash

printf "Bringing TMS down\n"
docker-compose down

printf "Bringing postgres up\n"
docker-compose up -d tms-mic-pg
sleep 15

printf "Bringing TMS up\n"
docker-compose up -d
sleep 15
