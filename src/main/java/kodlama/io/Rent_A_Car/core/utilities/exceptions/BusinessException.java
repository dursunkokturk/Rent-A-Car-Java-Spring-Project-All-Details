package kodlama.io.Rent_A_Car.core.utilities.exceptions;

@SuppressWarnings("serial")

// BusinessException Uyarisi Olusturacagiz Ancak 
// Olusturacagimiz Exception Calisma Asamasinda Olusacagi Icin
// RuntimeExceptiondan Extends Komutu Ile Destek Aliyoruz
public class BusinessException extends RuntimeException {
	
	// Hata Olustugunda message Parametresi Uzerinden 
	// BusinessException Fonksiyonu Icinde Yazdiriyoruz
	public BusinessException(String message) {
		super(message);
	}
}