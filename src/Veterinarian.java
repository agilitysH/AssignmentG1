public class Veterinarian extends Person implements IService {
    Veterinarian() {
        super();
    }
    Veterinarian(String name, String email, int age, int phoneNumber, boolean gender) {
        super(name, email, age, phoneNumber, gender);
    }


    @Override
    public void Service(Animal pet) {
        pet.setAppointment("Appointed by Veterinarian " + getName());
    }

    @Override
    public void CancelService(Animal pet) {
        pet.setAppointment("Not appointed");

    }

    @Override
    public void ServiceFinished(Animal pet) {
        pet.addMedicalHistory("Treated by Veterinarian " + getName());
    }
}
