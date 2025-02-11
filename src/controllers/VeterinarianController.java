package com.example.petadoption.controller;

import com.example.petadoption.model.Veterinarian;
import com.example.petadoption.service.VeterinarianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarians")
public class VeterinarianController {
    private final VeterinarianService veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }

    @GetMapping
    public ResponseEntity<List<Veterinarian>> getAllVeterinarians() {
        return ResponseEntity.ok(veterinarianService.getAllVeterinarians());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinarian> getVeterinarianById(@PathVariable Long id) {
        return veterinarianService.getVeterinarianById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veterinarian> createVeterinarian(@RequestBody Veterinarian veterinarian) {
        return ResponseEntity.ok(veterinarianService.createVeterinarian(veterinarian));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinarian> updateVeterinarian(@PathVariable Long id, @RequestBody Veterinarian veterinarian) {
        return veterinarianService.updateVeterinarian(id, veterinarian)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVeterinarian(@PathVariable Long id) {
        if (veterinarianService.deleteVeterinarian(id)) {
            return ResponseEntity.ok("Veterinarian deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateIsOccupied(@PathVariable Long id, @RequestParam boolean isOccupied) {
        if (veterinarianService.updateIsOccupied(id, isOccupied)) {
            return ResponseEntity.ok(isOccupied ? "Veterinarian is now occupied" : "Veterinarian is now available");
        }
        return ResponseEntity.notFound().build();
    }
}
