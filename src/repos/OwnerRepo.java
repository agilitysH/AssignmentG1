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
            String sqlCommand = "INSERT INTO owners(name,surname,age,phoneNumber,numberOfPets,gender) VALUES(?, ?, ?, ?,?, ?)";
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, owner.getName());
            st.setString(2, owner.getSurname());
            st.setInt(3, owner.getAge());
            st.setInt(4, owner.phoneNumber());
            st.setInt(5, owner.getNumberOfPets());
            st.setString(6, owner.Gender());
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
            String sqlCommand = "name,surname,age,phoneNumber,numberOfPets,gender FROM owners WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Owner owner = new Owner();
                owner.setName(rs.getString("name"));
                owner.setSurname(rs.getString("surname"));
                owner.setAge(rs.getInt("age"));
                owner.setPhoneNumber(rs.getInt("phoneNumber"));
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
            String sqlCommand = "name,surname,age,phoneNumber,numberOfPets,gender FROM owners";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlCommand);
            List<Owner> owners = new ArrayList<>();
            while (rs.next()) {
                Owner owner = new Owner();
                Owner owner = new Owner();
                owner.setName(rs.getString("name"));
                owner.setSurname(rs.getString("surname"));
                owner.setAge(rs.getInt("age"));
                owner.setPhoneNumber(rs.getInt("phoneNumber"));
                owner.setGender(rs.getString("gender"));
                return owner;

            }
            return owners;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}