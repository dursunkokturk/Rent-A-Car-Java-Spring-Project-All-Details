package kodlama.io.Rent_A_Car.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Rent_A_Car.entities.concretes.Model;

// Model Listeleme Islemini Yapmak Icin Interface Kullaniyoruz

// JpaRepository Kullanilarak Ekleme Silme Guncelleme Islemleri Icin 
// Kullanilacak Fonksiyonlar Otomatik Olarak Geliyor
// Bundan Dolayi DataAccess Katmani Altinda Concretes Katmani Altinda
// Ekleme Silme Guncelleme Fonksiyonlarinin 
// Islemlerini Barindiran Dosyaya Gerek Kalmiyor

// Interface Icinde Baska Bir Interface Icindeki Ozellikleri Kullanmak Istiyorsa
// Kullanmak Istedigi Interface i Extends Komutu Ile Baglayabiliriz

// JpaRepository deki 1. Parametre Database e Baglanti Icin Gereken Ozelliklerin Ve 
// Database Baglantisinin Yer Aldigi Class Adi

// JpaRepository deki 2. Parametre Database e Baglanti Icin Gereken Ozelliklerin Icindeki 
// id Bilgisini Class in Primary Key Degeri Olarak Kabul Ediyor

// Kabul Edilen Deger Tam Sayidir
public interface ModelRepository extends JpaRepository<Model,Integer>{

}