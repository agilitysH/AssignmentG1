package com.example.petadoption.model;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass  // Это базовый класс для других сущностей (Owner, Veterinarian)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоматическая генерация ID
    private Long id;

    private String name;
    private String email;
    private int age;
    private String phoneNumber;
    private String gender;

    public Person(String name, String email, int age, String phoneNumber, String gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}
