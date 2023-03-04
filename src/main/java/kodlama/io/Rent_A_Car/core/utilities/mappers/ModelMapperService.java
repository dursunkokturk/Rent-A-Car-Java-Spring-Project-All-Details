package kodlama.io.Rent_A_Car.core.utilities.mappers;

import org.modelmapper.ModelMapper;

// Map leme Islemlerini Yapmak Icin 
// Response Ve Request Islemlerini Yonetiyoruz
public interface ModelMapperService {
	
	// Yapilan Sorgulama Islemlerinde Islem Sonuclarinin Alinacagi
	// Islem Dongusu
	ModelMapper forResponse();
	
	// Sorgulama Islemlerinin Yapilacagi
	// Islem Dongusu
	ModelMapper forRequest();
}