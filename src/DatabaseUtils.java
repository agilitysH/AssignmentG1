import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Project2";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "gagaga";

    public static void saveAnimalToDatabase(Animal animal) {
        String sql = "INSERT INTO Animal (name, species, age, gender, appointment, medicalHistory, ownerId) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, animal.getName());
            stmt.setString(2, animal.getSpecies());
            stmt.setInt(3, animal.getAge());
            stmt.setString(4, animal.getGender());
            stmt.setString(5, animal.isAppointed());
            stmt.setString(6, String.join(", ", animal.getMedicalHistory()));
            stmt.setNull(7, java.sql.Types.INTEGER);

            stmt.executeUpdate();
            System.out.println("Animal saved: " + animal.getName());

        } catch (SQLException e) {
            System.err.println("Failet to save Animal: " + animal.getName());
            e.printStackTrace();
        }
    }

    public static void saveVeterinarianToDatabase(Veterinarian vet) {
        String sql = "INSERT INTO Person (name, email, age, phoneNumber, gender) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, vet.getName());
            stmt.setString(2, vet.getEmail());
            stmt.setInt(3, vet.getAge());
            stmt.setInt(4, vet.getPhoneNumber());
            stmt.setBoolean(5, vet.isGender());

            stmt.executeUpdate();
            System.out.println("Veterinarian saved: " + vet.getName());

        } catch (SQLException e) {
            System.err.println("Failed to save veterinarian: " + vet.getName());
            e.printStackTrace();
        }
    }

    public static void saveOwnerToDatabase(Owner owner) {
        String sql = "INSERT INTO Person (name, email, age, phoneNumber, gender) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, owner.getName());
            stmt.setString(2, owner.getEmail());
            stmt.setInt(3, owner.getAge());
            stmt.setInt(4, owner.getPhoneNumber());
            stmt.setBoolean(5, owner.isGender());

            stmt.executeUpdate();
            System.out.println("Owner saved: " + owner.getName());

        } catch (SQLException e) {
            System.err.println("Failed to save owner: " + owner.getName());
            e.printStackTrace();
        }
    }
}
