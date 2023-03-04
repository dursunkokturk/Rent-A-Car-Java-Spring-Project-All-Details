package kodlama.io.Rent_A_Car.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Tek Bir Id ye Ait Data lari Listeleme Islemi Yapiyoruz
public class GetByIdBrandResponse {
	private int id;
	private String name;
}