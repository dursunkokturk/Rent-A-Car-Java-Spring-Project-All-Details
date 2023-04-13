package kodlama.io.Rent_A_Car.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Rent_A_Car.business.abstracts.ModelService;
import kodlama.io.Rent_A_Car.business.requests.CreateModelRequest;
import kodlama.io.Rent_A_Car.business.responses.GetAllModelsResponse;
import kodlama.io.Rent_A_Car.core.utilities.mappers.ModelMapperService;
import kodlama.io.Rent_A_Car.dataAccess.abstracts.ModelRepository;
import kodlama.io.Rent_A_Car.entities.concretes.Model;
import lombok.AllArgsConstructor;

// IOC Uzerinden Model Listeleme Ve Yeni Model Ekleme Islemi Yapiyoruz
@Service

@AllArgsConstructor

// ModelService interface ini Dahil Ederek
// GeTAllModelsResponse List i Kullanarak Model leri Listeleme Yapiyoruz 
// Add Fonksiyonunu Kullanarak Yeni Model Ekleme Islemini Yapiyoruz
public class ModelManager implements ModelService{

	// ModelRepository Interface ini 
	// Dependency Injection Yontemini Kullanarak 
	// Sistemi Gevsek Baglanti Ile 
	// ModelRepository Interface ine Bagli Hale Getiriyoruz
	private ModelRepository modelRepository;
	
	// ForRequest Kullanarak Sorgulama Islemlerini Ve 
	// ForResponse Kullanarak Sorgulama Islem Sonuclarini Kullanmak Icin
	// ModelMapperService interface ini 
	// Injection Yontemini Kullanarak Dahil Ediyoruz
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		// Is Kurallarini Yaziyoruz
		
		// Database Icindeki Tum Data lari Kontrol Ediyoruz
		List<Model> models = modelRepository.findAll();
				
		// List Icindeki Data yi Stream Fonksiyonu Ile Tek Tek Geziyoruz
		// Stream Fonksiyonuna Ait Olan Map i Kullanarak Butun Markalari Geziyoruz
		// This Anahtar Kelimesi Uzerinden ModelMapperService Icindeki 
		// ForResponse Map i Icinde Bulunan Markalari GetAllBrandsResponse Tipine Ceviriyoruz
		// GetAllBrandsResponse Tipine Cevirilen Data yi Collect Listesi Tipine Ceviriyoruz
		List<GetAllModelsResponse> modelsResponse = models.stream().map(model->this.modelMapperService.forResponse().map(models, GetAllModelsResponse.class)).collect(Collectors.toList());
		
		// Islemin Bitirilmesi Icin brandsResponse Ile Islem Soncunu Donduruyoruz
		return modelsResponse;
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		
		// Model Objesi Olusturuyoruz
		// Olusturulan Model Objesine
		// This Anahtar Kelimesi Uzerinden ModelMapperService Uzerinden
		// ForRequest Fonksiyonu Uzerinden Map Fonksiyonu Icinde Bulunan 
		// CreateModelRequest Parametresi Ile Arka Planda
		// New Anahtar Kelimesini Kullanarak Model Objesi Olusturuyor.
		// map Fonksiyonu Icindeki CreateBrandRequest Icinde Ayni Olanlari
		// Model Objesine Aktariyor
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		
		// This Anahtar Kelimesini Uzerinden 
		// ModelRepository interface Uzerinden
		// Save Fonksiyonu Icinde Model Parametresini Vererek
		// Kaydetme Islemini Yapiyoruz
		this.modelRepository.save(model);
	}
}