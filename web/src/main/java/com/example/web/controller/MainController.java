package com.example.web.controller;

import com.example.web.model.QuestionForm;
import com.example.web.model.Result;
import com.example.web.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
/* web uygulamasının farklı sayfaları ve işlevleri arasındaki yönlendirmeleri
ve veri işlemesini yönetir.

@Controller Anotasyonu:
Bu anotasyon, sınıfın bir Spring MVC denetleyici sınıfı olduğunu belirtir.
Spring MVC, web uygulamalarının geliştirilmesi için kullanılan bir web çerçevesidir.
 */
@Controller
public class MainController {

    @Autowired
    Result result; //Sonuç nesnesini temsil eder. Bu nesne, kullanıcının sınav sonucunu ve kullanıcı adını içerir.

    /* QuizService adlı bir servis sınıfının örneğini enjekte eder.
     Bu servis, sınav işlemlerini gerçekleştiren iş mantığını içerir. */
    @Autowired
    QuizService quizService;

    /*Kullanıcının sınavı tamamlanıp tamamlanmadığını takip etmek için kullanılan bir bayraktır.
     İlk başta false olarak ayarlanır. */
    Boolean submitted = false;

    /* @ModelAttribute("result") ile işaretlenen getResult() metodu,
    sonucu temsil eden bir nesneyi modelde döndürür.
    Bu, sonucun web sayfasında kullanılabilir hale gelmesini sağlar. */
    @ModelAttribute("result")
    public  Result getResult() {
        return result;
    }

    /* @GetMapping("/") Metodu:
    Bu metot, kök URL ("/") isteği geldiğinde çağrılır ve "index.html" sayfasını döndürür.
    Bu, ana sayfanın gösterilmesini sağlar. */
    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    /* @PostMapping("/quiz") Metodu
    Kullanıcı adını alarak ve giriş doğrulaması yaparak sınavı başlatır.
    Eğer kullanıcı adı boşsa, bir uyarı mesajı ekleyerek kullanıcıyı giriş yapmaya yönlendirir.
    Eğer kullanıcı adı geçerliyse, kullanıcının sınavını başlatır ve soruları model üzerinden "quiz.html" sayfasına aktarır. */
    @PostMapping("/quiz")
    public String quiz(@RequestParam String username, Model model, RedirectAttributes redirectAttributes) {
        if(username.equals("")) {
            redirectAttributes.addFlashAttribute("warning", "You must enter your name!");
            return  "redirect:/";
        }

        submitted = false;
        result.setUsername(username);

        QuestionForm questionForm = quizService.getQuestions();
        model.addAttribute("qForm", questionForm);

        return "quiz.html";
    }

    /* @PostMapping("/submit") Metodu:
    Kullanıcının sınavı tamamlamasını ve sonucunu işler.
    Eğer sınav daha önce gönderilmemişse (submitted == false), sonucu hesaplar,
    kaydeder ve submitted bayrağını true olarak ayarlar.
    Sonucu "result.html" sayfasına yönlendirir. */
    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionForm questionForm, Model model) {
        if(!submitted) {
            result.setTotalCorrect(quizService.getResult(questionForm));
            quizService.saveScore(result);
            submitted = true;
        }
        return "result.html";
    }

    /*
    @GetMapping("/score") Metodu:
    Kullanıcıların sıralı sonuçları görmelerini sağlar.
    quizService aracılığıyla en iyi sonuçları alır ve "scoreboard.html" sayfasına yönlendirir. */
    @GetMapping("score")
    public String score(Model model) {
        List<Result> scoreList = quizService.getTopScore();
        model.addAttribute("scoreList", scoreList);

        return "scoreboard.html";
    }
}
