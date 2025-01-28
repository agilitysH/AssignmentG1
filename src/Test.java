import controllers.*;
import controllers.interfaces.IAnimalController;
import repos.*;
import data.*;
import classes.*;

import java.util.Scanner;

public class Test {
    Test(IAnimalController controller) {
        this.controller = (AnimalController) controller;
    }

    private final Scanner scanner = new Scanner(System.in);

    private final AnimalController controller;

    public Test(AnimalController controller) {
        this.controller = controller;
    }

    public void create(){
        System.out.println("name");
        String name = scanner.nextLine();
        System.out.println("species");
        String species = scanner.nextLine();
        System.out.println("age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("gender");
        String gender = scanner.nextLine();
        String res = controller.createAnimal(name, species, age, gender);
        System.out.println(res);
    }


}
