package repos;

import data.interfaces.IDB;
import repos.interfaces.IUserRepo;
import classes.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements IUserRepo {
    private final IDB db;
    public UserRepo(IDB db) {
        this.db = db;
    }

    @Override
    public List<User> getAllUsers() {
        Connection conn = null;
        try {
            conn = db.getConnection();
            String sqlCommand = "SELECT login, password, accesslevel, id FROM USERS";
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setAccessLevel(rs.getInt("accesslevel"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserByLogin(String login) {
        Connection conn = null;
        try{
            conn = db.getConnection();
            String sqlCommand = "SELECT login, password, accesslevel, id FROM USERS WHERE login = ?";
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, login);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setAccessLevel(rs.getInt("accesslevel"));
                user.setId(rs.getInt("id"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createUser(User user) {
        Connection conn = null;
        try{

            conn = db.getConnection();
            String sqlCommand = "INSERT INTO USERS (login, password, accesslevel, id) VALUES (?, ?, ?,?)";
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.setInt(3, user.getAccessLevel());
            st.setInt(4, user.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(String login, String password, int accessLevel) {
        Connection conn = null;
        try {
            conn = db.getConnection();
            String sqlCommand = "UPDATE USERS SET login = ?, password = ?, accesslevel = ? WHERE login = ?";
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, login);
            st.setString(2, password);
            st.setInt(3, accessLevel);
            int i = st.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean deleteUser(String login) {
        Connection conn = null;
        try {
            conn = db.getConnection();
            String sqlCommand = "DELETE FROM USERS WHERE login = ?";
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, login);
            int i = st.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
