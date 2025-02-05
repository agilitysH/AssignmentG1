package classes;

import java.util.List;

public class Owner extends Person {

    private int numberOfPets = 0;

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }



    public Owner() {
        super();
    }

    public Owner(String name, String email, int age, int phoneNumber, int numberOfPets, String gender) {
        super(name, email, age, phoneNumber, gender);
        this.numberOfPets = numberOfPets;
    }

    public Owner(String name, String email, int age, int phoneNumber, String gender) {
        super(name, email, age, phoneNumber, gender);
        this.numberOfPets = 1;
    }

    @Override
    public String toString() {
        return "Owner id = " + getId() + " name = " + getName() + " email = " + getEmail() + " age = " + getAge() + " phone number = " + getPhoneNumber() + " gender = " + getGender() + " numberOfPets = " + numberOfPets;
    }
}
