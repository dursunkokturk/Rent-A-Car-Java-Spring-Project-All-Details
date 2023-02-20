package kodlama.io.Rent_A_Car.business.abstracts;

import java.util.List;

import kodlama.io.Rent_A_Car.business.requests.CreateBrandRequest;
import kodlama.io.Rent_A_Car.business.responses.GetAllBrandsResponse;

public interface BrandService {
	/*
	// Markalari Listelemek Icin 
	// Marka Isimlerinin Bulundugu 
	// List Tipindeki Array i Kullaniyoruz
	// List Icindeki Marka Isimlerni Listelemek Icin 
	// getAll Fonksiyonunu Kullaniyoruz
	// List Icindeki Tum Data larin Isteyen Herkes Tarafindan Gorulomesini Saglar
	List<Brand> getAll();
	*/
	
	// Son Kullaniciya Database Icindeki Tum Data lari Degil 
	// Gorme Yetkisi Verilen Data lari Gosteriyoruz
	// GelAllBrandsResponse Dosyasindaki Izin Verilen Yetkiye Gore 
	// Son Kullanici Icin Listeleme Islemini Yapiyoruz
	List<GetAllBrandsResponse> getAll();
	
	// Son Kullanicinin Yapacagi
	// Database Icinde Manuel Data Ekleme Islemi Yapiyoruz
	// Ekleme Islemini CreateBrandRequest Parametresi Uzerinden Yapiyoruz
	// CreateBrandRequest Class i Icindeki Name Degerini Kullaniyoruz
	void add(CreateBrandRequest createBrandRequest);
}