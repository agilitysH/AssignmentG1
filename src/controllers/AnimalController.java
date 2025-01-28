package controllers;
import java.util.List;
import classes.Animal;
import repos.interfaces.IAnimalRepo;
import controllers.interfaces.IAnimalController;

public class AnimalController implements IAnimalController {

    private final IAnimalRepo repo;

    public AnimalController(IAnimalRepo repo) {
        this.repo = repo;
    }

    @Override
    public String createAnimal(String animalName, String animalSpecies, int age, String gender) {
        Animal animal = new Animal(animalName, animalSpecies, age, gender);
        boolean created = repo.createAnimal(animal);

        return (created? "Created": "Creation failed");
    }
    @Override
    public String getAnimalById(int id) {
        Animal animal = repo.getAnimalById(id);

        return (animal == null) ? "Not found!" : animal.toString();
    }
    @Override
    public String getAllAnimals() {
        List<Animal> animals = repo.getAllAnimals();
        return (animals == null) ? "Not found!" : animals.toString();
    }
}
