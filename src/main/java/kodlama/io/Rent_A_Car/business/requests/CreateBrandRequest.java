package kodlama.io.Rent_A_Car.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Son Kullaninin Database Icinde Yer Alan Tum Bilgileri Gormesini
// Engellemek Icin Response Request Pattern Kullaniyoruz

// Son Kullanicinin Ulasabileceklerinin Yetkisini 
// Request Alaninda Tanimliyoruz

// Database Icinde Yeni Bir Data Olusturma Islemi Yapiyoruz
// Data Olusturma Isleminden Sonra Id Bilgisi Database Icinde Otomatik Olarak
// Verilecek
public class CreateBrandRequest {
	private String name;
}