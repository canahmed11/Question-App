package com.example.web.service;

import com.example.web.model.Question;
import com.example.web.model.Result;
import com.example.web.model.QuestionForm;
import com.example.web.repsitory.QuestionRepo;
import com.example.web.repsitory.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    /* @Autowired anotasyonları, Spring tarafından otomatik olarak bağımlılıkları enjekte etmek için kullanılır.
    Bu sayede Question, QuestionForm, QuestionRepo, Result ve ResultRepo gibi sınıfların örnekleri bu sınıfa enjekte edilir.
     */
    @Autowired
    Question  question;

    @Autowired
    QuestionForm questionForm;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    Result result;

    @Autowired
    ResultRepo resultRepo;

    /* Bu metod, rastgele 5 soru seçmek için kullanılır.
    QuestionRepo kullanarak tüm soruları alır.
    Ardından rastgele beş soru seçer ve bu soruları bir liste olarak döndürür.
     */
    public QuestionForm getQuestions() {
        List<Question> allQuestions = questionRepo.findAll();
        List<Question> questionList = new ArrayList<Question>();

        Random random = new Random();

        for(int i=0; i<5; i++) {
            int rand = random.nextInt(allQuestions.size());
            questionList.add(allQuestions.get(rand));
            allQuestions.remove(rand);
        }

        questionForm.setQuestions(questionList);

        return questionForm;
    }
    /*
    getResult(QuestionForm questionForm)
    Bu metod, kullanıcının cevaplarını değerlendirir ve kaç doğru cevap verdiğini hesaplar.
    Her soru için kullanıcının verdiği cevabı, sorunun doğru cevabıyla karşılaştırarak doğru cevap sayısını hesaplar.
     */
    public int getResult(QuestionForm questionForm) {
        int correct = 0;

        for (Question q : questionForm.getQuestions()) {
            if(q.getAns() == q.getChose()) {
                correct++;
            }
        }

        return correct;
    }

    /* saveScore(Result result) Metodu:
    Bu metod, kullanıcının sınav sonucunu kaydeder.
    Result sınıfından bir nesne oluşturur, kullanıcı adını ve doğru cevap sayısını bu nesneye atar ve
    bu nesneyi resultRepo kullanarak veritabanına kaydeder.
     */
    public void saveScore(Result result) {
        Result saveResult = new Result();
        saveResult.setUsername(result.getUsername());
        saveResult.setTotalCorrect(result.getTotalCorrect());
        resultRepo.save(saveResult);
    }

    /* getTopScore() Metodu:
    Bu metod, en yüksek puanları elde etmiş kullanıcıların listesini alır.
    ResultRepo kullanarak puanları totalCorrect (toplam doğru cevap) sırasına göre sıralar ve sıralı listeyi döndürür.
    DESC : fazladan aza göre sıralama
     */
    public List<Result> getTopScore() {
        List<Result> scoreList = resultRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));

        return scoreList;
    }
}
/* Bu denetleyici sınıfı, kullanıcıların sınavı başlatmasını,
sınavı tamamlamasını ve sonuçlarını görüntülemesini sağlar.
QuizService sınıfı, sınav işlevselliğini gerçekleştirmek için kullanılır ve
 bu denetleyici sınıfı ile işbirliği yapar. Sayfaların yönlendirilmesi ve
 kullanıcı girişi doğrulaması gibi işlemler bu denetleyici tarafından yönetilir.
 */