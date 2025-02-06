package classes;
abstract public class Person {
    private String name;
    private String email;
    private int phoneNumber;
    private int age;
    private static int idCounter = 1;
    private int id;
    private String gender;
    public Person() {
        id = idCounter++;
    }
    public Person(String name, String email, int age, int phoneNumber, String gender) {
        this();
        this.name = name;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void counterDecrease(){
        idCounter--;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void setIdCounter(int idCounter) {
        Person.idCounter = idCounter;
    }

    public void setId(int id) {
        this.id = id;
    }


}
