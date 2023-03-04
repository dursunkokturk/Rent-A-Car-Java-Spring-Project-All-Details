package kodlama.io.Rent_A_Car.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Modelin id , name ve 
// Marka Isim Bilgisni Aliyoruz
public class GetAllModelsResponse {
	private int id;
	private String name;
	private String brandName;
	
	// Database Icinde Yeni Bir Alan Ekleme Islemi Yapilirsa
	// Database Icinde Eklenen Alanin Ismini Bu Class Icinde Belirmek Yeterli Oluyor
}