package kodlama.io.Rent_A_Car.business.abstracts;

import java.util.List;

import kodlama.io.Rent_A_Car.business.requests.CreateBrandRequest;
import kodlama.io.Rent_A_Car.business.requests.UpdateBrandRequest;
import kodlama.io.Rent_A_Car.business.responses.GetAllBrandsResponse;
import kodlama.io.Rent_A_Car.business.responses.GetByIdBrandResponse;

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
	
	// Id Bilgisine Gore Marka Data larini Getirme Islemi Yapiyoruz
	GetByIdBrandResponse getById(int id);
	
	// Son Kullanicinin Yapacagi
	// Database Icinde Manuel Data Ekleme Islemi Yapiyoruz
	// Ekleme Islemini CreateBrandRequest Parametresi Uzerinden Yapiyoruz
	// CreateBrandRequest Class i Icindeki Name Degerini Kullaniyoruz
	void add(CreateBrandRequest createBrandRequest);
	
	// Database Icinde Var Olan Data yi Update Fonksiyonu Icindeki 
	// UpdateBrandRequest Parametresi Uzerinden Guncelleme Islemi Yapiyoruz
	void update(UpdateBrandRequest updateBrandRequest);
	
	// Database Icinde Var Olan Data yi Delete Fonksiyonu Icindeki 
	// Id Parametresi Uzerinden Silme Islemi Yapiyoruz
	void delete(int id);
}