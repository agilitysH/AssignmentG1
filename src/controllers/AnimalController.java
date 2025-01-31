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

        return (created ? "Created" : "Creation failed");
    }

    @Override
    public Animal getAnimalById(int id) {
        return repo.getAnimalById(id);
    }

    @Override
    public String getAllAnimals() {
        List<Animal> animals = repo.getAllAnimals();
        if (animals == null || animals.isEmpty()) {
            return "No animals found!";
        }
        StringBuilder sb = new StringBuilder();
        for (Animal animal : animals) {
            sb.append("Pet ID: ").append(animal.getPetId())
                    .append(", Name: ").append(animal.getName())
                    .append(", Species: ").append(animal.getSpecies())
                    .append(", Age: ").append(animal.getAge())
                    .append(", Gender: ").append(animal.getGender())
                    .append(", Owner ID: ").append(animal.getOwnerId())
                    .append(", Appointment: ").append(animal.getAppointment())
                    .append("\n");
        }
        return sb.toString();
    }

    @Override
    public String updateOwnerId(int petId, int ownerId) {
        boolean updated = repo.updateOwnerId(petId,ownerId);
        return updated? "Updated":"Update failed";
    }

    @Override
    public String deleteAnimal(int id) {

        boolean deleted = repo.deleteAnimal(id);
        return (deleted ? "Deleted" : "Deletion failed");
    }

    @Override
    public String updateAnimal(int petId, String name, String species, int age, String gender) {
        boolean updated = repo.updateAnimal(petId,name,species,age,gender);
        return (updated? "Updated" : "Updating failed");
    }

    @Override
    public List<String> getMedicalHistory(int petId) {
        Animal animal = repo.getAnimalById(petId);
        return (animal != null) ? repo.getMedicalHistory(petId) : List.of("No records found");
    }
    @Override
    public String getAnimalsByOwnerId(int ownerId) {
        List<Animal> animals = repo.getAnimalsByOwnerId(ownerId);
        if (animals == null || animals.isEmpty()) {
            return "No animals found!";
        }
        StringBuilder sb = new StringBuilder();
        for (Animal animal : animals) {
            sb.append("Pet ID: ").append(animal.getPetId())
                    .append(", Name: ").append(animal.getName())
                    .append(", Species: ").append(animal.getSpecies())
                    .append(", Age: ").append(animal.getAge())
                    .append(", Gender: ").append(animal.getGender())
                    .append(", Owner ID: ").append(animal.getOwnerId())
                    .append(", Appointment: ").append(animal.getAppointment())
                    .append(", Medical History: ").append(animal.getMedicalHistory())
                    .append("\n");
        }
        return sb.toString();

    }

    @Override
    public String updateAppointment(int id, String appointment){
        boolean updated = repo.updateAppointment(id, appointment);
        return (updated? "Appointment set" : "Failed to update appointment");
    }

    @Override
    public String updateVeterinarianId(int petId, int veterinarianId){
        boolean updated = repo.updateVeterinarianId(petId,veterinarianId);
        return (updated? "Veterinarian set" : "Failed to update veterinarian");
    }

    @Override
    public String addMedicalHistory(int petId, String newRecord) {
        boolean added = repo.addMedicalHistory(petId,newRecord);
        return (added? "Added" : "Failed to add medical history");
    }

}
