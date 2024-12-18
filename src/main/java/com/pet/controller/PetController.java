package com.pet.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.model.Pet;
import com.pet.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService petService;
	
	@GetMapping()
	public ResponseEntity<List<Pet>> getAllPets()
	{
		List<Pet> pets= petService.getAllPets();
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}
	
	@GetMapping("/{petId}")
	public Pet getPetById(@PathVariable Long petId) {
		return petService.getPetById(petId);
	}
	
	@PostMapping
	public Pet addPet(@RequestBody Pet pet)
	{
		return petService.savePet(pet);
	}
	
	@PutMapping
	public ResponseEntity<Optional<Pet>> updatePet(Long petId, Pet pet)
	{
		Optional<Pet> exPet=Optional.of(petService.updatePet(petId, pet));
		return new ResponseEntity<>(exPet, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deletePet(@PathVariable Long id)
	{
		petService.deletePet(id);
	}
	
}
