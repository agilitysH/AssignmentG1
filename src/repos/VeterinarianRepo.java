package repos;
import data.interfaces.IDB;
import classes.Veterinarian;
import repos.interfaces.IVeterinarianRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianRepo implements IVeterinarianRepo {
    private final IDB db;
    public Repo(IDB db) {
        this.db = db;
    }
    @Override
    public boolean createVeterinarian(Veterinarian veterinarian) {
        Connection con = null;
        try {
            con =db.getConnection();
            String sqlCommand = "INSERT INTO veterinarians(name, email, age, phoneNumber, gender) VALUES(?, ?, ?, ?,?)";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setString(1, veterinarian.getName());
            st.setString(2, veterinarian.getEmail());
            st.setInt(3, veterinarian.getAge());
            st.setInt(4, veterinarian.getPhoneNumber());
            st.setString(5, veterinarian.getGender());
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
    public Veterinarian getVeterinarianByPhoneNumber(int phoneNumber) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "SELECT name, email, age, phoneNumber, gender FROM veterinarians WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);

            st.setInt(1, phoneNumber);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Veterinarian veterinarian = new Veterinarian();
                veterinarian.setName(rs.getInt("name")); //
                veterinarian.setEmail(rs.getString("email"));
                veterinarian.setAge(rs.getString("age"));
                veterinarian.setPhoneNumber(rs.getInt("phoneNumber"));
                veterinarian.setGender(rs.getString("gender"));
                return veterinarian;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Veterinarian> getAllVeterinarians() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "SELECT name, email, age, phoneNumber, gender FROM veterinarians";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlCommand);
            List<Veterinarian> veterinarians = new ArrayList<>();
            while (rs.next()) {
                Veterinarian veterinarian = new Veterinarian();
                veterinarian.setName(rs.getInt("name")); //
                veterinarian.setEmail(rs.getString("email"));
                veterinarian.setAge(rs.getString("age"));
                veterinarian.setPhoneNumber(rs.getInt("phoneNumber"));
                veterinarian.setGender(rs.getString("gender"));
            }
            return veterinarians;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}