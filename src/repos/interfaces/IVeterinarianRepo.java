package repos.interfaces;
import java.util.List;
import classes.Veterinarian;
public interface IVeterinarianRepo {
    boolean createVeterinarian(Veterinarian veterinarian);

    Veterinarian getVeterinarianById(int id);

    List<Veterinarian> getAllVeterinarians();

    boolean updateVeterinarian(Veterinarian veterinarian);

    boolean deleteVeterinarian(int id);

    boolean updateIsOccupied(int id, boolean isOccupied);
}