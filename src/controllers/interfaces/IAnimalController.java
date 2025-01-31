package controllers.interfaces;

import classes.Animal;

import java.util.List;

public interface IAnimalController {
    String createAnimal(String animalName, String animalSpecies, int age, String gender);
    Animal getAnimalById(int id);
    String getAllAnimals();
    String updateOwnerId(int petId, int ownerId);
    String deleteAnimal(int id);

    String updateAnimal(int petId, String name, String species, int age, String gender);

    List<String> getMedicalHistory(int petId);

    String getAnimalsByOwnerId(int ownerId);

    String updateAppointment(int id, String appointment);

    String updateVeterinarianId(int petId, int veterinarianId);
    String addMedicalHistory(int petId, String newRecord);
}
