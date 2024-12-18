package com.pet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.model.Pet;

public interface PetRepository extends JpaRepository<Pet , Long> {

}
