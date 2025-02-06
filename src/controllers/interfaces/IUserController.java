package controllers.interfaces;

import classes.User;

public interface IUserController {
    String createUser(String login, String password, int accessLevel);

    String getAllUsers();

    String deleteUser(String login);

    User getUser(String login);

    String updateUser(String login, String password, int accessLevel);
}
