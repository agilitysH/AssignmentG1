package classes;
public class Veterinarian extends Person{

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
        pet.setAppointment("Appointed by Classes.Veterinarian " + getName());
    }

    public void cancelService(Animal pet) {
        pet.setAppointment("Not appointed");

    }

    public void serviceFinished(Animal pet) {
        pet.addMedicalHistory("Treated by Classes.Veterinarian " + getName());
        cancelService(pet);
    }

}
