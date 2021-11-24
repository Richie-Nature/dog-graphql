package com.graph.dogql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graph.dogql.entity.Dog;
import com.graph.dogql.exception.DogNotFoundException;
import com.graph.dogql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogBreedById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not found", id);
        }
    }

}
