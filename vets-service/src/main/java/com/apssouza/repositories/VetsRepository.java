package com.apssouza.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apssouza.entities.Vets;

/**
 * Account interface repository
 *
 * @author mohammad
 */
@Repository
public interface VetsRepository extends JpaRepository<Vets, Long> {

    Optional<Vets> findByName(String name);
}
