package kodlama.io.Rent_A_Car.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Rent_A_Car.business.abstracts.BrandService;
import kodlama.io.Rent_A_Car.business.requests.CreateBrandRequest;
import kodlama.io.Rent_A_Car.business.requests.UpdateBrandRequest;
import kodlama.io.Rent_A_Car.business.responses.GetAllBrandsResponse;
import kodlama.io.Rent_A_Car.business.responses.GetByIdBrandResponse;
import kodlama.io.Rent_A_Car.business.rules.BrandBusinessRules;
import kodlama.io.Rent_A_Car.core.utilities.mappers.ModelMapperService;
import kodlama.io.Rent_A_Car.dataAccess.abstracts.BrandRepository;
import kodlama.io.Rent_A_Car.entities.concretes.Brand;
import lombok.AllArgsConstructor;

// BrandManager Class ini Ve Class Icindeki Fonksiyonlari Kullanmak Icin
// BrandManager Class indan Her Seferinde Obje Uretmek Yerine 
// @Service Kullanarak 1 Kez Uretilen Objeyi Isteyen Herkesin Kullanmasini Sagliyoruz
// Bu Sekilde Kullanildiginda Uygulamada Yuksek Performans Saglamis Oluyoruz

// Ayni Zamanda IOC Uzerinden Kullanmak Isteyen Herkesin Kullanimina Acik Hale Getiriyoruz
@Service

@AllArgsConstructor

public class BrandManager implements BrandService{

	// BrandRepository Interface ini 
	// Dependency Injection Yontemini Kullanarak 
	// Sistemi Gevsek Baglanti Ile 
	// BrandRepository Interface ine Bagli Hale Getiriyoruz
	private BrandRepository brandRepository;

	// ForRequest Sorgulama Islemlerinin Yapilmasi Isleminin Dahil Ediyoruz
	// ForResponse Sorgulama Islemlerinin Sonuclarini Dahil Ediyoruz
	private ModelMapperService modelMapperService;
	
	// Marka Ekleme Islemi Yapilirken
	// BusinessException Hatalarini Yonetmek Icin
	// BrandBusinessRules Class ini Injection Yontemi Ile Dahil Ediyoruz
	private BrandBusinessRules brandBusinessRules;
	
	// Uygulama Icinde BrandRepository Interface Icindeki 
	// Fonksiyonlari Kullanan Class lari Buluyor
	//@Autowired
	
	// Son Kullanici Icin Izin Verilen Data larin Gorunmesini Sagliyoruz 
	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		// Is Kurallarini Yaziyoruz
		
		// Database Icindeki Tum Data lari Kontrol Ediyoruz
		List<Brand> brands = brandRepository.findAll();
		
		// GetAllBrandsResponse List Icindeki Data yi Stream Fonksiyonu Ile Tek Tek Geziyoruz
		// Stream Fonksiyonuna Ait Olan Map i Kullanarak Butun Markalari Geziyoruz
		// Her Bir Brand Icin
		// This Anahtar Kelimesi Uzerinden ModelMapperService Uzerinden 
		// ForResponse Fonksiyonu Uzerinden 
		// ModelMapper in Map Fonksiyonu Icinde Bulunan Markalari GetAllBrandsResponse Tipine Ceviriyoruz
		// GetAllBrandsResponse Tipine Cevirilen Data yi Collect Listesi Tipine Ceviriyoruz
		List<GetAllBrandsResponse> brandsResponses = brands.stream().map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		// Islemin Bitirilmesi Icin brandsResponse Ile Islem Soncunu Donduruyoruz
		return brandsResponses;
	}

	// Son Kullanicinin Yapacagi
	// Database Icinde Manuel Data Ekleme Islemi Yapiyoruz
	// Yapilacak Islem Icin CreateResponseRequest i Parametre Olarak Veriyoruz
	@Override
	public void add(CreateBrandRequest createBrandRequest){
		
		// This Anahtar Kelimesi Uzerinden BrandBusinessRules Class i Uzerinden
		// BrandBusinessRules Class i Icinde Olusturulan
		// CheckIfBrandNameExists Fonksiyonu Icinde
		// Add Fonksiyonunda Yer Alan CreateBrandRequest Parametresi Uzerinden
		// GetName Fonksiyonu Ile Aliyoruz
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		// This Anahtar Kelimesi Uzerinden ModelMapperService Uzerinden
		// ForRequest Fonksiyonu Uzerinden Map Fonksiyonu Icinde Bulunan 
		// ModelMapper Ile Arka Planda
		// New Anahtar Kelimesini Kullanarak Brand Objesi Olusturuyor.
		// map Fonksiyonu Icindeki CreateBrandRequest Icinde Ayni Olanlari
		// Brand Objesine Aktariyor
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		// This Anahtar Kelimesi Ile Dependency Injection Yapilarak,
		// Dahil Edilen BrandRepository Uzerinden Save Fonksiyonu Icinde
		// Gonderilen Data yi brand Degiskeni Uzerinden Yazdiriyoruz
		this.brandRepository.save(brand);
	}

	// Id Bilgisine Gore Database Icinden Tek Bir Data Getirme Islemi Yapiyoruz
	@Override
	public GetByIdBrandResponse getById(int id) {
		
		// Brand Objesi Olusturuyoruz
		// Olusturulan Objeye This Anahtar Kelimesi Uzerinden
		// FindById Fonksiyonu Ile id Uzerinden Marka Aramasi Yapiyoruz
		// Eger Aranan Markayi Bulamazsa Hata Verecek
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		// Bulunan Markayi GetByIdBrandResponse Objesi Olusturuyoruz
		// Olusturulan Objeye This Anahtar Kelimesi Uzerinden ModelMapperService Interface ine
		// ForResponse Uzerinden ModelMapper in Map ini Kullanarak
		// Gelen Marka Bilgisini GetByIdBrandResponse Tipine Ceviriyoruz
		GetByIdBrandResponse getByIdBrandResponse = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return getByIdBrandResponse;
	}

	// Database Icindeki Data Guncellemek Icin 
	// Update Fonksiyonu Icindeki UpdateBrandRequest Parametresi Uzerinden Gelen Data yi Aliyoruz
	// Brand Objesi Olusturuyoruz
	// This Anahtar Kelimesi Uzerinden ModelMapperService Interface i Uzerinden
	// ForRequest Fonksiyonu Uzerinden Map Fonksiyonu Icinde Guncelleme Islemi Yapilan Data yi
	// Brand Tipini Ceviriyoruz
	// This Anahtar Kelimesi Uzerinden BrandRepository Interface Uzerinden 
	// Save Fonksiyonu Icinde Brand Parametresi Kullanilarak
	// Data nin Guncel Hali Database e Kaydedilecek
	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	// Database Icindeki Data yi Silmek Icin
	// Update Fonksiyonu Icinde Id Parametresi Veriyoruz
	// This Anahtar Kelimesi Uzerinden BrandRepository Interface Uzerinden
	// DeleteById Fonksiyonu Icinde Id Parametresi Veriyoruz
	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
	}
}