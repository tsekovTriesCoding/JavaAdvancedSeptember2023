package A4StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(filePath));

        int vowels = 0;
        int otherSymbols = 0;
        int punctuation = 0;

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                    vowels++;
                } else if (symbol == '!' || symbol == '?' || symbol == '.' || symbol == ',') {
                    punctuation++;
                } else if (symbol != ' ') {
                    otherSymbols++;
                }
            }

        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Other symbols: " + otherSymbols);
        System.out.println("Punctuation: " + punctuation);

    }

}
