@ECHO OFF
ECHO Installing CsotthonApp...

ECHO Set up database...

set mysql_username=root
set mysql_password=root
set mysql_schema=csotthonapp

mysql -u%mysql_username% -p%mysql_password% mysql -e"create schema %mysql_schema%";
mysql -u%mysql_username% -p%mysql_password% mysql -e"use %mysql_schema%";

ECHO Set up backend...

call mvn clean install

mysql -u%mysql_username% -p%mysql_password% mysql -e"drop schema %mysql_schema%";
mysql -u%mysql_username% -p%mysql_password% mysql -e"create schema %mysql_schema%";
mysql -u%mysql_username% -p%mysql_password% mysql -e"use %mysql_schema%";

ECHO Done

PAUSE