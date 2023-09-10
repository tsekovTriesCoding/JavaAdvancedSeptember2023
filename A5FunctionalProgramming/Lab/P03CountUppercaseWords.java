package A5FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        // 1 вариант:
        /*List<String> uppercaseWords = new ArrayList<>();
        Predicate<String> isUppercase = word -> Character.isUpperCase(word.charAt(0));

        for (String word : words) {
            if (isUppercase.test(word)) {
                uppercaseWords.add(word);
            }
        }*/

        // 2 вариант:
        Predicate<String> isUppercase = word -> Character.isUpperCase(word.charAt(0));
        words = words.stream().filter(isUppercase).collect(Collectors.toList());

        System.out.println(words.size());
        System.out.println(String.join("\n", words));
    }
}
