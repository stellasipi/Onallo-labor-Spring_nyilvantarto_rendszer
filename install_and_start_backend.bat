@ECHO OFF
ECHO Installing CsotthonApp...

ECHO Set up database...

set mysql_username=root
set mysql_password=root
set mysql_schema=csotthonapp

mysql -u%mysql_username% -p%mysql_password% mysql
create schema %mysql_schema%;
use %mysql_schema%;
exit

ECHO Set up backend...

mvn clean install

mysql -u%mysql_username% -p%mysql_password% mysql
drop schema %mysql_schema%;
create schema %mysql_schema%;
use %mysql_schema%;
exit

ECHO Starting backend...

mvn spring-boot:run