package controllers.interfaces;
public interface IVeterinarianController {
    String createVeterinarian(String name, String email, int age, int phoneNumber, String gender);
    String getVeterinarianById(int id);
    String getAllVeterinarians();
}
