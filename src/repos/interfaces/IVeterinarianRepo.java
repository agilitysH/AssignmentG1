package repos.interfaces;
import java.util.List;
import classes.Veterinarian;
public interface IVeterinarianRepo {
    boolean createVeterinarian(Veterinarian veterinarian);
    Veterinarian  getVeterinarianByPhoneNumber(int phoneNumber);
    List<Veterinarian> getAllVeterinarians();

}