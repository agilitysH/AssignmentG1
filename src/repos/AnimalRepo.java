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
        try {
            Connection con = null;
            con = db.getConnection();
            String sqlCommand = "INSERT INTO animals(petId,name,species,age, gender, ownerid) VALUES(?, ?, ?, ?,?,?)";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setInt(1, animal.getPetId());
            st.setString(2, animal.getName());
            st.setString(3, animal.getSpecies());
            st.setInt(4, animal.getAge());
            st.setString(5, animal.getGender());
            st.setInt(6, animal.getOwnerId());
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
            String sqlCommand = "SELECT petid, name, species, age, gender, ownerid, appointment, medicalhistory, veterinarianid FROM animals WHERE petid = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Animal animal = new Animal();
                animal.setPetId(rs.getInt("petid"));
                animal.setName(rs.getString("name"));
                animal.setSpecies(rs.getString("species"));
                animal.setAge(rs.getInt("age"));
                animal.setGender(rs.getString("gender"));
                animal.setOwnerId(rs.getInt("ownerid"));
                animal.setAppointment(rs.getString("appointment"));
                String medicalHistoryStr = rs.getString("medicalhistory");
                animal.setVeterinarianId(rs.getInt("veterinarianid"));

                List<String> medicalHistory = new ArrayList<>();
                if (medicalHistoryStr != null && !medicalHistoryStr.isEmpty()) {
                    String[] historyItems = medicalHistoryStr.split(",");
                    for (String item : historyItems) {
                        medicalHistory.add(item.trim());
                    }
                }
                animal.setMedicalHistory(medicalHistory);
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
            String sqlCommand = "SELECT petid, name, species, age, gender, ownerid, appointment, medicalhistory FROM animals";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlCommand);
            List<Animal> animals = new ArrayList<>();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setPetId(rs.getInt("petid"));
                animal.setName(rs.getString("name"));
                animal.setSpecies(rs.getString("species"));
                animal.setAge(rs.getInt("age"));
                animal.setGender(rs.getString("gender"));
                animal.setOwnerId(rs.getInt("ownerid"));
                animal.setAppointment(rs.getString("appointment"));
                String medicalHistoryStr = rs.getString("medicalhistory");
                List<String> medicalHistory = new ArrayList<>();
                if (medicalHistoryStr != null && !medicalHistoryStr.isEmpty()) {
                    String[] historyItems = medicalHistoryStr.split(",");
                    for (String item : historyItems) {
                        medicalHistory.add(item.trim());
                    }
                }
                animal.setMedicalHistory(medicalHistory);
                animals.add(animal);
            }
            return animals;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean deleteAnimal(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "DELETE FROM animals WHERE petid = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setInt(1, id);
            int rowsDeleted = st.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAnimal(int petId, String name, String species, int age, String gender) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "UPDATE animals SET name = ?, species = ?, age = ?, gender = ? WHERE petid = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setString(1, name);
            st.setString(2, species);
            st.setInt(3, age);
            st.setString(4, gender);
            st.setInt(5, petId);
            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
        @Override
        public boolean updateOwnerId(int petId, int ownerId) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sqlCommand = "UPDATE animals SET ownerid = ? WHERE petid = ?";
                PreparedStatement st = con.prepareStatement(sqlCommand);
                st.setInt(1, ownerId);
                st.setInt(2, petId);
                int rowsUpdated = st.executeUpdate();
                return rowsUpdated > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public List<String> getMedicalHistory(int petId) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sqlCommand = "SELECT medicalhistory FROM animals WHERE petid = ?";
                PreparedStatement st = con.prepareStatement(sqlCommand);
                st.setInt(1, petId);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String history = rs.getString("medicalHistory");
                    return List.of(history.split(","));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
    @Override
    public List<Animal> getAnimalsByOwnerId(int ownerId) {
        Connection con = null;
        List<Animal> animals = new ArrayList<>();
        try {
            con = db.getConnection();
            String sqlCommand = "SELECT petid, name, species, age, gender, ownerid FROM animals WHERE ownerid = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setInt(1, ownerId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setPetId(rs.getInt("petid"));
                animal.setName(rs.getString("name"));
                animal.setSpecies(rs.getString("species"));
                animal.setAge(rs.getInt("age"));
                animal.setGender(rs.getString("gender"));
                animal.setOwnerId(rs.getInt("ownerid"));
                animals.add(animal);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return animals;
    }
    @Override
    public boolean updateAppointment(int petId, String appointment) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "UPDATE animals SET appointment = ? WHERE petid = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setString(1, appointment);
            st.setInt(2, petId);
            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean updateVeterinarianId(int petId, int veterinarianId) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "UPDATE animals SET veterinarianId = ? WHERE petid = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);
            st.setInt(1, veterinarianId);
            st.setInt(2, petId);
            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addMedicalHistory(int petId, String newRecord) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sqlCommand = "UPDATE animals SET medicalHistory = CONCAT(medicalHistory, ?, ',') WHERE petId = ?";
            PreparedStatement st = con.prepareStatement(sqlCommand);

            st.setString(1, newRecord);
            st.setInt(2, petId);

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
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


