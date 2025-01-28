import controllers.*;
import controllers.interfaces.IAnimalController;
import data.interfaces.IDB;
import repos.*;
import data.*;
import classes.*;
import repos.interfaces.IAnimalRepo;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB("jdbc:postgresql://localhost:5432", "postgres", "131313", "grouptaskdb");
        IAnimalRepo animalRepo = new AnimalRepo(db);
        IAnimalController animalController = new AnimalController(animalRepo);
        Test test = new Test(animalController);
        test.create();
        test.create();
        test.create();
        test.create();

    }
}