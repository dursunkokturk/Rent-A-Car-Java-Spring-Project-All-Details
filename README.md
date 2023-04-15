# Rent-A-Car-Java-Spring-Project

Bu projede katmanlı mimari kullanılmıştır.

Entity katmanı altındaki Brand dosyası içinde 
Database bağlantısı ve bu bağlantı için gereken isterler girişmiştir.

@Table Kullanılarak
Brand Class i Icindeki Ozelliklere Atanan Degerleri 
Database Icindeki Tablolar Ile Eslestirme Yapmak Icin
javax.persistence.Table Ozelligini import Etmek Gerekiyor

@Data kullanılarak
Class Icindeki Ozelliklerin Get ve Set Fonksiyonlarini
Arka Planda Otomatik Olarak Olusturuyoruz
lombok.Data import Etmek Gerekiyor

@NoArgsConstructor kullanılarak
Class tan Sonra Olusturulmasi Gereken 
Parametresiz Constructor i Arka Planda 
Otomatik Olarak Olusturuyoruz
lombok.NoArgsConstructor import Etmek Gerekiyor

@AllArgsConstructor kullanılarak
Class tan Sonra Olusturulmasi Gereken 
Parametreli Constructor i Arka Planda 
Otomatik Olarak Olusturuyoruz
lombok.AllArgsConstructor import Etmek Gerekiyor

@Entity kullanılarak
Class Icindeki Ozelliklerin 
Database Objesine Ait Oldugunu Belirtiyoruz
javax.persistence.Entity import Etmek Gerekiyor

Brand Class içinde;
@Id kullanılarak
Database Icindeki Primary Key Alani Oldugunu Belirtiyoruz
javax.persistence.Id import Etmek Gerekiyor

@GeneratedValue(strategy = GenerationType.IDENTITY) kullanılarak
Database Icinde Data Eklendiginde id Bilgisine Otomatik Olarak Atanan Degerin 
Otomatik Olarak Tek Tek Artirilmasini Saglar
javax.persistence.GeneratedValue import Etmek Gerekiyor
	
@Column(name="id") kullanılarak
Class Icindeki Ozellige Gonderilen Degerin Database Icinde
Hangi Sutuna Karsilik Geldigini Belirtiyoruz
javax.persistence.Column import Etmek Gerekiyor
	
@Column(name="name") kullanılarak
Class Icindeki Ozellige Gonderilen Degerin Database Icinde
Hangi Sutuna Karsilik Geldigini Belirtiyoruz
javax.persistence.Column import Etmek Gerekiyor
	
@OneToMany(mappedBy = "brand") kullanılarak
Bir Tane Markanin Bir Den Fazla Modeli Olabilir
Birden Fazla Secenegin Hangi Sutun Ile Esleyecegini 
OneToMany Anotasyonu Icinde Belirtiyoruz
	
List<Model> models; kullanılarak
Markaya Ait Modeller Listesini
Class Yapisi Icinde Olsturuyoruz
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Entities Katmanı altındaki Concretes katmanı altında Model dosyası içinde

@Table(name="models") kullanılarak
Brand Class i Icindeki Ozelliklere Atanan Degerleri 
Database Icindeki Tablolar Ile Eslestirme Yapiyoruz
javax.persistence.Table Ozelligini import Etmek Gerekiyor

@Data kullanılarak
Class Icindeki Ozelliklerin Get ve Set Fonksiyonlarini
Arka Planda Otomatik Olarak Olusturuyoruz
lombok.Data import Etmek Gerekiyor

@NoArgsConstructor kullanılarak
Class tan Sonra Olusturulmasi Gereken 
Parametresiz Constructor i Arka Planda 
Otomatik Olarak Olusturuyoruz
lombok.NoArgsConstructor import Etmek Gerekiyor

@AllArgsConstructor kullanılarak
Class tan Sonra Olusturulmasi Gereken 
Parametreli Constructor i Arka Planda 
Otomatik Olarak Olusturuyoruz
lombok.AllArgsConstructor import Etmek Gerekiyor

@Entity kullanılarak
Class Icindeki Ozelliklerin 
Database Objesine Ait Oldugunu Belirtiyoruz
javax.persistence.Entity import Etmek Gerekiyor

Model Class ı içinde;

@Id kullanılarak
Database Icindeki Primary Key Alani Oldugunu Belirtiyoruz
javax.persistence.Id import Etmek Gerekiyor
	
@GeneratedValue(strategy = GenerationType.IDENTITY) kullanılarak
Database Icinde Data Eklendiginde id Bilgisine Otomatik Olarak Atanan Degerin 
Otomatik Olarak Tek Tek Artirilmasini Saglar
javax.persistence.GeneratedValue import Etmek Gerekiyor
	
@Column(name="id") kullanılarak
Class Icindeki Ozellige Gonderilen Degerin Database Icinde
Hangi Sutuna Karsilik Geldigini Belirtiyoruz
javax.persistence.Column import Etmek Gerekiyor

@Column(name="name") kullanılarak
Class Icindeki Ozellige Gonderilen Degerin Database Icinde
Hangi Sutuna Karsilik Geldigini Belirtiyoruz
javax.persistence.Column import Etmek Gerekiyor

@ManyToOne kullanılarak
Birden Fazla Modeli Olan Bir Marka Olabilir
	
@JoinColumn(name="brand_id") kullanılarak
Brand Class i Ile Model Class i Arasindaki 
Baglantinin Kodlama Ekraninda 
Database Dahil Edilerek Nasil Olacagini Belirtiyoruz
	
private Brand brand; kullanılarak	
Modellerin 1 Tane Markasi Olur
Class Yapisi Icinde Brand Class i Icindeki 
Model Listesi Ile Arasinda Baglanti Olusturuyoruz
	
@OneToMany(mappedBy="model")
private List<Car> cars; kullanılarak
Model Sutunu Ile Car Listesi Arasinda
Database Baglantisini Kod Ekraninda Kuruyoruz
	
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Database bağlantısında Brands ve Models arasında OneToMany Anotasyonu kullanılmıştır.
Modellerin listelenmesi için List yapısı kullanılmıştır.

Entity katmanı altındaki Car Class içinde;
Brand id bilgisine göre aracın plaka, fiyat, model, kiralanabilir durumda olup olmadığı bilgilerini alıyoruz.

Entity katmanı altındaki Model Class içinde;
Brand id bilgisine göre aracın model bilgisini List yapısını kullanrak listeliyoruz.
