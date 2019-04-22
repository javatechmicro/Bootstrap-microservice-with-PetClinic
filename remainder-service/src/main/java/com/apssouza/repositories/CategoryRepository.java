package com.apssouza.repositories;


import com.apssouza.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long>  {
    
}
