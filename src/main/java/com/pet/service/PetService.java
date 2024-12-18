package com.pet.service;

import java.util.List;

import com.pet.model.Pet;

public interface PetService {

	Pet getPetById(Long petId);
	
	List<Pet> getAllPets();
	
	Pet savePet(Pet pet);
	
	Pet updatePet(Long petId, Pet pet);
	
	void deletePet(Long petId);
}
