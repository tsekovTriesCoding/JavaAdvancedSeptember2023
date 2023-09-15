package A6DefiningClasses.Exercise.P08FamilyTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String infoAbout = input;

        input = scanner.nextLine();
        Map<String, Person> people = new HashMap<>();

        while (!input.equals("End")) {
            if (input.contains("-")) {
                String[] tokens = input.split(" - ");
                String parentData = tokens[0];
                String childData = tokens[1];


            } else {
                String personFirstName = input.split("\\s+")[0];
                String personLastName = input.split("\\s+")[1];
                String personBirthdate = input.split("\\s+")[2];
                String fullName = personFirstName + " " + personLastName;

                Person person = new Person(fullName, personBirthdate);
                people.put(fullName, person);
            }

            input = scanner.nextLine();
        }
    }
}
