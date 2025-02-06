package repos.interfaces;

import classes.User;

import java.util.List;

public interface IUserRepo {
    List<User> getAllUsers();

    User findUserByLogin(String login);

    boolean createUser(User user);

    boolean updateUser(String login, String password, int accessLevel);

    boolean deleteUser(String login);
}
