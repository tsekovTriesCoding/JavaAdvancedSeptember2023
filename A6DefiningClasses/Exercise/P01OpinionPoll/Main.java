package A6DefiningClasses.Exercise.P01OpinionPoll;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.sort(Comparator.comparing(person -> person.getName()));
        Predicate<Person> checkAge = person -> person.getAge() > 30;

        people.stream().filter(checkAge).forEach(person ->
                System.out.println(person.getName() + " - " + person.getAge()));
    }
}
