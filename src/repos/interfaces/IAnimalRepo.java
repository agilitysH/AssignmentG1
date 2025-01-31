package repos.interfaces;

import java.util.List;
import classes.Animal;

public interface IAnimalRepo {

    boolean createAnimal(Animal animal);
    Animal getAnimalById(int id);
    List<Animal> getAllAnimals();

    boolean updateAnimal(int petId, String name, String species, int age, String gender);

    boolean updateOwnerId(int petId, int ownerId);
    boolean deleteAnimal(int id);


    List<String> getMedicalHistory(int petId);

    List<Animal> getAnimalsByOwnerId(int ownerId);

    boolean updateAppointment(int petId, String appointment);

    boolean updateVeterinarianId(int petId, int veterinarianId);

    boolean addMedicalHistory(int petId, String newRecord);
}
