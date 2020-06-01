#!/bin/bash

echo "Dropping all db tables..."
echo ""
echo ""

# Call the script to drop all postgreql tables
bash dropall.sh

# The following line is required, it avoids the prompt while entering psql
PGPASSWORD=root

echo ""
echo ""

echo "Creating carrier_service_code, carrier_package_code tables and populating them with data..."
export PGPASSWORD=root
docker cp ./insertall.sql tms-deploy_mic-tms-pg_1:tmp/insertall.sql
docker exec tms-deploy_mic-tms-pg_1 psql -U postgres -d postgres -f tmp/insertall.sql