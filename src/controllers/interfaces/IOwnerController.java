package controllers.interfaces;
public interface IOwnerController {
    String createOwner(String name, String surname, int age, int phoneNumber, int numberOfPets, boolean gender);

    String getOwnerById(int id);

    String getOwnerByPhoneNumber(int phoneNumber);

    String getAllOwners();
}

