package com.example.petadoption.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "veterinarians")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID создается автоматически
    private Long id;

    private String name;
    private String email;
    private int age;
    private String phoneNumber;
    private String gender;

    private boolean isOccupied = false; // Занят ли ветеринар

    @OneToMany(mappedBy = "veterinarian") // Связь с животными
    private List<Animal> assignedAnimals;

    public Veterinarian(String name, String email, int age, String phoneNumber, String gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}
