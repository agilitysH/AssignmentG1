public class Veterinarian extends Person implements IService {
    Veterinarian() {
        super();
    }
    Veterinarian(String name, String email, int age, int phoneNumber, boolean gender) {
        super(name, email, age, phoneNumber, gender);
    }


    @Override
    public void service(Animal pet) {
        pet.setAppointment("Appointed by Veterinarian " + getName());
    }

    @Override
    public void cancelService(Animal pet) {
        pet.setAppointment("Not appointed");

    }

    @Override
    public void serviceFinished(Animal pet) {
        pet.addMedicalHistory("Treated by Veterinarian " + getName());
    }
    cancelService(Animal pet)
}
