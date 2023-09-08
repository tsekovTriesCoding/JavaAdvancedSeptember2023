package A4StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        // 1 начин:
      /*  List<String> allLines = Files.readAllLines(Path.of(filePath));
        long sum = 0;
        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }

        System.out.println(sum);*/

        // 2 начин:

        byte[] allBytes = Files.readAllBytes(Path.of(filePath));

        long sum = 0;
        for (byte asciiCode : allBytes) {
            if (asciiCode != 10 && asciiCode != 13) {
                sum += asciiCode;
            }
        }

        System.out.println(sum);

    }
}
