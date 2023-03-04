package kodlama.io.Rent_A_Car.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.Rent_A_Car.core.utilities.exceptions.BusinessException;
import kodlama.io.Rent_A_Car.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

// Is Kurallarini Istenilgi Zaman Kullanilabilir Halde Tutmak Icin
// Islemleri IOC Uzerinden Erisilebilir Hale Getiriyoruz
@Service

// Injection Yapilan Dosyalari Kullanmak Icin Olusturuyoruz
@AllArgsConstructor

// Marka Ekleme Islemlerinde Ekleme Islemlerinin 
// Hangi Kriterlere Gore Yapilacagini Belirtiyoruz
public class BrandBusinessRules {
	
	// Database Icinde Marka Kontrolu Yapmak Icin
	// BrandRepository interface ini Kullaniyoruz
	private BrandRepository brandRepository;
	
	// Marka Adinin Tekrar Etme Durumunu 
	// Name Parametresini Kullanarak Kontrol Ediyoruz
	public void checkIfBrandNameExists(String name) {
		
		// This Anahtar Kelimesi Uzerinden 
		// BrandRepository Uzerinden 
		// BrandRepository de Olusturulan 
		// ExistsByName Fonksiyonunda Alinan Sonuca Gore
		// Marka Varsa 
		// Marka Yoksa if Dongusu Icindeki Mesaj Gorunecek
		if(this.brandRepository.existsByName(name)) {
			
			// Olusacak Hata Calisma Hatasi Olacagi Icin Buna Uygun
			// BusinessException Class i Yazmak Gerekiyor
			throw new BusinessException("Brand Name Already Exists");
		}
	}
}