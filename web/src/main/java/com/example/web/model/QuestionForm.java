package com.example.web.model;


import org.springframework.stereotype.Component;

import java.util.List;

/* @Component anotasyonu sınıf düzeyinde kullanılır.
Yani, bir sınıfın başına eklenir ve o sınıfın bir bileşen olduğunu belirtir.
Sonuç olarak, @Component anotasyonu, Spring konteynerine bir sınıfın bir bileşen olduğunu belirtmek için kullanılır
ve bu sayede bu sınıfın örnekleri Spring tarafından otomatik olarak yönetilir.
Bu, Spring uygulamalarında bileşenlerin (servisler, denetleyiciler, vb.) oluşturulması ve
kullanılması için temel bir yapı taşıdır.

Spring Framework'te özel olarak yapılan işlem kümelerini işaretlemek için uygulama genelinde @Component'i kullanırız.

@Component: Bu anotasyon, bir sınıfın bir parçası olduğunu belirtir.
@Controller, @Service ve @Repository gibi diğer anotasyonlar, @Component anotasyonunun bir alt kümesidir.
Bu anotasyonu, uygulamanızda kullanabileceğiniz diğer sınıflar için kullanabilirsiniz
 */
@Component
public class QuestionForm {

    /* private List<Question> questions;
    Bu sınıfın özel (private) bir alanıdır ve questions adında bir liste (List) nesnesini temsil eder.
    Bu liste, Question sınıfının nesnelerini içerir. Yani bu sınıf, bir dizi soruyu tutmak için kullanılır.
     */
    private List<Question> questions;

    /*g etQuestions() Metodu:
    Bu metot, questions alanını döndürür. Bu sayede dışarıdan bu sınıfın içindeki sorulara erişilebilir.
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /* setQuestions(List<Question> questions) Metodu:
    Bu metot, questions alanını ayarlamak için kullanılır. Yani dışarıdan bir liste alır ve bu listeyi questions alanına atar.
    Bu metot, bu sınıfın questions alanını doldurmak için kullanılır.
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;

    }
}
