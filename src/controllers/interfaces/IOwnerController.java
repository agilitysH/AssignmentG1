package controllers.interfaces;

import classes.Owner;

public interface IOwnerController {
    String createOwner(String name, String surname, int age, int phoneNumber, String gender);

    Owner getOwnerById(int id);

    String getAllOwners();

    String updateOwner(int id, String name, String email, int age, int phoneNumber, String gender);

    String deleteOwner(int id);

    String updateOwnerPets(int ownerId, int petsDelta);
}

