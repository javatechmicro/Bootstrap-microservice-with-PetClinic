package com.apssouza.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apssouza.entities.Owner;
import com.apssouza.entities.Pet;
import com.apssouza.repositories.OwnerRepository;
import com.apssouza.repositories.PetRepository;


@RequestMapping("/accounts")
@RestController
public class CustomerController {

    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    PetRepository petRepository;
    
    
    @GetMapping
    public List<Owner> all() {
        return ownerRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Owner owner) {
    	owner = this.ownerRepository.save(owner);
        Integer id = owner.getId();
        if (id != null) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("pettype")
    public List<Pet> getAllPetType() {
        return petRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Pet pet) {
    	pet = this.petRepository.save(pet);
        Integer id = pet.getId();
        if (id != null) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.noContent().build();
    }
}
