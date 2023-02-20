package kodlama.io.Rent_A_Car.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

// Son Kullanicinin Ulasabileceklerinin Yetkisini 
// Response Alaninda Tanimliyoruz
public class GetAllBrandsResponse {
	private int id;
	private String name;
}