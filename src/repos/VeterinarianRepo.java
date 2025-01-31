package repos;
import data.interfaces.IDB;
import classes.Veterinarian;
import repos.interfaces.IVeterinarianRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianRepo implements IVeterinarianRepo {
    private final IDB db;

    public VeterinarianRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createVeterinarian(Veterinarian veterinarian) {
        Connection con = null;
        try {
            con =db.getConnection();
            String sqlCommand = "INSERT INTO veterinarians(id, name, email, age, phonenumber, gender) VALUES(?, ?, ?, ?,?, ?)";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setInt(1, veterinarian.getId());
            st.setString(2, veterinarian.getName());
            st.setString(3, veterinarian.getEmail());
            st.setInt(4, veterinarian.getAge());
            st.setInt(5, veterinarian.getPhoneNumber());
            st.setString(6, veterinarian.getGender());
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
    public Veterinarian getVeterinarianById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "SELECT id, name, email, age, phonenumber, gender, isOccupied FROM veterinarians WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Veterinarian veterinarian = new Veterinarian();
                veterinarian.setId(rs.getInt("id"));
                veterinarian.setName(rs.getString("name"));
                veterinarian.setEmail(rs.getString("email"));
                veterinarian.setAge(rs.getInt("age"));
                veterinarian.setPhoneNumber(rs.getInt("phoneNumber"));
                veterinarian.setGender(rs.getString("gender"));
                veterinarian.setOccupied(rs.getBoolean("isOccupied"));
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
            String sqlCommand = "SELECT id, name, email, age, phonenumber, gender, isOccupied FROM veterinarians";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlCommand);
            List<Veterinarian> veterinarians = new ArrayList<>();
            while (rs.next()) {
                Veterinarian veterinarian = new Veterinarian();
                veterinarian.setId(rs.getInt("id"));
                veterinarian.setName(rs.getString("name"));
                veterinarian.setEmail(rs.getString("email"));
                veterinarian.setAge(rs.getInt("age"));
                veterinarian.setPhoneNumber(rs.getInt("phoneNumber"));
                veterinarian.setGender(rs.getString("gender"));
                veterinarian.setOccupied(rs.getBoolean("isOccupied")); // Set the isOccupied field
                veterinarians.add(veterinarian);
            }
            return veterinarians;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean updateVeterinarian(Veterinarian veterinarian) {
        Connection conn = null;
        try {
            conn = db.getConnection();
            String sqlCommand = "UPDATE veterinarians SET name = ?, email = ?, age = ?, phonenumber = ?, gender = ? WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            st.setString(1, veterinarian.getName());
            st.setString(2, veterinarian.getEmail());
            st.setInt(3, veterinarian.getAge());
            st.setInt(4, veterinarian.getPhoneNumber());
            st.setString(5, veterinarian.getGender());
            st.setInt(6, veterinarian.getId());

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteVeterinarian(int id) {
        Connection conn = null;
        try {
            conn = db.getConnection();
            String sqlCommand = "DELETE FROM veterinarians WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            st.setInt(1, id);

            int rowsDeleted = st.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean updateIsOccupied(int id, boolean isOccupied) {
        Connection conn = null;
        try {
            conn = db.getConnection();
            String sqlCommand = "UPDATE veterinarians SET isOccupied = ? WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            st.setBoolean(1, isOccupied);
            st.setInt(2, id);

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }



}