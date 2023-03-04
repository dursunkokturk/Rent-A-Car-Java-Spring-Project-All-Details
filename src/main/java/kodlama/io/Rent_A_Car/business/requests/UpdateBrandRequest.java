package kodlama.io.Rent_A_Car.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Secili Olan Id Ye Gore Guncelleme Islemi Yapilacak
// Data yi Getiriyoruz
public class UpdateBrandRequest {
	private int id;
	private String name;
}