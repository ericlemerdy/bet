CREATE DATABASE `bet` CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'bet-user'@'%'; GRANT ALL PRIVILEGES ON *.* TO 'bet-user'@'%';

grant all privileges on `bet`.* to 'bet-user'@'%' identified by 'dbpwd';

grant SELECT, INSERT, UPDATE, DELETE ON `bet`.* to 'bet-user'@'%' identified by 'dbpwd';

flush privileges;