package com.example.web.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
/* @Entity anotasyonu, sınıfın bir JPA (Java Persistence API) varlığı (entity) olduğunu belirtir.
Yani bu sınıf, veritabanında saklanabilir ve ilişkilendirilebilir verileri temsil eder.
 */
@Entity
/* @Table anotasyonu, veritabanında bu sınıfın karşılık geldiği tablonun adını belirtir.
Bu örnekte, "results" adlı bir tabloya karşılık geldiği belirtilmiştir.
 */
@Table(name = "results")
public class Result { // Bu sınıfın amacı, kullanıcıların sınav sonuçlarını saklamak için kullanılır.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private int totalCorrect = 0;

    public Result() {
        super();
    }

    public Result(int id, String username, int totalCorrect) {
        this.id = id;
        this.username = username;
        this.totalCorrect = totalCorrect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", totalCorrect=" + totalCorrect +
                '}';
    }

    /*
    toString() Metodu:
    Bu metot, sınıfın nesnesinin metinsel temsilini döndürür.
    Bu genellikle hata ayıklama ve kayıtları görüntüleme amaçları için kullanılır.
     */
}
