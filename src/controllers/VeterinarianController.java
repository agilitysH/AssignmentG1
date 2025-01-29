package controllers;
import java.util.List;
import classes.Veterinarian;
import repos.interfaces.IVeterinarianRepo;
import controllers.interfaces.IVeterinarianController;
public class VeterinarianController implements IVeterinarianRepo {
    private final IVeterinarianRepo repo;
    public Veterinarian(IVeterinarianRepo repo) {
        this.repo = repo;
    }
    @Override
    public String createVeterinarian(String name, String email, int age, int phoneNumber, boolean gender) {
        Veterinarian veterinarian = new Veterinarian(name, email, age, phoneNumber, gender);
        boolean created = repo.createVeterinarian(veterinarian);

        return (created? "Created": "Creation failed");
    }
    @Override
    public String getVeterinarianByPhoneNumber(int phoneNumber) {
        Veterinarian veterinarian = repo.getVeterinarianByPhoneNumber(phoneNumber);

        return (veterinarian == null) ? "Not found!" : veterinarian.toString();
    }
    @Override
    public String getAllVeterinarians() {
        List<Veterinarian> veterinarians= repo.getAllVeterinarians();
        return (veterinarians == null) ? "Not found!" : veterinarians.toString();
    }
}