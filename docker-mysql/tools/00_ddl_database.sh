. ./DB.conf

mysql -h${DB_HOST} -P${DB_PORT} -u${DB_USER} -p${DB_PWD} < ddl/database.sql

