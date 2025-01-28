package controllers.interfaces;

public interface IAnimalController {
    String createAnimal(String animalName, String animalSpecies, int age, String gender);
    String getAnimalById(int id);
    String getAllAnimals();
}
