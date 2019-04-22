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

import com.apssouza.entities.Visit;
import com.apssouza.repositories.VisitRepository;


@RequestMapping("/visits")
@RestController
public class VisitsAccountController {
    @Autowired
    VisitRepository visitRepository;
    @GetMapping
    public List<Visit> all() {
        return visitRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Visit visit) {
    	 visit = visitRepository.save(visit);
    	Long id = visit.getId();
        if (id != null) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.noContent().build();
    }
}
