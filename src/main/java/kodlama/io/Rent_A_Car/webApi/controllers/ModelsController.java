package kodlama.io.Rent_A_Car.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.Rent_A_Car.business.abstracts.ModelService;
import kodlama.io.Rent_A_Car.business.requests.CreateModelRequest;
import kodlama.io.Rent_A_Car.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

//RestFull Yapilarin Kontrol Edilecegi Yapiyi Olusturuyoruz
//Annotation Yapiyoruz
@RestController

//Localde Yer Alan Datalar Ile Server Arasindaki Haberlesmeyi Saglamak Icin
//Kullaniyoruz
//Sitenin Linkini Yazdiktan Sonra RequestMapping Kisminda Yer Alan Adresi Yazdigimizda
//Haberlesmeyi Saglamis Oluyoruz
@RequestMapping("/api/models")

@AllArgsConstructor
public class ModelsController {
	
	// Model Listesi Ve Model Ekleme Islemlerini Yapmak Icin
	// ModelService interface ini Injeciton Yontemi Ile Dahil Ediyoruz
	private ModelService modelService;
	
	// Marka Lisleteme Istegi Geldiginde 
	// Bu Istek Business Katmaninda Yer Alan 
	// Is Kurallarindaki Sartlara Uygun Ise
	// DataAccess Katmanina Istenilen Islemi Yapma Izni Veriyor
	
	
	// Listeleme Isleminde Listelenecek Data yi Yaziyoruz
	// Sitenin Linkini Yazdiktan Sonra 
	// Ilk Olarak RequestMapping Kisminda Yer Alan Adresi Yaziyoruz
	// Sonra GetMapping Kisminda Yer Alan Adresi Yazdigimizda
	// Marka Isimlerini Lsitelemis Oluyoruz
	@GetMapping()
	
	// Yetkilendirme Islemi Sonraasinda Izin Verilen Data lar Gorunecek
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	
	// BrandService Inteface Icindeki add Fonksiyonuna
	// CreateModelRequest Dosyasini Icindeki 
	// CreateModelRequest Class i Paremetre Olarak Veriyoruz
	@PostMapping()
	
	// Sunucu Tarafinda Istegin Yerine Getirildigini Belirten 201 Kodu Vermesi Icin
	// ResponseStatus Anotasyonu Icinde Gereken Kodu Yaziyoruz
	@ResponseStatus(code=HttpStatus.CREATED)
	
	// Add Fonksiyonu Icinde RequestBody Anotasyonu Ve 
	// CreateModelRequest Parametresi Kullanarak
	// Data Ekleme Islemini Yapiyoruz
	
	// NotNull - NotBlank - Size 
	// Ozelliklerinin Kullanilabilmesi Icin 
	// Add Fonksiyonu Icinde Valid Anotasyonunu (javax.validation.valid Yolunda Yer Alan)
	// Girmek Gerekiyor
	public void add(@RequestBody() @Valid CreateModelRequest createModelRequest) {
		
		// This Anahtar Kelimesi Uzerinden Dependency Injection Olarak Eklenen
		// ModelService Interface i Icindeki add Fonksiyonuna 
		// CreateModelRequest Class ini Parametre Olarak Veriyoruz
		this.modelService.add(createModelRequest);
	}
}