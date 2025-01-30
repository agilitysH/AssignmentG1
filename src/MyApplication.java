import controllers.interfaces.IOwnerController;
import repos.interfaces.IOwnerRepo;
import controllers.interfaces.IAnimalController;
import controllers.interfaces.IVeterinarianController;
import repos.interfaces.IVeterinarianRepo;
import repos.interfaces.IAnimalRepo;
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

    private int mainMenu() {
        System.out.println();
        System.out.println("Welcome to My Application");
        System.out.println("Select one of the following options:");
        System.out.println("1. Owner Menu");
        System.out.println("2. Veterinarian Menu");
        System.out.println("3. Animal Menu");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Select an option (1-3): ");
        return 0;
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
        System.out.println("2. Get owner by phone number");
        System.out.println("3. Get all owners");
        System.out.println("0. Back to main menu");
        System.out.print("Select an option (0-3): ");

        try {
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    createOwnerMenu();
                    break;
                case 2:
                    getOwnerByPhoneNumberMenu();
                    break;
                case 3:
                    getAllOwnersMenu();
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
    }

    private void createOwnerMenu() {
        System.out.println("Please enter name: ");
        String name = scanner.next();
        System.out.println("Please enter surname: ");
        String surname = scanner.next();
        System.out.println("Please enter age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter phone number: ");
        int phoneNumber = scanner.nextInt();
        System.out.println("Please enter number of pets: ");
        int numberOfPets = scanner.nextInt();
        System.out.println("Please enter gender (male/female: ");
        boolean gender = scanner.nextInt() == 1;
        if (gender) {
            System.out.println("Male");
        } else {
            System.out.println("Female");
        }
        String response = ownerController.createOwner(name, surname, age, phoneNumber, numberOfPets, gender);
        System.out.println(response);
    }

    private void getOwnerByPhoneNumberMenu() {
        System.out.println("Please enter a owner phone number: ");
        int phoneNumber = scanner.nextInt();

        String response = ownerController.getOwnerByPhoneNumber(phoneNumber);
        System.out.println(response);
    }

    private void getAllOwnersMenu() {
        String response = ownerController.getAllOwners();
        System.out.println(response);
    }

    private void veterinarianMenu() {
        System.out.println();
        System.out.println("Owner Menu:");
        System.out.println("1. Creat new veterinarian");
        System.out.println("2. Get veterinarian by phone number");
        System.out.println("3. Get all veterinarians");
        System.out.println("0. Back to main menu");
        System.out.print("Select an option (0-3): ");

        try {
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    createVeterinarianMenu();
                    break;
                case 2:
                    getVeterinarianByPhoneNumberMenu();
                    break;
                case 3:
                    getAllVeterinariansMenu();
                    break;
                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid option!" + e);
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        System.out.println("Please enter gender (male/female: ");
        boolean gender = scanner.nextInt() == 1;
        if (gender) {
            System.out.println("Male");
        } else {
            System.out.println("Female");
        }
        String response = veterinarianController.createVeterinarian(name, email, age, phoneNumber, gender);
        System.out.println(response);
    }

    private void getVeterinarianByPhoneNumberMenu() {
        System.out.println("Please enter a user phone number: ");
        int phoneNumber = scanner.nextInt();

        String response = veterinarianController.getVeterinarianByPhoneNumber(phoneNumber);
        System.out.println(response);
    }

    private void getAllVeterinariansMenu() {
        String response = veterinarianController.getAllVeterinarians();
        System.out.println(response);
    }
    private void animalMenu() {
        System.out.println();
        System.out.println("Animal Menu:");
        System.out.println("1. Create new animal");
        System.out.println("2. Get animal by id");
        System.out.println("3. Get all animals");
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
                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid option!" + e);
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void createAnimalMenu() {
        System.out.println("Please enter animal name: ");
        String animalName = scanner.next();
        System.out.println("Please enter animal species: ");
        String animalSpecies= scanner.next();
        System.out.println("Please enter age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter gender (male/female: ");
        String gender = scanner.next();
        String response = animalController.createAnimal(animalName, animalSpecies, age, gender);
        System.out.println(response);
    }

    private void getAnimalById() {
        System.out.println("Please enter an animal id: ");
        int id = scanner.nextInt();

        String response = animalController.getAnimalById(id);
        System.out.println(response);
    }

    private void getAllAnimalsMenu() {
        String response = animalController.getAllAnimals();
        System.out.println(response);
    }
}
