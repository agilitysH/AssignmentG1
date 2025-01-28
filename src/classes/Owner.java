package classes;

import java.util.List;

public class Owner extends Person {
private List<Animal> pets;

public void addPet(Animal animal) {
    pets.add(animal);
}

public List<Animal> getPets() {
    return pets;
}

    public Owner() {
        super();
    }

    public Owner(String name, String surname, int age, int phoneNumber, int numberOfPets, boolean gender) {
        super(name, surname, age, phoneNumber, gender);
    }

    public Owner(String name, String surname, int age, int phoneNumber, boolean gender) {
        super(name, surname, age, phoneNumber, gender);
    }
}
