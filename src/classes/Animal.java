package com.example.petadoption.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Animals")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;  // ID теперь генерируется БД

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id", nullable = true)
    private Veterinarian veterinarian;

    @Column(nullable = false)
    private String appointment = "Not appointed";

    @ElementCollection
    @CollectionTable(name = "medical_history", joinColumns = @JoinColumn(name = "animal_id"))
    @Column(name = "record")
    private List<String> medicalHistory;
}
