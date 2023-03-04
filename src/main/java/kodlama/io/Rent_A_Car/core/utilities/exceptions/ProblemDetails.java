package kodlama.io.Rent_A_Car.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// RentACarApplication Dosyasinda Yapilan Islemde Hata Olusursa
// Hata Mesajini Yazdirma Islemini Yapiyoruz

// Bu Islemi Yaptigimizda 
// Ekranda Hem Hata Mesaji Hem De Sistem Aciklarinin Yer Aldigi Bilgiler Verilmeyecek
// Onun Yerine Sadece Hatanin Bilgisi Verilecek
public class ProblemDetails {
	String message;
}