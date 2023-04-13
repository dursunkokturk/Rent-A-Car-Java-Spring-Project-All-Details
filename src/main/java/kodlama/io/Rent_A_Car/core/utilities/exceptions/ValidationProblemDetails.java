package kodlama.io.Rent_A_Car.core.utilities.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Validation Hatalarini Yazdirmak Icin Kullaniyoruz
public class ValidationProblemDetails extends ProblemDetails{
	
	// HashMap Kullanarak Hangi Alanda Hangi Hata Oldugunu Yonetiyoruz
	private Map<String, String> validationErrors;
}