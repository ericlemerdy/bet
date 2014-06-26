#!/bin/sh

docker run -i -t --rm --link bet_db:bet_db --volume=$(pwd)/../src/main/resources/sql:/sql mysql '/bin/bash'

# And then:

# mysql -u root -p -h $BET_DB_PORT_3306_TCP_ADDR < /sql/init-db.sql
# password: foo

# Test:
# mysql -u root -p -h $BET_DB_PORT_3306_TCP_ADDR -D bet
# SHOW DATABASES;