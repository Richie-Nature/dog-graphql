package com.graph.dogql.repository;

import com.graph.dogql.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

//    @Query("delete d.id, d.breed from Dog d where d.id=:id")
    Long deleteByBreed(String breed);
}
