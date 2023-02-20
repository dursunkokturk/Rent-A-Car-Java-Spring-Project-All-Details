package kodlama.io.Rent_A_Car.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Rent_A_Car.business.abstracts.BrandService;
import kodlama.io.Rent_A_Car.business.requests.CreateBrandRequest;
import kodlama.io.Rent_A_Car.business.responses.GetAllBrandsResponse;

// RestFull Yapilarin Kontrol Edilecegi Yapiyi Olusturuyoruz
// Annotation Yapiyoruz
@RestController

// Localde Yer Alan Datalar Ile Server Arasindaki Haberlesmeyi Saglamak Icin
// Kullaniyoruz
// Sitenin Linkini Yazdiktan Sonra RequestMapping Kisminda Yer Alan Adresi Yazdigimizda
// Haberlesmeyi Saglamis Oluyoruz
@RequestMapping("/api/brands")
public class BrandsController {
	
	// BrandService Interface i Icindeki Listeleme Islemini
	// Bu Class Icinde Kullanmak Icin Dependency Injection Yapiyoruz
	private BrandService brandService;

	// Marka Lisleteme Istegi Geldiginde 
	// Bu Istek Business Katmaninda Yer Alan 
	// Is Kurallarindaki Sartlara Uygun Ise
	// DataAccess Katmanina Istenilen Islemi Yapma Izni Veriyor
	
	// Uygulam Icindeki BrandService Interface Icindeki Fonksiyonlari Kullananlari Buluyor
	// New Anahtar Kelimesi Kullanilarak Obje Olusturulmus Halini Istiyor
	@Autowired
	
	// Dependency Injection Yontemi Ile Bu Class Icine Dahil Edilen 
	// BrandService Inteface ini Parametreli Constructor Kullanarak 
	// Bu Class Icinde Kullanilabilir Hale Getiriyoruz
	
	// Business Katmanindaki BrandService Interface i Uzerinden 
	// BrandManager Class i Ile Kontrol Islemi Yapiliyor
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	// Listeleme Isleminde Listelenecek Data yi Yaziyoruz
	// Sitenin Linkini Yazdiktan Sonra 
	// Ilk Olarak RequestMapping Kisminda Yer Alan Adresi Yaziyoruz
	// Sonra GetMapping Kisminda Yer Alan Adresi Yazdigimizda
	// Marka Isimlerini Lsitelemis Oluyoruz
	@GetMapping("/getall")
	
	/*
	// Kontrol Islemi Sonrasinda Sorun Yok Ise Listeleme Islemi Yapilacak
	public List<Brand> getAll(){
		return brandService.getAll();
	}
	*/
	
	// Yetkilendirme Islemi Sonraasinda Izin Verilen Data lar Gorunecek
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	// BrandService Inteface Icindeki add Fonksiyonuna
	// CreateBrandRequest Dosyasini Icindeki 
	// CreateBrandRequest Class i Paremetre Olarak Veriyoruz
	@PostMapping("/add")
	public void add(CreateBrandRequest createBrandRequest) {
		
		// This Anahtar Kelimesi Uzerinden Dependency Injection Olarak Eklenen
		// BrandService Interface i Icindeki add Fonksiyonuna 
		// CreateBrandRequest Class ini Parametre Olarak Veriyoruz
		this.brandService.add(createBrandRequest);
	}
}