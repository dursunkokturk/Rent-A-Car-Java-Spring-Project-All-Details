package kodlama.io.Rent_A_Car.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Brand Class i Icindeki Ozelliklere Atanan Degerleri 
// Database Icindeki Tablolar Ile Eslestirme Yapiyoruz
// javax.persistence.Table Ozelligini import Etmek Gerekiyor
@Table(name="models")

// Class Icindeki Ozelliklerin Get ve Set Fonksiyonlarini
// Arka Planda Otomatik Olarak Olusturuyoruz
// lombok.Data import Etmek Gerekiyor
@Data

// Class tan Sonra Olusturulmasi Gereken 
// Parametresiz Constructor i Arka Planda 
// Otomatik Olarak Olusturuyoruz
// lombok.NoArgsConstructor import Etmek Gerekiyor
@NoArgsConstructor

// Class tan Sonra Olusturulmasi Gereken 
// Parametreli Constructor i Arka Planda 
// Otomatik Olarak Olusturuyoruz
// lombok.AllArgsConstructor import Etmek Gerekiyor
@AllArgsConstructor

// Class Icindeki Ozelliklerin 
// Database Objesine Ait Oldugunu Belirtiyoruz
// javax.persistence.Entity import Etmek Gerekiyor
@Entity
public class Model {
	// Database Icindeki Primary Key Alani Oldugunu Belirtiyoruz
	// javax.persistence.Id import Etmek Gerekiyor
	@Id
	
	// Database Icinde Data Eklendiginde id Bilgisine Otomatik Olarak Atanan Degerin 
	// Otomatik Olarak Tek Tek Artirilmasini Saglar
	// javax.persistence.GeneratedValue import Etmek Gerekiyor
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// Class Icindeki Ozellige Gonderilen Degerin Database Icinde
	// Hangi Sutuna Karsilik Geldigini Belirtiyoruz
	// javax.persistence.Column import Etmek Gerekiyor
	@Column(name="id")
	private int id;
		
	// Class Icindeki Ozellige Gonderilen Degerin Database Icinde
	// Hangi Sutuna Karsilik Geldigini Belirtiyoruz
	// javax.persistence.Column import Etmek Gerekiyor
	@Column(name="name")
	private String name;
	
	
	// Birden Fazla Modeli Olan Bir Marka Olabilir
	@ManyToOne
	
	// Brand Class i Ile Model Class i Arasindaki 
	// Baglantinin Kodlama Ekraninda 
	// Database Dahil Edilerek Nasil Olacagini Belirtiyoruz
	@JoinColumn(name="brand_id")
		
	// Modellerin 1 Tane Markasi Olur
	// Class Yapisi Icinde Brand Class i Icindeki 
	// Model Listesi Ile Arasinda Baglanti Olusturuyoruz
	private Brand brand;
	
	// Model Sutunu Ile Car Listesi Arasinda
	// Database Baglantisini Kod Ekraninda Kuruyoruz
	@OneToMany(mappedBy="model")
	private List<Car> cars;
}