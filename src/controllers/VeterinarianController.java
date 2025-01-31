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
    public Veterinarian getVeterinarianById(int id) {
        Veterinarian veterinarian = repo.getVeterinarianById(id);

        return veterinarian;
    }
    @Override
    public String getAllVeterinarians() {
        List<Veterinarian> veterinarians = repo.getAllVeterinarians();
        if (veterinarians == null || veterinarians.isEmpty()) {
            return "No veterinarians found!";
        }
        StringBuilder sb = new StringBuilder();
        for (Veterinarian veterinarian : veterinarians) {
            sb.append("ID: ").append(veterinarian.getId()).append(", Name: ").append(veterinarian.getName())
                    .append(", Email: ").append(veterinarian.getEmail()).append(", Age: ").append(veterinarian.getAge())
                    .append(", Phone Number: ").append(veterinarian.getPhoneNumber()).append(", Gender: ")
                    .append(veterinarian.getGender()).append("IsOccupied: ").append(veterinarian.isOccupied())
                    .append("\n");
        }
        return sb.toString();
    }


    @Override
    public String updateVeterinarian(int id, String name, String email, int age, int phoneNumber, String gender) {
        Veterinarian existingVeterinarian = repo.getVeterinarianById(id);
        if (existingVeterinarian == null) {
            return "Veterinarian not found";
        }

        existingVeterinarian.setName(name);
        existingVeterinarian.setEmail(email);
        existingVeterinarian.setAge(age);
        existingVeterinarian.setPhoneNumber(phoneNumber);
        existingVeterinarian.setGender(gender);

        boolean updated = repo.updateVeterinarian(existingVeterinarian);
        return updated ? "Updated successfully" : "Update failed";
    }
    @Override
    public String deleteVeterinarian(int id) {
        boolean deleted = repo.deleteVeterinarian(id);
        return deleted ? "Deleted successfully" : "Deletion failed";
    }
@Override
public String updateIsOccupied(int id, boolean isOccupied) {
        Veterinarian existingVeterinarian = repo.getVeterinarianById(id);
        if (existingVeterinarian == null) {
            return "Veterinarian not found";
        }

        boolean updated = repo.updateIsOccupied(id, isOccupied);
        return updated ? (isOccupied ? "Veterinarian marked as occupied" : "Veterinarian marked as available") : "Update failed";
    }



}