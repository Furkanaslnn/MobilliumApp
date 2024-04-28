# Mobillium Android Staj Challenge #1 - Şifre Oluşturucu

## Giriş

Şifre Oluşturucu, mobil cihazlar için pratik bir uygulamadır. Kullanıcılar, uygulamaya kayıt olduktan sonra özelleştirilmiş şifreler oluşturabilir ve güvenli bir şekilde saklayabilirler.

## Genel Bakış

Şifre Oluşturucu, kullanıcıların karmaşık ve güvenli şifreler oluşturarak çevrimiçi hesaplarını korumalarına yardımcı olur. Günümüzde, birçok platformun güvenlik önlemleri arttığı için güçlü şifreler kullanmak önemlidir. Ancak, bu şifreleri hatırlamak zor olabilir. Şifre Oluşturucu, bu sorunu çözmek için kullanıcılara rastgele şifreler oluşturma ve bunları güvenli bir şekilde saklama imkanı sunar.

## Özellikler

- **Kayıt Ekranı:** Kullanıcılar, uygulamaya kaydolduktan sonra kişisel hesaplarını oluşturabilirler.
- **Şifre Oluşturma Ekranı:** Kullanıcılar, özelleştirilmiş şifreler oluşturmak için farklı platformlar için adlandırılmış şifreler seçebilirler.
- **Rastgele Şifre Oluşturma:** Her tıklamada farklı bir şifre üretilir, böylece kullanıcılar her defasında güçlü bir şifre elde ederler.
- **Şifre Saklama:** Oluşturulan şifreler güvenli bir veritabanında saklanır.
- **Şifreleri Gösterme:** Kullanıcılar, tüm kaydedilmiş şifreleri bir listede görüntüleyebilirler.
- **Şifre Arama:** Kullanıcılar, şifre adı veya platforma göre şifreleri arayabilirler.

## Kullanılan Teknolojiler

- Android Studio IDE
- Kotlin Programlama Dili
- SQLite Veritabanı

## Övünme

Geliştirme sürecinde veritabanına farklı kullanıcılar açmak ve şifreleri kaydetmek konusunda sıkıntılar yaşadım bu sıkıntıları youtube, udemy, forumlar, vb. gibi farklı eğitim platformlarından araştırarak sorunlarımı çözmeye çalıştım.

## Ekran Görüntüleri
- Uygulamamızı başlattığımızda karşımıza login ekranımız geliyor. Burada hesabımız yok ise sign in diyerek kayıt olma ekranına geçebiliriz.
- ![loginScreen](/EkranGörüntüleri/loginScreen.png)
- Sign in ekranımızda kullanıcı adı ve şifre oluşturarak kayıt olalım.
- ![SignInScreen](/EkranGörüntüleri/SignInScreen.png)
- Başarılı bir şekilde kayıt olduk mesajını alıyoruz.
- ![SignIn](/EkranGörüntüleri/SignIn.png)
- Login ekranımıza dönüp yanlış bi şifre ile girmeyi deneyelim hata alacağız.
- ![wrongPassword](/EkranGörüntüleri/wrongPassword.png)
- Kayıt olduğumuz kullanıcı adı ve parola ile giriş yaptıktan sonra menu ekranı gelecektir. Buradan şifre oluşturmak için Create Password Butonuna tıklayalım.
- ![Menu](/EkranGörüntüleri/Menu.png)
- Şifre ismimizi belirttikten sonra change butonu ile oluşturmak istediğimiz random parolalar arasında seçim yapalım ve kayıt et butonuna basalım.
- ![CreatePassword](/EkranGörüntüleri/CreatePassword.png)
- Menu ekranına dönüp Show Password butonuna bastıktan sonra oluşturduğumuz şifreler burada görüntülenecekler.
- ![ShowPassword](/EkranGörüntüleri/ShowPassword.png)
- Eğer istediğimiz şifreyi aramak istersek search kutucuğuna şifre adını yazmamız yeterli olacaktır.
- ![SearchPassword](/EkranGörüntüleri/SearchPassword.png)
- ![SearchPassword2](/EkranGörüntüleri/SearchPassword2.png)

## App İçerisinden Örnek Gif
![Uygulama Örneği](/EkranGörüntüleri/example.gif)

