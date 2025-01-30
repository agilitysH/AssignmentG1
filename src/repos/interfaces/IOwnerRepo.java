package repos.interfaces;
import java.util.List;
import classes.Owner;
public interface IOwnerRepo {
        boolean createOwner(Owner owner);
        Owner getOwnerById(int id);
        List<Owner> getAllOwners();
    }
