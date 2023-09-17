package com.example.web.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

/*
Spring Framework’te özel olarak yapılan işlem kümelerini işaretlemek için uygulama genelinde @Component’i kullanırız.
Spring Framework, @Service ve @Repository’yi @Component ile kaydeder.
@Component ile kayıtlı olanlar aynı zamanda ApplicationContext’te kayıtlıdır.

Java sınıfını işaretlemek için kullanılır.
*/
@Component
/*@Entity Anotasyonu:
Bu anotasyon, sınıfın bir JPA (Java Persistence API) varlığı (entity) olduğunu belirtir.
Yani bu sınıf, veritabanında saklanabilir ve ilişkilendirilebilir verileri temsil eder.
JPA, Java uygulamalarının ilişkisel veritabanlarıyla etkileşim kurmasını sağlayan bir teknolojidir.
 */
@Entity
/* @Table Anotasyonu:
Bu anotasyon, veritabanında bu sınıfın karşılık geldiği tablonun adını belirtir
 */
@Table(name = "questions")
public class Question { //bir sınav sorusunun verilerini saklamak için kullanılır.

    /* @Id anotasyonu, bir alanın birincil anahtar (primary key) olduğunu belirtir.
    Bu alan, veritabanındaki kayıtları benzersiz bir şekilde tanımlar.
    @GeneratedValue anotasyonu, birincil anahtarın nasıl otomatik olarak oluşturulacağını belirtir.
    GenerationType.IDENTITY kullanıldığında, birincil anahtar veritabanı tarafından otomatik olarak artırılır.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quesId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private int ans; // Doğru cevabın indeksini (optionA=0, optionB=1, optionC=2 gibi) temsil eder.
    private int chose; // Kullanıcının seçtiği cevabın indeksini saklar (kullanıcının yanıtı).

    public Question() {
        super();
    }

    public Question(int quesId, String title, String optionA, String optionB, String optionC, int ans, int chose) {
        super();
        this.quesId = quesId;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.ans = ans;
        this.chose = chose;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public int getChose() {
        return chose;
    }

    public void setChose(int chose) {
        this.chose = chose;
    }

    @Override
    public String toString() {
        return "Question{" +
                "quesId=" + quesId +
                ", title='" + title + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", ans=" + ans +
                ", chose=" + chose +
                '}';
    }
}
