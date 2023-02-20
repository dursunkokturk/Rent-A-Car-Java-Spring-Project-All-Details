package kodlama.io.Rent_A_Car.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Rent_A_Car.business.abstracts.BrandService;
import kodlama.io.Rent_A_Car.business.requests.CreateBrandRequest;
import kodlama.io.Rent_A_Car.business.responses.GetAllBrandsResponse;
import kodlama.io.Rent_A_Car.dataAccess.abstracts.BrandRepository;
import kodlama.io.Rent_A_Car.entities.concretes.Brand;

// BrandManager Class ini Ve Class Icindeki Fonksiyonlari Kullanmak Icin
// BrandManager Class indan Her Seferinde Obje Uretmek Yerine 
// @Service Kullanarak 1 Kez Uretilen Objeyi Isteyen Herkesin Kullanmasini Sagliyoruz
// Bu Sekilde Kullanildiginda Uygulamada Yuksek Performans Saglamis Oluyoruz
@Service

public class BrandManager implements BrandService{

	// BrandRepository Interface ini 
	// Dependency Injection Yontemini Kullanarak 
	// Sistemi Gevsek Baglanti Ile 
	// BrandRepository Interface ine Bagli Hale Getiriyoruz
	private BrandRepository brandRepository;
	
	// Uygulama Icinde BrandRepository Interface Icindeki 
	// Fonksiyonlari Kullanan Class lari Buluyor
	@Autowired
	
	// Dependency Injection Yontemi Ile Sistemde Kullanilir Hale Getirilen
	// BrandRepository Interface i Icindeki Fonksiyonlari 
	// Bu Class Icinde Kullanabilmek Icin 
	// Parametreli Constructor Kullaniyoruz
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	// Son Kullanici Icin Izin Verilen Data larin Gorunmesini Sagliyoruz 
	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		// Is Kurallarini Yaziyoruz
		
		/*
		// brandRepository Dependency Injection Uzerinden 
		// BrandRepository Interface ine Gidiyoruz 
		// BrandRepository Interface Icinde Database Icindeki Datalari 
		// id Uzerinden Ekleme Silme Guncelleme Gibi Islemlerden Sonra 
		// Listeleme Islemini Yapmak Icin
		findAll Fonksiyonunu Kullaniyoruz
		
		// Kod Ekraninda getAll Komutu Calistirildiginda
		// Kod Ekranindan Database Icindeki Data lara Ulasiyoruz
		return brandRepository.findAll();
		*/
		
		// Database Icindeki Tum Data lari Kontrol Ediyoruz
		List<Brand> brands = brandRepository.findAll();
		
		// Bos Bir ArrayList Olusturuyoruz
		List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();
		
		// Tum Data lari Tarama Islemi Yapiyoruz
		for (Brand brand : brands) {
			
			// Olusturulan Bos Array List Icine Taranan Tum Data lari Atiyoruz
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			
			// Tum Data lari Tarama Isleminden Sonra 
			// Data larin id ve name Bilgilerini Aliyoruz
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			
			// Alinan Bilgileri Dependency Injection Olarak Datalarin Geldigi
			// brandsResponse Uzerinden BrandService interface Icindeki 
			// add Fonksiyonuna Gonderiyoruz
			brandsResponses.add(responseItem);
		}
		
		// Islemin Bitirilmesi Icin brandsResponse Ile Islem Soncunu Donduruyoruz
		return brandsResponses;
	}

	// Son Kullanicinin Yapacagi
	// Database Icinde Manuel Data Ekleme Islemi Yapiyoruz
	// Yapilacak Islem Icin CreateResponseRequest i Parametre Olarak Veriyoruz
	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		// Ekleme Islemi Icin Obje Olusturuyoruz
		Brand brand = new Brand();
		
		// Olusturulan Objenin Atandigi Degisken Uzerinden
		// Brand Class i Icindeki SetName Fonksiyonuna Ulasiyoruz
		// SetName Fonksiyonu Icinde CreateBrandRequest Parametresi Uzerinden
		// GetName Fonksiyonu Ile Data yi Gonderiyoruz
		brand.setName(createBrandRequest.getName());
		
		// This Anahtar Kelimesi Ile Dependency Injection Yapilarak,
		// Dahil Edilen BrandRepository Uzerinden Save Fonksiyonu Icinde
		// Gonderilen Data yi brand Degiskeni Uzerinden Yazdiriyoruz
		this.brandRepository.save(brand);
	}
}