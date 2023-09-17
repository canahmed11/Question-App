# Question-App

https://start.spring.io/

*Project :* Maven 
*Language :* Java
*Spring Boot :* 3.1.3
*Packaging :* jar
*Java :* 17
*Dependencies :* Web, Thymeleaf, Spring DevTools,  Spring Data JPA, MySql (kullandığım dependenciesler bunlar eğer ki sonradan eklenmesi gereken olursa https://mvnrepository.com/ sitesinden pom.xml dosyasına eklenebilir. pom.xml dosyasına ekledikten sonra pom.xml dosyasına çift tıklayıp Maven -> Reload Project'e tıklanmalı ki kullanabilelim)

Hibernate: create table questions (ques_id integer not null auto_increment, ans integer not null, chose integer not null, optiona varchar(255), optionb varchar(255), optionc varchar(255), title varchar(255), primary key (ques_id)) engine=InnoDB

Hibernate: create table results (id integer not null auto_increment, total_correct integer not null, username varchar(255), primary key (id)) engine=InnoDB
