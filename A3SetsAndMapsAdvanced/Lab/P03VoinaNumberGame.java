package A3SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);

            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }

        String output = "Draw";
        if (firstPlayer.size() > secondPlayer.size()) {
            output = "First player win!";
        } else if (firstPlayer.size() < secondPlayer.size()) {
            output = "Second player win!";
        }

        System.out.println(output);


    }

}
