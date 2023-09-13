package A5FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> invitations = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        HashMap<String, Predicate> predicates = new HashMap<>();

        while (!input.equals("Print")) {
            String[] tokens = input.substring(input.indexOf(";") + 1).split("([ ;]+)");
            int index = 2;
            if (tokens.length == 2) {
                index = 1;
            }
            String name = tokens[0] + tokens[index];
            if (input.contains("Add")) {
                Predicate<String> predicate;

                switch (tokens[0]) {
                    case "Starts":
                        predicate = s -> s.startsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Ends":
                        predicate = s -> s.endsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Length":
                        predicate = s -> s.length() == Integer.parseInt(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Contains":
                        predicate = s -> s.contains(tokens[1]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                }
            } else {
                predicates.remove(name);
            }

            input = scanner.nextLine();
        }

        for (String guest : invitations) {
            boolean isGoing = true;

            for (String entry : predicates.keySet()) {
                if (predicates.get(entry).test(guest)) {
                    isGoing = false;
                    break;
                }
            }

            if (isGoing) {
                System.out.print(guest + " ");
            }
        }
    }
}
