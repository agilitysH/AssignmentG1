package controllers;
import java.util.List;
import classes.Veterinarian;
import repos.interfaces.IVeterinarianRepo;
import controllers.interfaces.IVeterinarianController;
public class VeterinarianController implements IVeterinarianController {
    private final IVeterinarianRepo repo;

    public VeterinarianController(IVeterinarianRepo repo) {
        this.repo = repo;
    }

    @Override
    public String createVeterinarian(String name, String email, int age, int phoneNumber, String gender) {
        Veterinarian veterinarian = new Veterinarian(name, email, age, phoneNumber, gender);
        boolean created = repo.createVeterinarian(veterinarian);

        return (created? "Created": "Creation failed");
    }
    @Override
    public String getVeterinarianById(int id) {
        Veterinarian veterinarian = repo.getVeterinarianById(id);

        return (veterinarian == null) ? "Not found!" : veterinarian.toString();
    }
    @Override
    public String getAllVeterinarians() {
        List<Veterinarian> veterinarians= repo.getAllVeterinarians();
        return (veterinarians == null) ? "Not found!" : veterinarians.toString();
    }
}