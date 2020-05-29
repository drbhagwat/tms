echo "Droping all tables in GIV..."
export PGPASSWORD=root
docker cp ./dropall.sql tms-deploy_mic-tms-pg_1:tmp/dropall.sql
docker exec tms-deploy_mic-tms-pg_1 psql -U postgres -d postgres -f tmp/dropall.sql
