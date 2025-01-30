package classes;

import java.util.List;

public class Owner extends Person {

    private int numberOfPets;

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


}
