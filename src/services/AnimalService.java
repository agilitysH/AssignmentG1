package com.example.petadoption.service;

import com.example.petadoption.model.Animal;
import com.example.petadoption.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Животное не найдено"));
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> getAnimalsWithoutOwner() {
        return animalRepository.findByOwnerIsNull();
    }

    public List<Animal> getAnimalsByOwner(Long ownerId) {
        return animalRepository.findByOwner_Id(ownerId);
    }

    public List<Animal> getAnimalsByVeterinarian(Long veterinarianId) {
        return animalRepository.findByVeterinarian_Id(veterinarianId);
    }
}
