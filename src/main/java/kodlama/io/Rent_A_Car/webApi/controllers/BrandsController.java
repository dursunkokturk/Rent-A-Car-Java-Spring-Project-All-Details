package kodlama.io.Rent_A_Car.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.Rent_A_Car.business.abstracts.BrandService;
import kodlama.io.Rent_A_Car.business.requests.CreateBrandRequest;
import kodlama.io.Rent_A_Car.business.requests.UpdateBrandRequest;
import kodlama.io.Rent_A_Car.business.responses.GetAllBrandsResponse;
import kodlama.io.Rent_A_Car.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

// RestFull Yapilarin Kontrol Edilecegi Yapiyi Olusturuyoruz
// Annotation Yapiyoruz
@RestController

// Localde Yer Alan Datalar Ile Server Arasindaki Haberlesmeyi Saglamak Icin
// Kullaniyoruz
// Sitenin Linkini Yazdiktan Sonra RequestMapping Kisminda Yer Alan Adresi Yazdigimizda
// Haberlesmeyi Saglamis Oluyoruz
@RequestMapping("/api/brands")

@AllArgsConstructor
public class BrandsController {
	
	// BrandService Interface i Icindeki Listeleme Islemini
	// Bu Class Icinde Kullanmak Icin Dependency Injection Yapiyoruz
	private BrandService brandService;

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
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	
	@GetMapping("/{id}")

	// Yetkilendirme Islemi Sonraasinda Izin Verilen Data lar Gorunecek
	
	// Id Bilgisini PathVariable dan Yani 
	// RequestMapping den Alacak
	public GetByIdBrandResponse getById(@PathVariable int id){
		return brandService.getById(id);
	}
	
	
	// BrandService Inteface Icindeki add Fonksiyonuna
	// CreateBrandRequest Dosyasini Icindeki 
	// CreateBrandRequest Class i Paremetre Olarak Veriyoruz
	@PostMapping()
	
	// Sunucu Tarfinda Istegin Yerine Getirildigini Belirten 201 Kodu Vermesi Icin
	// ResponseStatus Anotasyonu Icinde Gereken Kodu Yaziyoruz
	@ResponseStatus(code=HttpStatus.CREATED)
	
	// Add Fonksiyonu Icinde RequestBody Anotasyonu Ve 
	// CreateBrandRequest Parametresi Kullanarak
	// Data Ekleme Islemini Yapiyoruz
	
	// NotNull - NotBlank - Size 
	// Ozelliklerinin Kullanilabilmesi Icin 
	// Add Fonksiyonu Icinde Valid Anotasyonunu (javax.validation.valid Yolunda Yer Alan)
	// Girmek Gerekiyor
	public void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest) throws Exception {
		
		// This Anahtar Kelimesi Uzerinden Dependency Injection Olarak Eklenen
		// BrandService Interface i Icindeki add Fonksiyonuna 
		// CreateBrandRequest Class ini Parametre Olarak Veriyoruz
		this.brandService.add(createBrandRequest);
	}
	
	// Database Icindeki Data yi Guncelleme Isleme Islemi Yapiyoruz
	@PutMapping()
	
	// Update Fonksiyonu Icinde RequestBody Anotasyonu Ve 
	// UpdateBrandRequest Parametresi Kullanarak
	// Data Guncelleme Islemini Yapiyoruz
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	// Database Icindeki Data yi Silme Islemi Yapiyoruz
	@DeleteMapping("/{id}")
	
	// Delete Fonksiyonuna Id Bilgisini PathVariable dan Veriyoruz
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
}