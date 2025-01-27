import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Animal> animals = new ArrayList<>();
    private static final List<Veterinarian> veterinarians = new ArrayList<>();
    private static final List<Owner> owners = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Animal Service Console ===");
            System.out.println("1. Add Animal");
            System.out.println("2. View All Animals");
            System.out.println("3. Add Veterinarian");
            System.out.println("4. View All Veterinarians");
            System.out.println("5. Add Owner");
            System.out.println("6. View All Owners");
            System.out.println("7. Assign Service to Animal");
            System.out.println("8. Cancel Service");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAnimal(scanner);
                case 2 -> viewAnimals();
                case 3 -> addVeterinarian(scanner);
                case 4 -> viewVeterinarians();
                case 5 -> addOwner(scanner);
                case 6 -> viewOwners();
                case 7 -> assignService(scanner);
                case 8 -> cancelService(scanner);
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAnimal(Scanner scanner) {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter animal species: ");
        String species = scanner.nextLine();
        System.out.print("Enter animal age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter animal gender: ");
        String gender = scanner.nextLine();

        Animal animal = new Animal(name, species, age, gender);
        animals.add(animal);
        DatabaseUtils.saveAnimalToDatabase(animal);
        System.out.println("Animal added and saved: " + name);
    }

    private static void viewAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals found.");
        } else {
            System.out.println("\nList of Animals:");
            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                System.out.println((i + 1) + ". " + animal.getName() + " (" + animal.getSpecies() + ") - Age: "
                        + animal.getAge() + ", Gender: " + animal.getGender() + ", Appointment: " + animal.isAppointed());
            }
        }
    }

    private static void addVeterinarian(Scanner scanner) {
        System.out.print("Enter veterinarian name: ");
        String name = scanner.nextLine();
        System.out.print("Enter veterinarian email: ");
        String email = scanner.nextLine();
        System.out.print("Enter veterinarian age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter veterinarian phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter veterinarian gender (true for male, false for female): ");
        boolean gender = scanner.nextBoolean();
        scanner.nextLine();

        Veterinarian vet = new Veterinarian(name, email, age, phoneNumber, gender);
        veterinarians.add(vet);
        DatabaseUtils.saveVeterinarianToDatabase(vet);
        System.out.println("Veterinarian added and saved: " + name);
    }

    private static void viewVeterinarians() {
        if (veterinarians.isEmpty()) {
            System.out.println("No veterinarians found.");
        } else {
            System.out.println("\nList of Veterinarians:");
            for (int i = 0; i < veterinarians.size(); i++) {
                Veterinarian vet = veterinarians.get(i);
                System.out.println((i + 1) + ". " + vet.getName() + " - Email: " + vet.getEmail() + ", Phone: "
                        + vet.getPhoneNumber() + ", Gender: " + (vet.isGender() ? "Male" : "Female"));
            }
        }
    }

    private static void addOwner(Scanner scanner) {
        System.out.print("Enter owner name: ");
        String name = scanner.nextLine();
        System.out.print("Enter owner email: ");
        String email = scanner.nextLine();
        System.out.print("Enter owner age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter owner phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter owner gender (true for male, false for female): ");
        boolean gender = scanner.nextBoolean();
        scanner.nextLine();

        Owner owner = new Owner(name, email, age, phoneNumber, gender);
        owners.add(owner);
        DatabaseUtils.saveOwnerToDatabase(owner);
        System.out.println("Owner added and saved: " + name);
    }

    private static void viewOwners() {
        if (owners.isEmpty()) {
            System.out.println("No owners found.");
        } else {
            System.out.println("\nList of Owners:");
            for (int i = 0; i < owners.size(); i++) {
                Owner owner = owners.get(i);
                System.out.println((i + 1) + ". " + owner.getName() + " - Email: " + owner.getEmail() + ", Phone: "
                        + owner.getPhoneNumber() + ", Gender: " + (owner.isGender() ? "Male" : "Female"));
            }
        }
    }

    private static void assignService(Scanner scanner) {
        viewAnimals();
        System.out.print("Enter the number of the animal to assign service: ");
        int animalIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        viewVeterinarians();
        System.out.print("Enter the number of the veterinarian: ");
        int vetIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (animalIndex >= 0 && animalIndex < animals.size() && vetIndex >= 0 && vetIndex < veterinarians.size()) {
            Animal animal = animals.get(animalIndex);
            Veterinarian vet = veterinarians.get(vetIndex);
            vet.service(animal);
            System.out.println("Service assigned to " + animal.getName() + " by " + vet.getName());
        } else {
            System.out.println("Invalid animal or veterinarian number.");
        }
    }

    private static void cancelService(Scanner scanner) {
        viewAnimals();
        System.out.print("Enter the number of the animal to cancel service: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < animals.size()) {
            Animal animal = animals.get(index);
            veterinarians.get(0).cancelService(animal);
            System.out.println("Service cancelled for " + animal.getName());
        } else {
            System.out.println("Invalid animal number.");
        }
    }
}
