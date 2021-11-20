DROP DATABASE IF EXISTS schema1;

CREATE DATABASE schema1;

DROP USER IF EXISTS 'app_user'@'%';

CREATE USER 'app_user'@'%'   IDENTIFIED BY "app_user_password";

GRANT SELECT,INSERT,UPDATE,DELETE ON schema1.*   TO 'app_user'@'%';

flush privileges;

