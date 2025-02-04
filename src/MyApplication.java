import classes.*;
import controllers.interfaces.IOwnerController;
import repos.AnimalRepo;
import repos.interfaces.IOwnerRepo;
import controllers.interfaces.IAnimalController;
import controllers.interfaces.IVeterinarianController;
import repos.interfaces.IVeterinarianRepo;
import repos.interfaces.IAnimalRepo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public final class MyApplication {
    private final IOwnerController ownerController;
    private final IVeterinarianController veterinarianController;
    private final IAnimalController animalController;
    private final Scanner scanner = new Scanner(System.in);
    public MyApplication(IOwnerController ownerController, IVeterinarianController veterinarianController, IAnimalController animalController) {
        this.ownerController = ownerController;
        this.veterinarianController = veterinarianController;
        this.animalController = animalController;
    }

    private void mainMenu() {
        System.out.println();
        System.out.println("Welcome to My Application");
        System.out.println("Select one of the following options:");
        System.out.println("1. Owner Menu");
        System.out.println("2. Veterinarian Menu");
        System.out.println("3. Animal Menu");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Select an option (1-3): ");

    }

    public void start() {
        while (true) {
            mainMenu();
            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        ownerMenu();
                        break;
                    case 2:
                        veterinarianMenu();
                        break;
                    case 3:
                        animalMenu();
                        break;
                    default:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option!" + e);
                scanner.nextLine();
                pressAnyKeyToContinue();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("----------------------------------------");
        }
    }

    private void ownerMenu() {
        System.out.println();
        System.out.println("Owner Menu:");
        System.out.println("1. Create new owner");
        System.out.println("2. Get owner by id");
        System.out.println("3. Get all owners");
        System.out.println("4. Update owner by id");
        System.out.println("5. Delete owner by id");
        System.out.println("6. Show owner's pets");
        System.out.println("0. Back to main menu");
        System.out.print("Select an option (0-3): ");

        try {
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    createOwnerMenu();
                    break;
                case 2:
                    getOwnerById();
                    break;
                case 3:
                    getAllOwnersMenu();
                    break;
                case 4:
                    updateOwnerMenu();
                    break;
                case 5:
                    deleteOwnerMenu();
                    break;
                case 6:
                    showAllPetsMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid option!" + e);
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pressAnyKeyToContinue();
    }
    private void animalMenu() {
        System.out.println();
        System.out.println("Animal Menu:");
        System.out.println("1. Create new animal");
        System.out.println("2. Get animal by id");
        System.out.println("3. Get all animals");
        System.out.println("4. Update animal by id");
        System.out.println("5. Delete animal by id");
        System.out.println("6. Show owner of an animal");
        System.out.println("7. Give ownership");
        System.out.println("0. Back to main menu");
        System.out.print("Select an option (0-3): ");

        try {
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    createAnimalMenu();
                    break;
                case 2:
                    getAnimalById();
                    break;
                case 3:
                    getAllAnimalsMenu();
                    break;
                case 4:
                    updateAnimalMenu();
                    break;
                case 5:
                    deleteAnimalMenu();
                    break;
                case 6:
                    showOwnerMenu();
                    break;
                case 7:
                    assignOwnerMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid option!" + e);
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pressAnyKeyToContinue();
    }
    private void veterinarianMenu() {
        System.out.println();
        System.out.println("Veterinarian Menu:");
        System.out.println("1. Creat new veterinarian");
        System.out.println("2. Get veterinarian by id");
        System.out.println("3. Get all veterinarians");
        System.out.println("4. Update veterinarian by id");
        System.out.println("5. Delete veterinarian by id");
        System.out.println("6. Get medical history of pet");
        System.out.println("7. Assign local veterinarian");
        System.out.println("8. Cancel existed appointment");
        System.out.println("9. Finish appointment");
        System.out.println("0. Back to main menu");
        System.out.print("Select an option (0-3): ");

        try {
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    createVeterinarianMenu();
                    break;
                case 2:
                    getVeterinarianById();
                    break;
                case 3:
                    getAllVeterinariansMenu();
                    break;
                case 4:
                    updateVeterinarianMenu();
                    break;
                case 5:
                    deleteVeterinarianMenu();
                    break;
                case 6:
                    getMedicalHistoryMenu();
                    break;
                case 7:
                    assignVeterinarianMenu();
                    break;
                case 8:
                    cancelAssignmentMenu();
                    break;
                case 9:
                    finishAssignmentMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid option!" + e);
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pressAnyKeyToContinue();
    }




    private void createOwnerMenu() {
        System.out.println("Please enter name: ");
        String name = scanner.next();
        System.out.println("Please enter email: ");
        String email = scanner.next();
        System.out.println("Please enter age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter phone number: ");
        int phoneNumber = scanner.nextInt();
        System.out.println("Please enter gender: ");
        String gender = scanner.next();

        String response = ownerController.createOwner(name, email, age, phoneNumber, gender);
        System.out.println(response);
    }
    private void getOwnerById() {
        System.out.println("Please enter a owner id: ");
        int id = scanner.nextInt();
        if (ownerController.getOwnerById(id) != null) {
            String response = "Showed <3";
            System.out.println(response);
        }
        else{
            System.out.println("Not found");
        }

    }
    private void getAllOwnersMenu() {
        String response = ownerController.getAllOwners();
        System.out.println(response);
    }// owner hud
    private void updateOwnerMenu() {
        getAllOwnersMenu();
        System.out.println("Please enter an owner id: ");
        int id = scanner.nextInt();
        System.out.println("Please enter name: ");
        String name = scanner.next();
        System.out.println("Please enter email: ");
        String email = scanner.next();
        System.out.println("Please enter age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter phone number: ");
        int phoneNumber = scanner.nextInt();
        System.out.println("Please enter gender: ");
        String gender = scanner.next();

        String response = ownerController.updateOwner(id, name, email, age, phoneNumber, gender);
        System.out.println(response);

    }
    private void deleteOwnerMenu() {
        getAllOwnersMenu();
        System.out.println("Please enter an owner id: ");
        int id = scanner.nextInt();
        String response = ownerController.deleteOwner(id);
        System.out.println(response);
    }
    private void showAllPetsMenu() {
        getAllOwnersMenu();
        System.out.println("Select an owner id: ");
        int id = scanner.nextInt();
        System.out.println(animalController.getAnimalsByOwnerId(id));
        System.out.println("All animals showed!");
    }




    private void createAnimalMenu() {
        System.out.println("Please enter animal name: ");
        String animalName = scanner.next();
        System.out.println("Please enter animal species: ");
        String animalSpecies= scanner.next();
        System.out.println("Please enter age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter gender: ");
        String gender = scanner.next();
        String response = animalController.createAnimal(animalName, animalSpecies, age, gender);
        System.out.println(response);
    }
    private void getAnimalById() {
        System.out.println("Please enter an animal id: ");
        int id = scanner.nextInt();
        if (animalController.getAnimalById(id) != null) {

            String response = animalController.getAnimalById(id).toString() + "\n" + "Showed <3";
            System.out.println(response);
        }
        else{
            System.out.println("Not found");
        }
    }
    private void getAllAnimalsMenu()  {
        String response = animalController.getAllAnimals();
        System.out.println(response);
    }
    private void updateAnimalMenu() {
        getAllAnimalsMenu();
        System.out.println("Please enter an animal id: ");
        int id = scanner.nextInt();
        System.out.println("Please enter name: ");
        System.out.println("Please enter animal name: ");
        String animalName = scanner.next();
        System.out.println("Please enter animal species: ");
        String animalSpecies= scanner.next();
        System.out.println("Please enter age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter gender: ");
        String gender = scanner.next();
        String response = animalController.updateAnimal(id, animalName, animalSpecies, age, gender);

    } // animal hud
    private void deleteAnimalMenu(){
        getAllAnimalsMenu();
        System.out.println("Please enter an animal id: ");
        int id = scanner.nextInt();
        String response = animalController.deleteAnimal(id);
        System.out.println(response);
    }
    private void showOwnerMenu() {
        getAllAnimalsMenu();
        System.out.println("Select an animal id: ");
        int id = scanner.nextInt();
        Animal animal;
        if (animalController.getAnimalById(id) != null) {
            animal = animalController.getAnimalById(id);
            int ownerId =animal.getOwnerId();
            if (ownerController.getOwnerById(ownerId) != null) {
                String response = ownerController.getOwnerById(ownerId).toString();
                System.out.println(response);
            }
            else
                System.out.println("Not found");
        }
        else
            System.out.println("Not found");




    }
    private void assignOwnerMenu() {
        getAllAnimalsMenu();
        System.out.println("Please enter an animal id: ");
        int id = scanner.nextInt();

        System.out.println("Please enter owner id: ");
        int ownerId = scanner.nextInt();

        Owner owner = ownerController.getOwnerById(ownerId);

        if (owner.getNumberOfPets() >= 20 || owner.getAge() < 10) {
            System.out.println("Owner is not deemed okay to have pets from our service");
        } else {
            if (animalController.getAnimalById(id).getOwnerId() != 0) {
                int previousOwnerId = animalController.getAnimalById(id).getOwnerId();
                System.out.println("Decreasing pet count for the previous owner");
                ownerController.updateOwnerPets(previousOwnerId, -1);
            }
            String response = animalController.updateOwnerId(id, ownerId);
            System.out.println("Increasing pet count for the new owner");
            ownerController.updateOwnerPets(ownerId, 1);
            System.out.println(response);
        }
    }



    private void createVeterinarianMenu() {
        System.out.println("Please enter name: ");
        String name = scanner.next();
        System.out.println("Please enter email: ");
        String email = scanner.next();
        System.out.println("Please enter age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter phone number: ");
        int phoneNumber = scanner.nextInt();
        System.out.println("Please enter gender: ");
        String gender = scanner.next();
        String response = veterinarianController.createVeterinarian(name, email, age, phoneNumber, gender);
        System.out.println(response);
    }
    private void getAllVeterinariansMenu() {
        String response = veterinarianController.getAllVeterinarians();
        System.out.println(response);
    }
    private void getVeterinarianById() {
        System.out.println("Please enter a user id: ");
        int id = scanner.nextInt();

        if(veterinarianController.getVeterinarianById(id) != null) {
            String response = veterinarianController.getVeterinarianById(id).toString() + "\n" + "Showed <3";
            System.out.println(response);
        }
        else
            System.out.println("Not found");

    }
    private void updateVeterinarianMenu() {
        getAllVeterinariansMenu();
        System.out.println("Please enter a veterinarian id: ");
        int id = scanner.nextInt();
        System.out.println("Please enter name: ");
        String name = scanner.next();
        System.out.println("Please enter email: ");
        String email = scanner.next();
        System.out.println("Please enter age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter phone number: ");
        int phoneNumber = scanner.nextInt();
        System.out.println("Please enter gender: ");
        String gender = scanner.next();
        String response = veterinarianController.updateVeterinarian(id, name, email, age, phoneNumber, gender);
        System.out.println(response);
    }
    private void deleteVeterinarianMenu() {
        getAllVeterinariansMenu();
        System.out.println("Please enter a veterinarian id: ");
        int id = scanner.nextInt();
        String response = veterinarianController.deleteVeterinarian(id);
        System.out.println(response);
    }// veterinarian hud
    private void getMedicalHistoryMenu() {
        getAllAnimalsMenu();
        System.out.println("Please enter an animal id: ");
        int id = scanner.nextInt();
        if (animalController.getMedicalHistory(id) != null) {
            System.out.println(animalController.getAnimalById(id).getMedicalHistoryToString());
            System.out.println("Showed <3");

        }
        else
            System.out.println("Failed to get medical history");
    }
    private void assignVeterinarianMenu() {
        getAllAnimalsMenu();
        System.out.println("Please enter an animal id: ");
        int petId = scanner.nextInt();
        getAllVeterinariansMenu();
        System.out.println("Please enter a veterinarian id: ");
        int id = scanner.nextInt();

        if (veterinarianController.getVeterinarianById(id).isOccupied()) {
            String response = "Veterinarian already occupied";
            System.out.println(response);
        } else if (animalController.getAnimalById(petId).getAppointment() != null && !animalController.getAnimalById(petId).getAppointment().equals("Not appointed")) {
            String response = "Animal already treated";
            System.out.println(response);
        } else {
            veterinarianController.updateIsOccupied(id, true);
            animalController.updateAppointment(petId, "Appointed by Veterinarian " + veterinarianController.getVeterinarianById(id).getName());
            animalController.updateVeterinarianId(petId, id);
            String response = "Appointment set";
            System.out.println(response);
        }
    }
    private void cancelAssignmentMenu() {
        getAllAnimalsMenu();
        System.out.println("Please enter an animal id: ");
        int id = scanner.nextInt();

        Animal animal = animalController.getAnimalById(id);
        if (animal == null) {
            System.out.println("Animal not found.");
            return;
        }

        if (animal.getAppointment() != null && !animal.getAppointment().equals("Not appointed")) {
            int veterinarianId = animal.getVeterinarianId();

            if (veterinarianController.getVeterinarianById(veterinarianId) != null) {
                veterinarianController.updateIsOccupied(veterinarianId, false);
                animalController.updateAppointment(id, "Not appointed");
                animalController.updateVeterinarianId(id, 0);
                String response = "Appointment cancelled";
                System.out.println(response);
            } else {
                System.out.println("Veterinarian not found.");
            }
        } else {
            System.out.println("No such appointment exists");
        }
    }
    private void finishAssignmentMenu() {
        getAllAnimalsMenu();
        System.out.println("Please enter an animal id: ");
        int animalId = scanner.nextInt();
        Animal animal = animalController.getAnimalById(animalId);
        if (animal == null) {
            System.out.println("Animal not found.");
            return;
        }
        if (animal.getAppointment() != null && !animal.getAppointment().equals("Not appointed")) {
            Veterinarian veterinarian = veterinarianController.getVeterinarianById(animal.getVeterinarianId());

            if (veterinarian == null) {
                System.out.println("Veterinarian not found.");
                return;
            }
            veterinarianController.updateIsOccupied(animal.getVeterinarianId(), false);
            animalController.updateAppointment(animalId, "Not appointed");
            animalController.updateVeterinarianId(animalId, 0);
            animalController.addMedicalHistory(animalId, "Treated by " + veterinarian.getName());
            System.out.println("Appointment finished.");
        } else {
            System.out.println("Appointment can't be finished.");
        }

    }



    private void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println("Error waiting for input: " + e.getMessage());
        }
    }
}
