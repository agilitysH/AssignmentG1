package classes;
import classes.Order;
import java.util.ArrayList;
import java.util.List;
public class Veterinarian extends Person {
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    private boolean isOccupied;

    private int amountOfAppointments = 0;

    public int getAmountOfAppointments() {
        return amountOfAppointments;
    }

    public void setAmountOfAppointments(int amountOfAppointments) {
        this.amountOfAppointments = amountOfAppointments;
    }


    public Veterinarian() {
        super();
    }

    public Veterinarian(String name, String email, int age, int phoneNumber, String gender) {
        super(name, email, age, phoneNumber, gender);
    }

    public void service(Animal pet) {
        pet.setAppointment("Appointed by Veterinarian " + getName());
    }

    public void cancelService(Animal pet) {
        pet.setAppointment("Not appointed");

    }

    public void serviceFinished(Animal pet) {
        pet.addMedicalHistory("Treated by Veterinarian " + getName());
        cancelService(pet);
    }

    @Override
    public String toString() {
        return "Owner id = " + getId() + " name = " + getName() + " email = " + getEmail() + " age = " + getAge() + " phone number = " + getPhoneNumber() + " gender = " + getGender() + " is occupied = " + (isOccupied ? "occupied" : "not occupied");
    }
}
