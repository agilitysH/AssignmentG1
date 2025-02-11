package com.example.petadoption.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Owner extends Person {

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> pets = new ArrayList<>();

    public void addPet(Animal pet) {
        pets.add(pet);
        pet.setOwner(this); // Устанавливаем владельца животному
    }

    public void removePet(Animal pet) {
        pets.remove(pet);
        pet.setOwner(null);
    }

    public int getNumberOfPets() {
        return pets.size();
    }



