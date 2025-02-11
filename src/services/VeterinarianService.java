package com.example.petadoption.service;

import com.example.petadoption.model.Veterinarian;
import com.example.petadoption.repository.VeterinarianRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianService {
    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianService(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

    public Optional<Veterinarian> getVeterinarianById(Long id) {
        return veterinarianRepository.findById(id);
    }

    public Veterinarian createVeterinarian(Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    @Transactional
    public Optional<Veterinarian> updateVeterinarian(Long id, Veterinarian updatedVeterinarian) {
        return veterinarianRepository.findById(id)
                .map(veterinarian -> {
                    veterinarian.setName(updatedVeterinarian.getName());
                    veterinarian.setEmail(updatedVeterinarian.getEmail());
                    veterinarian.setAge(updatedVeterinarian.getAge());
                    veterinarian.setPhoneNumber(updatedVeterinarian.getPhoneNumber());
                    veterinarian.setGender(updatedVeterinarian.getGender());
                    return veterinarianRepository.save(veterinarian);
                });
    }

    public boolean deleteVeterinarian(Long id) {
        if (veterinarianRepository.existsById(id)) {
            veterinarianRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updateIsOccupied(Long id, boolean isOccupied) {
        if (veterinarianRepository.existsById(id)) {
            veterinarianRepository.updateIsOccupied(id, isOccupied);
            return true;
        }
        return false;
    }
}
