package controllers;

import controllers.interfaces.IUserController;
import repos.interfaces.IUserRepo;
import classes.User;

import java.util.List;

public class UserController implements IUserController {
    private final IUserRepo repo;
    public UserController(IUserRepo repo) { this.repo = repo; }

    @Override
    public String createUser(String login, String password, int accessLevel){
        boolean created = repo.createUser(new User(login,password,accessLevel));
        return created?"Created":"Creation failed";
    }

    @Override
    public String getAllUsers(){
        List<User> users = repo.getAllUsers();
        if(users.isEmpty()){
            return "No users found";
        }
        StringBuilder result = new StringBuilder();
        for(User user : users){
            result.append(user.getLogin()).append(",");
            result.append(user.getPassword()).append(",");
            result.append(user.getAccessLevel()).append(",");
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String deleteUser(String login){
        boolean deleted = repo.deleteUser(login);
        return deleted?"Deleted":"Deletion failed";
    }

    @Override
    public User getUser(String login){
        return repo.findUserByLogin(login);
    }

    @Override
    public String updateUser(String login, String password, int accessLevel){
        boolean updated = repo.updateUser(login,password,accessLevel);
        return updated?"Updated":"Update failed";
    }

}
