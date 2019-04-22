package com.apssouza.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apssouza.entities.Owner;

/**
 * Repository class for <code>Owner</code> domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Mohammad
  */
public interface OwnerRepository extends JpaRepository<Owner, Integer> { }
