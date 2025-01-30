import controllers.*;
import controllers.interfaces.IAnimalController;
import controllers.interfaces.IOwnerController;
import data.interfaces.IDB;
import repos.*;
import data.*;
import classes.*;
import repos.interfaces.IAnimalRepo;
import repos.interfaces.IOwnerRepo;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB("jdbc:postgresql://localhost:5432", "postgres", "131313", "grouptaskdb");
        IAnimalRepo animalRepo = new AnimalRepo(db);
        AnimalController animalController = new AnimalController(animalRepo);
        Test test = new Test(animalController);
        IOwnerRepo ownerRepo = new OwnerRepo(db);
        OwnerController ownerController = new OwnerController(ownerRepo);
        MyApplication app = new MyApplication(ownerController);
        app.start();




    }
}