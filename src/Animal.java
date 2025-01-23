import java.util.List;

public class Animal {
    private static int petIdCounter = 0;
    private int petId;
    private String name;
    private int age;
    private String species;
    private String gender;
    private int ownerId;
    private String appointment;
    private List<String> medicalHistory;

    public Animal() {
        petId = ++petIdCounter;
        appointment = "Not appointed";
    }

    public Animal(String name, String species, int age, String gender, int ownerId) {
        this();
        this.name = name;
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.ownerId = ownerId;
    }

    public Animal(String name, String species, int age, String gender) {
        this();
        this.name = name;
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.ownerId = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getOwnerId() {
        if (ownerId == 0) {
            return "No owner";
        }

        else {
            return "Owner id is " + ownerId;
        }
    }

    public int getPetId() {
        return petId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String isAppointed() {
        return appointment;
    }

    public void addMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }



}
