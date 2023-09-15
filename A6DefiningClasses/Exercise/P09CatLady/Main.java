package A6DefiningClasses.Exercise.P09CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Cat> cats = new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double info = Double.parseDouble(tokens[2]);

            switch (breed) {
                case "StreetExtraordinaire":
                    Cat cat = new Cat(name,breed, info);
                    cats.add(cat);
                    break;
                case "Cymric":
                    cat = new Cat(name, breed, info);
                    cats.add(cat);
                    break;
                case "Siamese":
                    cat = new Cat(name, breed, info);
                    cats.add(cat);
                    break;
            }

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();

        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                System.out.print(cat);
                break;
            }
        }

    }
}
