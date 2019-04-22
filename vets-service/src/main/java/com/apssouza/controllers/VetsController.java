package com.apssouza.controllers;

import com.apssouza.entities.Account;
import com.apssouza.entities.Vets;
import com.apssouza.exceptions.DataNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.apssouza.services.AccountService;
import com.apssouza.services.VetsService;

import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/vets")
@RestController
public class VetsController {

    @Autowired
    VetsService vetsService;


    @GetMapping
    public List<Vets> all() {
        return vetsService.all();
    }
    
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Vets vet) {
    	Vets saved = this.vetsService.save(vet);
        Long id = saved.getId();
        if (id != null) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.noContent().build();
    }

    
    
}
