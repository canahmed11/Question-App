package com.example.web.repsitory;

import com.example.web.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* @Repository Anotasyonu:
@Repository anotasyonu, Spring Framework tarafından yönetilen veritabanı işlemi yapacak sınıfları tanımlar.
Bu anotasyon, bir sınıfın veritabanı işlemlerini gerçekleştiren bir bileşen olduğunu belirtir.
@Repository anotasyonu, sınıfın otomatik olarak oluşturulmasını ve Spring konteynerine dahil edilmesini sağlar.
Bu sayede bu sınıfın veritabanı işlemleri için kullanılabilir hale gelir.
 */
@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
/*
QuestionRepo Arabirimi:
Bu, bir Java arayüzüdür (interface) ve JpaRepository arabirimini genişletir.
JpaRepository, Spring Data JPA tarafından sağlanan bir arabirimdir ve temel CRUD (Create, Read, Update, Delete)
işlemlerini gerçekleştirmek için kullanılır.
JpaRepository, veritabanı işlemlerini otomatik olarak sağlar ve sorgu yöntemleri oluşturmanıza olanak tanır.
 */

/* JpaRepository'nin iki parametre alır.
İlk parametre, bu arabirimin hangi veri türüyle çalışacağını belirtir.
Bu durumda, Question sınıfıyla çalışacaktır.
İkinci parametre ise birincil anahtarın (primary key) veri türünü belirtir.
Bu durumda, Integer tipi kullanılır, çünkü Question sınıfındaki quesId alanı birincil anahtardır ve tamsayıdır.
 */