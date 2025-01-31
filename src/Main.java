import controllers.*;
import controllers.interfaces.IAnimalController;
import controllers.interfaces.IOwnerController;
import controllers.interfaces.IVeterinarianController;
import data.interfaces.IDB;
import repos.*;
import data.*;
import classes.*;
import repos.interfaces.IAnimalRepo;
import repos.interfaces.IOwnerRepo;
import repos.interfaces.IVeterinarianRepo;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB("jdbc:postgresql://localhost:5432", "postgres", "131313", "grouptaskdb");
        IAnimalRepo animalRepo = new AnimalRepo(db);
        AnimalController animalController = new AnimalController(animalRepo);
        IOwnerRepo ownerRepo = new OwnerRepo(db);
        IOwnerController ownerController = new OwnerController(ownerRepo);
        IVeterinarianRepo veterinarianRepo = new VeterinarianRepo(db);
        IVeterinarianController veterinarianController = new VeterinarianController(veterinarianRepo);
        MyApplication app = new MyApplication(ownerController,veterinarianController,animalController);
        app.start();




    }
}