package kodlama.io.Rent_A_Car.business.abstracts;

import java.util.List;

import kodlama.io.Rent_A_Car.business.requests.CreateModelRequest;
import kodlama.io.Rent_A_Car.business.responses.GetAllModelsResponse;

public interface ModelService {
	
	// Model Listesinde Yer Alan Data lari Listeliyoruz
	List<GetAllModelsResponse> getAll();
	
	// Database Icinde Yeni Bir Model Ekleme Islemi Yapiyoruz
	void add(CreateModelRequest createModelRequest);
}