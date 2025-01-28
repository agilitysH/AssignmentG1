package classes;

import java.util.List;

public class Animal {
    private static int petIdCounter = 0;
    private int petId;
    private String name;
    private String species;
    private int age;

    private String gender;
    private int ownerId;
    private String appointment;
    private List<String> medicalHistory;

    public Animal() {
        petId = ++petIdCounter;
        appointment = "Not appointed";
    }

    public void setPetId(int petId) {
        this.petId = petId;
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

    public int getOwnerId() {
        return ownerId;
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

    @Override
    public String toString() {
        return "Animal petId= " + petId + ", name= " + name + ", species= " + species + ", age= " + age + ", gender= " + gender + ", ownerId= " + ownerId + ", appointment= " + appointment + ", medicalHistory= " + medicalHistory;
    }

}
