package classes;

public class User {
    private String login;
    private String password;
    private int accessLevel;
    private int id = Person.getIdCounter();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }


    public boolean enterPassword(String password) {
        if (password.equals(this.password)) {
            return true;
        }
        return false;
    }


    public boolean enterLogin(String login) {
        if (login.equals(this.login)) {
            return true;
        }
        return false;
    }

    public User(String login, String password, int accessLevel) {
        this.login = login;
        this.password = password;
        this.accessLevel = accessLevel;

    }
    public User(){}
}
