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
psql -U postgres -d postgres -f insertall.sql
