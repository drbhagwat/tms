echo "Dropping all tables in GIV..."
export PGPASSWORD=root
psql -U postgres -d postgres -f dropall.sql
