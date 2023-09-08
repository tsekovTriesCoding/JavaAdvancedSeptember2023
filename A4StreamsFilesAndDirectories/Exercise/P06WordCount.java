package A4StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) throws IOException {

        String pathWords = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));

        Map<String, Integer> wordsCount = new HashMap<>();

        for (String line : allLinesWithWords) {
            String[] wordsCurrentRow = line.split("\\s+");
            Arrays.stream(wordsCurrentRow).forEach(word -> {
                wordsCount.put(word, 0);
            });
        }

        String textPath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLinesWithText = Files.readAllLines(Path.of(textPath));
        for (String line : allLinesWithText) {
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (wordsCount.containsKey(word)) {
                    wordsCount.put(word, wordsCount.get(word) + 1);
                }
            }
        }

        File result = new File("C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\result.txt");
        PrintWriter writer = new PrintWriter(result);

        wordsCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));

        writer.close();
    }
}
