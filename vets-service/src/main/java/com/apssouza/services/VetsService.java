package com.apssouza.services;

import java.util.List;
import java.util.Optional;

import com.apssouza.entities.Vets;
import com.apssouza.exceptions.DataNotFoundException;

/**
 * Account service interface
 *
 * @author apssouza
 */
public interface VetsService {

    Optional<Vets> findById(long id);

    List<Vets> all();

    Vets save(Vets user);

    Vets update(Long id, Vets vet) throws DataNotFoundException;

    Optional<Vets> findByName(String name);

    void delete(Vets v);
}
