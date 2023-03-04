package kodlama.io.Rent_A_Car.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

// Her Seferinde ModelMapper Olusturmak Yerine
// IOC Uzerinden Kullanmak Isteyen Herkesin Kullanimina Acik Hale Getiriyoruz
@Service

@AllArgsConstructor

// ModelMapperService interface Dosyasi Icinde Genel Hali Belirtilen Fonksiyonlarin
// Yapacagi Islemleri Yaziyoruz
public class ModelMapperManager implements ModelMapperService{

	// IOC Uzerinden Soregulama Ve Sonuc Alma Islemleri Yapilabilsin Diye
	// ModelMapper i Injection  Yapiyoruz
	private ModelMapper modelMapper;
	
	@Override
	
	// Response Islemi Yapilmasi Asamasinda 
	// ID , Name Gibi Hangi Objeler Uygun Ise Onlari Isleme Dahil Eder
	// Bu Islemi Loose (Gevsek) Baglanti Ile Yapar
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMapper;
	}

	@Override
	
	// Request Islemi Yapilmasi Asamasinda 
	// Tum Objelerin Uygun Olmasi Zorunludur
	// Bu Islemi Standard (Siki) Baglanti Ile Yapar
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}
}