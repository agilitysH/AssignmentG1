package repos;
import data.interfaces.IDB;
import classes.Owner;
import repos.interfaces.IOwnerRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OwnerRepo implements IOwnerRepo{
    private final IDB db;
    public OwnerRepo(IDB db) {
        this.db = db;
    }
    @Override
    public boolean createOwner(Owner owner) {
        Connection conn = null;
        try {
            conn=db.getConnection();
            String sqlCommand = "INSERT INTO owners(id,name,email, age,phonenumber, gender) VALUES(?, ?, ?, ?,?, ?)";
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, owner.getId());
            st.setString(2, owner.getName());
            st.setString(3, owner.getEmail());
            st.setInt(4, owner.getAge());
            st.setInt(5, owner.getPhoneNumber());
            st.setString(6, owner.getGender());
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
    public Owner getOwnerById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "SELECT id,name,email,age,phonenumber,numberofpets,gender FROM owners WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Owner owner = new Owner();
                owner.setId(rs.getInt("id"));
                owner.setName(rs.getString("name"));
                owner.setEmail(rs.getString("email"));
                owner.setAge(rs.getInt("age"));
                owner.setPhoneNumber(rs.getInt("phoneNumber"));
                owner.setNumberOfPets(rs.getInt("numberOfPets"));
                owner.setGender(rs.getString("gender"));
                return owner;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List <Owner> getAllOwners() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "SELECT id, name, email ,age,phonenumber,numberofpets,gender FROM owners";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlCommand);
            List<Owner> owners = new ArrayList<>();
            while (rs.next()) {
                Owner owner = new Owner();
                owner.setId(rs.getInt("id"));
                owner.setName(rs.getString("name"));
                owner.setEmail(rs.getString("email"));
                owner.setAge(rs.getInt("age"));
                owner.setPhoneNumber(rs.getInt("phoneNumber"));
                owner.setNumberOfPets(rs.getInt("numberOfPets"));
                owner.setGender(rs.getString("gender"));
                owners.add(owner);
            }
            return owners;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean updateOwner(Owner owner) {
        Connection conn = null;
        try {
            conn = db.getConnection();
            String sqlCommand = "UPDATE owners SET name = ?, email = ?, age = ?, phonenumber = ?, gender = ? WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            st.setString(1, owner.getName());
            st.setString(2, owner.getEmail());
            st.setInt(3, owner.getAge());
            st.setInt(4, owner.getPhoneNumber());
            st.setString(5, owner.getGender());
            st.setInt(6, owner.getId());

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean deleteOwner(int id) {
        Connection conn = null;
        try {
            conn = db.getConnection();
            String sqlCommand = "DELETE FROM owners WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sqlCommand);

            st.setInt(1, id);

            int rowsDeleted = st.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateOwnerPets(int ownerId, int petsDelta) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "UPDATE owners SET numberofpets = numberofpets + ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setInt(1, petsDelta);
            st.setInt(2, ownerId);

            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}