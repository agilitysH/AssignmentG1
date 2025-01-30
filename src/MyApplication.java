import controllers.interfaces.IOwnerController;
import repos.interfaces.IOwnerRepo;
import java.util.InputMismatchException;
import java.util.Scanner;
public static class MyApplication {
    private final IOwnerController controller;
    private final Scanner scanner = new Scanner(System.in);

    public MyApplication(IOwnerController controller) {
        this.controller = controller;
    }

    private void mainMenu() {
        System.out.println();
        System.out.println("Welcome to My Application");
        System.out.println("Select one of the following options:");
        System.out.println("1. Get all owners");
        System.out.println("2. Get owner by phone number");
        System.out.println("3. Create new owner");
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
                        createOwnerMenu();
                        break;
                    case 2:
                        getOwnerByPhoneNumberMenu();
                        break;
                    case 3:
                        getAllOwnersMenu();
                        break;
                    default:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option!" + e);
                scanner.nextLine(); //to ignore incorrect input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("----------------------------------------");
        }
    }

    private void createOwnerMenu() {
        System.out.println("Please enter name: ");
        String name = scanner.next();
        System.out.println("Please enter surname: ");
        String surname = scanner.next();
        System.out.println("Please enter age: ");
        String age = String.valueOf(Integer.parseInt(scanner.next()));
        System.out.println("Please enter phone number: ");
        String phoneNumber = String.valueOf(Integer.parseInt(scanner.next()));
        System.out.println("Please enter number of pets: ");
        String numberOfPets = String.valueOf(Integer.parseInt(scanner.next()));
        System.out.println("Please enter gender (male/female: ");
        String gender = scanner.next();

        String response = controller.createOwner(name, surname, age, phoneNumber, numberOfPets, gender);
        System.out.println(response);
    }

    private void getOwnerByPhoneNumberMenu() {
        System.out.println("Please enter a user phone number: ");
        int phoneNumber = scanner.nextInt();

        String response = controller.getOwnerByPhoneNumber(phoneNumber);
        System.out.println(response);
    }

    private void getAllOwnersMenu() {
        String response = controller.getAllOwners();
        System.out.println(response);
    }
}