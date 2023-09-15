package A6DefiningClasses.Exercise.P07Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Person> people = new HashMap<>();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String name = tokens[0];
            String infoAbout = tokens[1];

            switch (infoAbout) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
                    Person person = new Person();
                    person.setCompany(company);

                    if (!people.containsKey(name)) {
                        people.put(name, person);
                    } else {
                        people.get(name).setCompany(company);
                    }
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    if (!people.containsKey(name)) {
                        person = new Person();
                        person.getPokemons().add(pokemon);
                        people.put(name, person);
                    } else {
                        people.get(name).getPokemons().add(pokemon);
                    }
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parent parent = new Parent(parentName, parentBirthday);

                    if (!people.containsKey(name)) {
                        person = new Person();
                        person.getParents().add(parent);
                        people.put(name, person);
                    } else {
                        people.get(name).getParents().add(parent);
                    }
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Child child = new Child(childName, childBirthday);

                    if (!people.containsKey(name)) {
                        person = new Person();
                        person.getChildren().add(child);
                        people.put(name, person);
                    } else {
                        people.get(name).getChildren().add(child);
                    }
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);
                    person = new Person();
                    person.setCar(car);
                    if (!people.containsKey(name)) {
                        people.put(name, person);
                    } else {
                        people.get(name).setCar(car);
                    }
                    break;

            }

            command = scanner.nextLine();
        }

        String name = scanner.nextLine();

        if (people.containsKey(name)) {
            System.out.println(name);
            System.out.print(people.get(name));
        }
    }
}
