# Question-App

https://start.spring.io/

Hibernate: create table questions (ques_id integer not null auto_increment, ans integer not null, chose integer not null, optiona varchar(255), optionb varchar(255), optionc varchar(255), title varchar(255), primary key (ques_id)) engine=InnoDB

Hibernate: create table results (id integer not null auto_increment, total_correct integer not null, username varchar(255), primary key (id)) engine=InnoDB
