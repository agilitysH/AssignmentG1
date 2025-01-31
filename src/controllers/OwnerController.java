package controllers;
import java.util.List;
import classes.Owner;
import repos.interfaces.IOwnerRepo;
import controllers.interfaces.IOwnerController;
public class OwnerController implements IOwnerController {
    private final IOwnerRepo repo;

    public OwnerController(IOwnerRepo repo) {
        this.repo = repo;
    }

    @Override
    public String createOwner(String name, String email, int age, int phoneNumber, String gender) {
        Owner owner = new Owner(name, email, age, phoneNumber, gender);
        boolean created = repo.createOwner(owner);
        return (created ? "Created" : "Creation failed");
    }

    @Override
    public Owner getOwnerById(int id) {
        Owner owner = repo.getOwnerById(id);
        return owner;
    }

    @Override
    public String getAllOwners() {
        List<Owner> owners = repo.getAllOwners();
        if (owners == null || owners.isEmpty()) {
            return "No owners found!";
        }
        StringBuilder sb = new StringBuilder();
        for (Owner owner : owners) {
            sb.append("ID: ").append(owner.getId()).append(", Name: ").append(owner.getName())
                    .append(", Email: ").append(owner.getEmail()).append(", Age: ").append(owner.getAge())
                    .append(", Phone Number: ").append(owner.getPhoneNumber()).append(", Number of Pets: ")
                    .append(owner.getNumberOfPets()).append(", Gender: ").append(owner.getGender())
                    .append("\n");
        }
        return sb.toString();
    }

    @Override
    public String updateOwner(int id, String name, String email, int age, int phoneNumber, String gender) {
        Owner existingOwner = repo.getOwnerById(id);
        if (existingOwner == null) {
            return "Owner not found!";
        }
        existingOwner.setName(name);
        existingOwner.setEmail(email);
        existingOwner.setAge(age);
        existingOwner.setPhoneNumber(phoneNumber);
        existingOwner.setGender(gender);

        boolean updated = repo.updateOwner(existingOwner);
        return updated ? "Updated successfully" : "Update failed";
    }

    @Override
    public String deleteOwner(int id) {
        boolean deleted = repo.deleteOwner(id);
        return deleted ? "Deleted successfully" : "Deletion failed";
    }

    @Override
    public String updateOwnerPets(int ownerId, int petsDelta) {
        boolean updated = repo.updateOwnerPets(ownerId, petsDelta);
        return updated ? "Owner's number of pets updated successfully." : "Failed to update owner's number of pets.";
    }
}

