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
    public String createOwner(String name, String surname, int age, int phoneNumber, int numberOfPets, boolean gender) {
        Owner owner = new Owner(name, surname, age, phoneNumber, gender);
        boolean created = repo.createOwner(owner);
        return (created ? "Created" : "Creation failed");
    }

    @Override
    public String getOwnerById(int id) {
        Owner owner = repo.getOwnerById;
        return (owner != null ? "Not found!" : owner.toString());
    }

    @Override
    public String getAllOwners() {
        List<Owner> owners = repo.getAllOwners();
        return (owners == null) ? "Not found!" : owners.toString();
    }
}
