# TurnuvaSistemi
Farklı modlar ile Turnuva kura belirleme sistemi
Eleme modu Burak GÖĞÜŞ tarafından kodlanmıştır.
Turnuva sistemi projesinde Eleme modunu ben (Burak GÖĞÜŞ/50160076082) kodladım ve arayüzünü oluşturdum.Eleme modunda ve diğer modlarda mariadb 2.5.4 kullanılmıştır.
Server olarak Glassfish 4.1.1 kullanılmıştır.Kullanılan veritabanı jar dosyası ve server klasörü proje dosyaları içinde eksiksiz vardır ve herhangi bir sorun olmadan çalışmaktadır.
 .git uzantılı dosya ve veritabanı dump edilip klasöre eklenmiştir.Projede kullanılan jar dosyası da yine klasör içerisinide bulunmaktadır.
	Many-to-Many ve one to many kodlaması tamamlanmıştır."dao" paketinin içinde bulunan elemeDAO classının içinde get kazananlar listesini oluşturup takım find ile de takımların belirlenmesini tamamladım. elemesonucDAO'da findAl metodunda kazananlar ile gerekli olan işlemleri yaptım. 
Gerekli veritabanındaki verileri eşleştirmiştir.Controller ve db kodlarında herhangi bir eksik yoktur.
Ancak eleme modundaki eşleşmenin gerçekleşmesi için 2 ayrı seçenek vardır.Şuan eleme modunda bu seçenekten birisi olan rastgele fikstür belirleme olduğu için ekrana random bir şekilde
fikstür belirleniyor.Eğer 2. bir mod olarak kullanılmak istenirse de kazananlar tablosunda kazananlar belirlenebiliyor.Arkaplanda çalışan kodlarda da bunu görebilirsiniz.
	Eleme modunda tüm crud işlemleri gerçekleştirilmiştir ve kodlanmıştır.Tüm işlemler eksiksiz ve herhangi bir hata yaşamadan çalışmaktadır.Arayüzde ve classlarda gerekli kodlar bulunmaktadır.Eleme tablosunun kontrollünü controller paketinin içinde bulunan elemeController sınıfında kodlandı.
ElemeSonuc tablosu için yine aynı paket içinde bulunan elemesonucController sınıfında kodlanmıştır.
Tekil okuma işlemini arayüzdeki "Şampiyon" bölümünde kullanılmıştır(index.xhtml). "elemeDAO" sınıfında tekil okuma metodu bulunmaktadır.
	Filter olarak eleme modunun nasıl çalıştığı hakkında bilgi veren bir filter metodu kullanılmıştır.Böylece mod hakkında gerekli bilgilere ulaşılabilir.
	Ajax isteklerinin tümü gerçekleşmiştir.Arayüzde bulunan tüm butonlar için gerçekleştirilip diğer classlar da düzeltme işlemi yapılmıştır.
Ajax isteğiyle örneğin sil butonuna taklandığında takımı silinmesi için gelen uyarıyı confirm_delete.xhtml ile kontrolü sağlanmıştır.
	Xhtml validator olarak index.xhtml'de bulunan ekle ve güncelle butonunda kullanımı sağlanmıştır.Takım adının girişinde validatör yardımıyla gerekli olan kurallar doğrultusunda ekleme ve güncelleme yapılmaktadır.Validatör için yine index.xhtml sınıfında gereken fonksiyon yazılmıştır.
Java Bean Validator controller paketinde bulunan tüm controller sınıfları ile yazılmıştır.
	Pagination işlemleri anasayfadaki her mod geçişler için ayrı ayrı url oluşturmuştuk zaten burada da anasayfaya dönmek için gerekli olan işlem yapılmıştır.İndex.xhtml sınıfında kullanılmıştır.
Eşleştirme metodları Controller paketinde bulunan turController.java sınıfında turlist ve turlist2 listeleri ile veritabanına bağlantısı için gerekli yönlendirmeleri yapıyor.Eşleştirme metodunun veritabanındaki bağlantısı ve eşleştirme için gerekli fonksiyonların bulunduğu class ise dao paketinin
içinde bulunan turDAO.java classında gerçekleşiyor.
Eşleştirme sonrası olan maç fikstürlerini de önceden belirlenmiş olan turnuva kuralları doğrultusunda veri tabanından maç sırası değişecek şekilde rastgele olarak arayüze bağlantısını gerçekleştiriyor.
	Not: Projede herhangi bir kodlama veya mantık hatası olmamasına rağmen (tüm kod blokları test edilmiştir) bazen site içerisinde yapılan bir kaç işlem sonrası server kaynaklı "nullpointer" hatası veriyor.Örnek olarak takım ekleyip kura çektiğimiz zaman veritabanı işlemlerini hatasız gerçekleştiriyor ancak 
sitede hata veriyor.Siteyi birkaç kez yenilediğimizde sorunsuz tüm işlemler yapıldığı görülüyor. Dikkate alırsanız sevinirim.
