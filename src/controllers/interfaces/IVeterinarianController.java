package controllers.interfaces;

import classes.Veterinarian;

public interface IVeterinarianController {
    String createVeterinarian(String name, String email, int age, int phoneNumber, String gender);
    Veterinarian getVeterinarianById(int id);
    String getAllVeterinarians();

    String updateVeterinarian(int id, String name, String email, int age, int phoneNumber, String gender);
    String deleteVeterinarian(int id);

    String updateIsOccupied(int id, boolean isOccupied);
}
