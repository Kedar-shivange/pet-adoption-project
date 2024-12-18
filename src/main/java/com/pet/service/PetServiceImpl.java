package com.pet.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.model.Pet;
import com.pet.repo.PetRepository;

@Service
public class PetServiceImpl implements PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public List<Pet> getAllPets(){
		return petRepository.findAll();		
	}

	public Pet getPetById(Long petId){
		return petRepository.findById(petId).orElseThrow(
				()-> new RuntimeException("Pet animal not found"));
	}
	
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}
	
	public Pet updatePet(Long petId, Pet pet)
	{
		Optional<Pet> exPet_Obj= petRepository.findById(petId);
		if(exPet_Obj.isPresent()){
			Pet expet = exPet_Obj.get();
			
			expet.setAge(pet.getAge());
			expet.setName(pet.getName());
			expet.setStatus(pet.getStatus());
			expet.setType(pet.getType());
			
			return petRepository.save(expet);
			
		}else {
			throw new IllegalArgumentException("Id"+ petId + " not found.");
		}
		
	}
	
	public void deletePet(Long petId) {
		petRepository.deleteById(petId);
	}
	
}
