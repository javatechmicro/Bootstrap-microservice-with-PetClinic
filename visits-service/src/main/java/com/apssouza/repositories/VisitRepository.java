package com.apssouza.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apssouza.entities.Visit;

/**
 * Account interface repository
 *
 * @author Mohammad
 */
@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

	List<Visit> findByPetId(int petId);
	List<Visit> findByPetIdIn(Iterable<Integer> petIds);
}
