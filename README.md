# Question-App

Proje oluştururken https://start.spring.io/  Spring initializr dan seçtiklerim

*Project :* Maven 

*Language :* Java

*Spring Boot :* 3.1.3

*Packaging :* jar

*Java :* 17

*Dependencies :* Web, Thymeleaf, Spring DevTools,  Spring Data JPA, MySql (kullandığım dependenciesler bunlar eğer ki sonradan eklenmesi gereken olursa https://mvnrepository.com/ sitesinden pom.xml dosyasına eklenebilir. pom.xml dosyasına ekledikten sonra pom.xml dosyasına çift tıklayıp Maven -> Reload Project'e tıklanmalı)

### http://localhost:8109/

Quiz'e başlamadan önce isim soy isim girilmeli

![Screen Shot 2023-09-17 at 23 06 31](https://github.com/edakass/Question-App/assets/61595808/9e17475e-6a35-4e08-9eab-12f18f3ad537)

Eğer isim boş girilirse 

![Screen Shot 2023-09-17 at 23 06 36](https://github.com/edakass/Question-App/assets/61595808/bed95ebb-ece1-4d02-a948-042ddec080ad)

### http://localhost:8109/quiz

![Screen Shot 2023-09-17 at 23 06 56](https://github.com/edakass/Question-App/assets/61595808/b0195df7-1cfb-4f95-8ee6-ee04147feb7d)

![Screen Shot 2023-09-17 at 23 07 00](https://github.com/edakass/Question-App/assets/61595808/2b39bef3-b759-4c21-afc9-2820355e21c7)

### http://localhost:8109/submit

![Screen Shot 2023-09-17 at 23 14 45](https://github.com/edakass/Question-App/assets/61595808/2213a233-0a47-4d3c-bfb8-8f55e43ba1ab)


### http://localhost:8109/score

![Screen Shot 2023-09-17 at 23 07 34](https://github.com/edakass/Question-App/assets/61595808/d9fd39e4-8a26-4848-94c0-fc591aca7b34)


- @Component  https://www.baeldung.com/spring-component-annotation

1- Bileşen (Component) Nedir?:

    Bir yazılım uygulaması, farklı işlevlere sahip parçalardan oluşur. Örneğin, bir çevrimiçi alışveriş uygulaması ürünleri göstermek, sepeti yönetmek, kullanıcıları yetkilendirmek gibi farklı işlevlere sahiptir. Bu işlevleri yürüten her parça bir "bileşen" olabilir.
    Bu bileşenler, uygulamanın farklı bölümlerinde kullanılabilir ve farklı işlevleri yerine getirir.

2- @Component Ne İşe Yarar?:

    @Component, bir Java sınıfının bir "Spring bileşeni" olduğunu belirtmek için kullanılan bir işarettir.
    
    Bir sınıfa @Component anotasyonu eklenirse, bu sınıf Spring Framework tarafından yönetilen ve kullanılan bir bileşen haline gelir.
    
    Bu bileşenler, Spring tarafından otomatik olarak oluşturulabilir, yönetilebilir ve kullanılabilir.
    
3 - Bileşenlerin Avantajları:

    Bileşenler, kodu mantıklı ve düzenli bir şekilde bölmenize yardımcı olur. Her bileşen belirli bir işlevi yerine getirir.
    
    Bileşenler, bağımlılıkları (dependency) enjekte ederek işbirliği yapabilir. Yani bir bileşen, diğer bileşenlerle iletişim kurabilir ve onları kullanabilir.
   
    Bileşenler, uygulama mantığını daha anlaşılır ve bakımı daha kolay hale getirir.
    
    Bileşenler, yeniden kullanılabilirlik sağlar. Aynı bileşenleri farklı bölgelerde uygulamanızda tekrar kullanabilirsiniz.

Örnek bir senaryo düşünün: Bir çevrimiçi alışveriş uygulamasında "Ürün Yönetimi" ve "Kullanıcı Yönetimi" işlevleri bulunuyor. Her işlev kendi bileşenine sahip olabilir ve bu bileşenler, bu işlevleri yerine getirmek için kullanılabilir.
```
@Component
public class ProductManagementComponent {
    // Ürün yönetimi işlevlerini gerçekleştiren bileşen
} 
```

```@Component
public class UserManagementComponent {
   // Kullanıcı yönetimi işlevlerini gerçekleştiren bileşen
}
```


Bu bileşenler, Spring tarafından otomatik olarak oluşturulur ve Spring konteyneri tarafından yönetilir. Başka bileşenlerle işbirliği yapabilirler ve uygulama mantığını daha modüler hale getirirler. Bu sayede her işlevi ayrı ayrı geliştirmek ve bakımını yapmak daha kolay hale gelir.

-

```
Hibernate: create table questions (ques_id integer not null auto_increment, ans integer not null, chose integer not null, optiona varchar(255), optionb varchar(255), optionc varchar(255), title varchar(255), primary key (ques_id)) engine=InnoDB
```

```
Hibernate: create table results (id integer not null auto_increment, total_correct integer not null, username varchar(255), primary key (id)) engine=InnoDB
```
