package kodlama.io.Rent_A_Car;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.Rent_A_Car.core.utilities.exceptions.BusinessException;
import kodlama.io.Rent_A_Car.core.utilities.exceptions.ProblemDetails;
import kodlama.io.Rent_A_Car.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication

// Olusabilecek Hatalari Kontrol Etmek Icin
// Kullaniyoruz
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	// Hata Olursa Devreye Girmesi Gerekiyor
	@ExceptionHandler
	
	// Hata Olusursa Ekranda Gorenecek Mesaji Yazdiriyoruz
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	
	// BusinessException (Is Kurali Hatasi) Hatasi Olursa
	// ProblemDetails Fonksiyonu Calisacak
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		
		// BusinessException Hatasi Olursa
		// ProblemDetails Objesi Olusturuyoruz
		ProblemDetails problemDetails = new ProblemDetails();
		
		// ProblemDetails Objesi Uzerinden SetMessage Fonksiyonu Icinde
		// BusinessException Parametresi Uzerinden 
		// GetMessage Fonksiyonu Ile Hatayi Donduruyoruz
		// Yazdirma Islemini ProblemDetails.java Dosyasinda Yer Alan
		// ProblemDetails Class i Icinde Yapiyoruz
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
	
	// Hata Olursa Devreye Girmesi Gerekiyor
	@ExceptionHandler
	
	// Hata Olusursa Ekranda Gorenecek Mesaji Yazdiriyoruz
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	
	// MethodArgumentNotValidException (Is Kurali Hatasi) Hatasi Olursa
	// ProblemDetails Fonksiyonu Calisacak
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		// ValidationProblemDetails Hatasi Olursa
		// ValidationProblemDetails Objesi Olusturuyoruz
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		
		// ValidationProblemDetails Objesi Uzerinden SetMessage Fonksiyonu Icinde
		// Hata Mesajini Yazdiriyoruz
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		
		// ValidationProblemDetails Objesi Uzerinden SetValidationErrors Fonksiyonu Icinde
		// HashMap Objesi Ekliyoruz
		// Bu Sekilde Yapildiginda HAngi Alanda Hangi Hata Oldugunu Yonetebilir Oluyoruz
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());
		
		// Hata Olustugunda Hatalar Array Halinde Yer Aldigindan Dolayi
		// Bu Hatalari ForEaach Dongusunu Kullanarak Tarama Islemi Yapmak Gerekiyor
		
		// ProblemDetails Fonksiyonu Icindeki 
		// MethodArgumentNotValidException Parametresi Uzerinden
		// GetBindingResult Fonksiyonu Uzerinden 
		// GetFieldErrors Fonksiyonu Ile Hatalari Tarama Islemini Yapiyoruz
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			
			// ValidationProblemDetails Uzerinden 
			// GetValidationErrors Fonksiyonu Uzerinden
			// Put Fonksiyonu Icinde Ilk Parametre Hangi Hata Oldugu Bilgisini Iceriyor
			// Put Fonksiyonu Icinde Ikinci Parametre Hatanin Hangi Alanda Oldugu Bilgisini Iceriyor
			// IFieldError Uzerinden GetField Fon
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return validationProblemDetails;
	}
	
	// Tum Anotasyonlarin Taranmasini Ve 
	// ModelMapper Kullaniminin Gerceklesmesini Saglar
	@Bean
	
	// Uygulama Calistirildiginda
	// ModelMapper Kullaniminin Calismasi Ve IOC Uzerinden Islemlerin Yapimasi Icin
	// Icinde New Anahtar Kelimesi Kullanilarak Dondurulen ModelMapper Kullanmak Gerekiyor
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}