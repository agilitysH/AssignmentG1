package com.example.petadoption.controller;

import com.example.petadoption.model.Animal;
import com.example.petadoption.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.saveAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
    }

    @GetMapping("/without-owner")
    public List<Animal> getAnimalsWithoutOwner() {
        return animalService.getAnimalsWithoutOwner();
    }

    @GetMapping("/owner/{ownerId}")
    public List<Animal> getAnimalsByOwner(@PathVariable Long ownerId) {
        return animalService.getAnimalsByOwner(ownerId);
    }

    @GetMapping("/veterinarian/{veterinarianId}")
    public List<Animal> getAnimalsByVeterinarian(@PathVariable Long veterinarianId) {
        return animalService.getAnimalsByVeterinarian(veterinarianId);
    }
}
