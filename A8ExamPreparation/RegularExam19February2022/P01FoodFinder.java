package A8ExamPreparation.RegularExam19February2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(v -> vowels.offer(v.charAt(0)));

        ArrayDeque<Character> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(c -> consonants.push(c.charAt(0)));

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"____", "_____", "____", "_____"};

        while (!consonants.isEmpty()) {
            char vowel = vowels.poll();
            char consonant = consonants.pop();

            for (int i = 0; i < words.length; i++) {
                String currentWord = words[i];
                int indexOfVowel = currentWord.indexOf(vowel);
                int indexOfConsonant = currentWord.indexOf(consonant);

                if (indexOfVowel >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexOfVowel) + vowel + foundWords[i].substring(indexOfVowel + 1);
                }
                if (indexOfConsonant >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexOfConsonant) + consonant + foundWords[i].substring(indexOfConsonant + 1);
                }
            }

            vowels.offer(vowel);
        }

        List<String> completeWords = Arrays.stream(foundWords)
                .filter(word -> !word.contains("_")).collect(Collectors.toList());
        System.out.printf("Words found: %d%n", completeWords.size());
        completeWords.forEach(System.out::println);
    }
}
