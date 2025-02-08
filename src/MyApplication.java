import classes.*;
import controllers.UserController;
import controllers.interfaces.*;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Scanner;
import java.sql.SQLException;
import controllers.OrderController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
public final class MyApplication {
    private final IOwnerController ownerController;
    private final IVeterinarianController veterinarianController;
    private final IAnimalController animalController;
    private final Scanner scanner = new Scanner(System.in);
    private final IUserController userController;
    private final IOrderController orderController;

    public MyApplication(IOwnerController ownerController, IVeterinarianController veterinarianController, IAnimalController animalController, IUserController userController, IOrderController orderController) {
        this.userController = userController;
        this.ownerController = ownerController;
        this.veterinarianController = veterinarianController;
        this.animalController = animalController;
        this.orderController = orderController;
    }

    private User user;

    private boolean loginMenu() {
        System.out.println("Please enter your login: ");
        String login = scanner.next();

        scanner.nextLine();

        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        try {
            User user = userController.getUser(login);

            if (user != null) {
                if (user.getPassword().equals(password)) {
                    this.user = user;
                    return true;
                } else {
                    System.out.println("Invalid password, please try again");
                }
            } else {
                System.out.println("No such user exists, please try again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void registerMenu() {
        scanner.nextLine();
        System.out.println("Enter your login ");
        String login = scanner.nextLine();
        System.out.println("Enter your password ");
        String password = scanner.nextLine();
        userController.createUser(login, password, 1);
        this.user = userController.getUser(login);
        createOwnerMenu();
    }


    private void userMenu() {
        while (true) {
            System.out.println();
            System.out.println("Select one of the following options:");
            System.out.println("1. View unassigned pets");
            System.out.println("2. View your pets");
            System.out.println("3. Adopt pet");
            System.out.println("0. Exit");
            System.out.print("Select an option (0-3): ");

            try {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        showAllPetsMenu();
                        break;
                    case 2:
                        showAllPetsMenu();
                        break;
                    case 3:
                        assignOwnerMenu();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option! Please select a valid option.");
                }
                pressAnyKeyToContinue();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private void employeeMenu() {
        while (true) {
            System.out.println();
            System.out.println("Select one of the following options:");
            System.out.println("1. View all animals");
            System.out.println("2. Get medical history of an animal");
            System.out.println("3. Set appointment");
            System.out.println("4. Cancel appointment");
            System.out.println("5. Finish appointment");
            System.out.println("6. Show owner of an animal");
            System.out.println("0. Exit");
            System.out.print("Select an option (0-6): ");

            try {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        getAllAnimalsMenu();
                        break;
                    case 2:
                        getMedicalHistoryMenu();
                        break;
                    case 3:
                        assignVeterinarianMenu();
                        break;
                    case 4:
                        cancelAssignmentMenu();
                        break;
                    case 5:
                        finishAssignmentMenu();
                        break;
                    case 6:
                        showOwnerMenu();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option! Please select a valid option.");
                }
                pressAnyKeyToContinue();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private void adminMenu() {
        while (true) {
            System.out.println();
            System.out.println("Select one of the following options: ");
            System.out.println("1. Create animal");
            System.out.println("2. Get all users");
            System.out.println("3. Get all owners");
            System.out.println("4. Get all veterinarians:");
            System.out.println("5. Get all animals");
            System.out.println("6. Update owner");
            System.out.println("7. Update animal");
            System.out.println("8. Update veterinarian");
            System.out.println("9. Delete owner");
            System.out.println("10. Delete veterinarian");
            System.out.println("11. Delete animal");
            System.out.println("12. Create veterinarian account");
            System.out.println("13. Get owner by id");
            System.out.println("14. Get veterinarian by id");
            System.out.println("15. Get animal by id");
            System.out.println("0. Exit admin menu");

            try {
                System.out.print("Enter your choice: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        createAnimalMenu();
                        break;
                    case 2:
                        getAllUsersMenu();
                        break;
                    case 3:
                        getAllOwnersMenu();
                        break;
                    case 4:
                        getAllVeterinariansMenu();
                        break;
                    case 5:
                        getAllAnimalsMenu();
                        break;
                    case 6:
                        updateOwnerMenu();
                        break;
                    case 7:
                        updateAnimalMenu();
                        break;
                    case 8:
                        updateVeterinarianMenu();
                        break;
                    case 9:
                        deleteOwnerMenu();
                        break;
                    case 10:
                        deleteVeterinarianMenu();
                        break;
                    case 11:
                        deleteAnimalMenu();
                        break;
                    case 12:
                        registerVeterinarianMenu();
                        break;
                    case 13:
                        getOwnerById();
                        break;
                    case 14:
                        getVeterinarianById();
                        break;
                    case 15:
                        getAnimalById();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option! Please select a valid option.");
                }
                pressAnyKeyToContinue();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public void start() {
        boolean app = true;
        while (app) {
            boolean state = true;
            System.out.println("Welcome! \nWhat would you like to do?:\n1. LogIn\n2. Register\n3.Exit");
            int choice = scanner.nextInt();
            while (state) {
                switch (choice) {
                    case 1:
                        while (state) {
                            if (loginMenu()) {
                                state = false;
                            }
                            pressAnyKeyToContinue();
                        }
                        break;
                    case 2:
                        registerMenu();
                        state = false;
                        break;
                    case 3:
                        app = false;
                        break;
                    default:
                        System.out.println("Invalid option! Please select a valid option!");
                }
            }

            switch (user.getAccessLevel()) {
                case 1:
                    userMenu();
                    break;
                case 2:
                    employeeMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
            }
            state = true;
        }
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
        } else {
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
        int id = user.getId();
        animalController.getAnimalsByOwnerId(id);
        System.out.println("All pets showed!");
    }


    private void createAnimalMenu() {
        System.out.println("Please enter animal name: ");
        String animalName = scanner.next();
        System.out.println("Please enter animal species: ");
        String animalSpecies = scanner.next();
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
        } else {
            System.out.println("Not found");
        }
    }

    private void getAllAnimalsMenu() {
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
        String animalSpecies = scanner.next();
        System.out.println("Please enter age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter gender: ");
        String gender = scanner.next();
        String response = animalController.updateAnimal(id, animalName, animalSpecies, age, gender);

    } // animal hud

    private void deleteAnimalMenu() {
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
            int ownerId = animal.getOwnerId();
            if (ownerController.getOwnerById(ownerId) != null) {
                String response = ownerController.getOwnerById(ownerId).toString();
                System.out.println(response);
            } else
                System.out.println("Not found");
        } else
            System.out.println("Not found");


    }

    private void assignOwnerMenu() {
        System.out.println(animalController.getAnimalsWithoutOwner());
        System.out.println("Please enter an animal id: ");
        int id = scanner.nextInt();
        int ownerId = user.getId();

        Owner owner = ownerController.getOwnerById(ownerId);

        if (owner.getNumberOfPets() >= 20 || owner.getAge() < 10) {
            System.out.println("You are not deemed okay to have pets from our service");
        } else {
            String response = animalController.updateOwnerId(id, ownerId);
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

        if (veterinarianController.getVeterinarianById(id) != null) {
            String response = veterinarianController.getVeterinarianById(id).toString() + "\n" + "Showed <3";
            System.out.println(response);
        } else
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

        } else
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
    public void Appointment() {
        try {
            System.out.println("1. Show all appointment IDs");
            System.out.println("2. Show veterinarian and pet by appointment ID");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                OrderController.printAllOrders();
            } else if (choice == 2) {
                System.out.print("Enter appointment ID: ");
                int id = scanner.nextInt();
                OrderController.printVetAndPetById(id);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Очистка буфера ввода

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
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


    private void getAllUsersMenu() {
        String response = userController.getAllUsers();
        System.out.println(response);
    }

    private void registerVeterinarianMenu() {
        System.out.println("Enter login ");
        String login = scanner.nextLine();
        System.out.println("Enter password ");
        String password = scanner.nextLine();
        userController.createUser(login, password, 2);
        createVeterinarianMenu();
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