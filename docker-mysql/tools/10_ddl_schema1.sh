. ./DB.conf

DB_SCHEMA=schema1
SQL_DIR=./ddl/${DB_SCHEMA}

mysql -h${DB_HOST} -P${DB_PORT} -u${DB_USER} -p${DB_PWD} ${DB_SCHEMA} < ${SQL_DIR}/account.sql

