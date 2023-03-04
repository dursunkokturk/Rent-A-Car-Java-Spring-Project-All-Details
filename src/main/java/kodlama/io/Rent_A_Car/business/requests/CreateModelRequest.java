package kodlama.io.Rent_A_Car.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
	
	// Database Icine Data Girilmeyi 
	// Zorunlu Hale Getirme Islemi Yapiyoruz
	@NotNull
	
	// Data Girilirken Bosluk Karakteri Olusmasini Engelliyoruz
	@NotBlank
	
	// Data Girilirken Girilecek Karakter Sayisinin 
	// En Az Ve 
	// En Cok Kac Karakter Olacagini Belirtiyoruz
	@Size(min = 3, max = 20)
	private String name;
	
	// Database Icine Data Girilmeyi 
	// Zorunlu Hale Getirme Islemi Yapiyoruz
	@NotNull
	
	// Data Girilirken Bosluk Karakteri Olusmasini Engelliyoruz
	@NotBlank
	
	// Yeni Bir Model Eklendiginde Marka Id Bilgisini Ekliyoruz
	private int brandId;
}