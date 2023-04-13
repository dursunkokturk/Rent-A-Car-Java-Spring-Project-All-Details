package kodlama.io.Rent_A_Car.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Brand Class i Icindeki Ozelliklere Atanan Degerleri 
//Database Icindeki Tablolar Ile Eslestirme Yapiyoruz
//javax.persistence.Table Ozelligini import Etmek Gerekiyor
@Table(name="cars")

//Class Icindeki Ozelliklerin Get ve Set Fonksiyonlarini
//Arka Planda Otomatik Olarak Olusturuyoruz
//lombok.Data import Etmek Gerekiyor
@Data

//Class tan Sonra Olusturulmasi Gereken 
//Parametresiz Constructor i Arka Planda 
//Otomatik Olarak Olusturuyoruz
//lombok.NoArgsConstructor import Etmek Gerekiyor
@NoArgsConstructor

//Class tan Sonra Olusturulmasi Gereken 
//Parametreli Constructor i Arka Planda 
//Otomatik Olarak Olusturuyoruz
//lombok.AllArgsConstructor import Etmek Gerekiyor
@AllArgsConstructor

//Class Icindeki Ozelliklerin 
//Database Objesine Ait Oldugunu Belirtiyoruz
//javax.persistence.Entity import Etmek Gerekiyor
@Entity
public class Car {
	
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
	@Column(name="plate")
	private String plate;
	
	// Class Icindeki Ozellige Gonderilen Degerin Database Icinde
	// Hangi Sutuna Karsilik Geldigini Belirtiyoruz
	// javax.persistence.Column import Etmek Gerekiyor
	@Column(name="daily_price")
	private double dailyPrice;
	
	// Class Icindeki Ozellige Gonderilen Degerin Database Icinde
	// Hangi Sutuna Karsilik Geldigini Belirtiyoruz
	// javax.persistence.Column import Etmek Gerekiyor
	@Column(name="model_year")
	private int modelYear;
	
	// Class Icindeki Ozellige Gonderilen Degerin Database Icinde
	// Hangi Sutuna Karsilik Geldigini Belirtiyoruz
	// javax.persistence.Column import Etmek Gerekiyor
	@Column(name="state")
	private int state;
	
	// Modellerin Bir Tane Markasi Olur
	@ManyToOne
	
	
	// Arabanin Modeli Olur
	
	// Car Class i Ile Model Class i Arasindaki 
	// Baglantinin Kodlama Ekraninda 
	// Database Dahil Edilerek Nasil Olacagini Belirtiyoruz
	@JoinColumn(name="model_id")
	private Model model;
}