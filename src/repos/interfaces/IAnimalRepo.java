package repos.interfaces;

import java.util.List;
import classes.Animal;

public interface IAnimalRepo {

    boolean createAnimal(Animal animal);
    Animal getAnimalById(int id);
    List<Animal> getAllAnimals();

}
