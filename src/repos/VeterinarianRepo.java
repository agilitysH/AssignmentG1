package com.example.petadoption.repository;

import com.example.petadoption.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {

    // Найти ветеринара по ID (Spring JPA делает это автоматически)
    Veterinarian findById(long id);

    // Обновить статус занятости ветеринара
    @Modifying
    @Transactional
    @Query("UPDATE Veterinarian v SET v.isOccupied = :isOccupied WHERE v.id = :id")
    void updateIsOccupied(long id, boolean isOccupied);
}
