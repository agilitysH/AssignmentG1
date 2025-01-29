package controllers.interfaces;
public interface IVeterinarianController {
    String createVeterinarian(String name, String email, int age, int phoneNumber, boolean gender);
    String getVeterinarianByPhoneNumber(int phoneNumber);
    String getAllVeterinarians();
}
