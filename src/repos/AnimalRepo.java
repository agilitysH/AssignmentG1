package repos;

import data.interfaces.IDB;
import classes.Animal;
import repos.interfaces.IAnimalRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepo implements IAnimalRepo {
    private final IDB db;

    public AnimalRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createAnimal(Animal animal) {
        Connection con = null;
        try {
            con =db.getConnection();
            String sqlCommand = "INSERT INTO animals(petId,name,species,age, gender /*ownerId*/) VALUES(?, ?, ?, ?,?)";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setInt(1, animal.getPetId());
            st.setString(2, animal.getName());
            st.setString(3, animal.getSpecies());
            st.setInt(4, animal.getAge());
            st.setString(5, animal.getGender());
            /*st.setInt(5, animal.getOwnerId());*/
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
    public Animal getAnimalById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "SELECT petId, name, species, age, gender /*ownerId*/ FROM animals WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Animal animal = new Animal();
                animal.setPetId(rs.getInt("petId")); //
                animal.setName(rs.getString("name"));
                animal.setSpecies(rs.getString("species"));
                animal.setAge(rs.getInt("age"));
                animal.setGender(rs.getString("gender"));
                //animal.setOwnerId(rs.getInt("ownerId"));
                return animal;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Animal> getAllAnimals() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "SELECT petId,name,age,species,gender/*,ownerId*/ FROM animals";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlCommand);
            List<Animal> animals = new ArrayList<>();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setPetId(rs.getInt("petId")); //
                animal.setName(rs.getString("name"));
                animal.setSpecies(rs.getString("species"));
                animal.setAge(rs.getInt("age"));
                animal.setGender(rs.getString("gender"));
                //animal.setOwnerId(rs.getInt("ownerId"));

            }
            return animals;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
