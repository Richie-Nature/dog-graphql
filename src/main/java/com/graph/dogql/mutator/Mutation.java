package com.graph.dogql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graph.dogql.entity.Dog;
import com.graph.dogql.exception.DogNotFoundException;
import com.graph.dogql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        dogRepository.deleteByBreed(breed);
        return false;

//        boolean deleted = false;
//        Iterable<Dog> allDogs = dogRepository.findAll();
//        // Loop through all dogs to check their breed
//        for (Dog d:allDogs) {
//            if (d.getBreed().equals(breed)) {
//                // Delete if the breed is found
//                dogRepository.delete(d);
//                deleted = true;
//            }
//        }
//        // Throw an exception if the breed doesn't exist
//        if (!deleted) {
//            throw new BreedNotFoundException("Breed Not Found", breed);
//        }
//        return deleted;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
