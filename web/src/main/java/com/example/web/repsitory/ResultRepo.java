package com.example.web.repsitory;

import com.example.web.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {
}
/*
ResultRepo Arabirimi:
Bu, bir Java arayüzüdür (interface) ve JpaRepository arabirimini genişletir.
JpaRepository, Spring Data JPA tarafından sağlanan bir arabirimdir ve temel CRUD (Create, Read, Update, Delete)
işlemlerini gerçekleştirmek için kullanılır.
JpaRepository, veritabanı işlemlerini otomatik olarak sağlar ve sorgu yöntemleri oluşturmanıza olanak tanır.

Result ve Integer Argümanları:
JpaRepository'nin iki parametre alır.
İlk parametre, bu arabirimin hangi veri türüyle çalışacağını belirtir.
Bu durumda, Result sınıfıyla çalışacaktır. İkinci parametre ise birincil anahtarın (primary key) veri türünü belirtir. Bu durumda, Integer tipi kullanılır, çünkü Result sınıfındaki id alanı birincil anahtardır ve tamsayıdır.
*/