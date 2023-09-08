package A4StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P01SumLines {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(filePath));

        // 1 начин:
//        for (String line : allLines) {
//            int sum = 0;
//
//            for (char symbol : line.toCharArray()) {
//                sum += symbol;
//            }
//
//            System.out.println(sum);
//        }

        // 2 начин:
//        allLines.forEach(line -> {
//            int sum =0;
//            for (char symbol : line.toCharArray()) {
//                sum += symbol;
//            }
//            System.out.println(sum);
//        });

        // 3 начин:
        allLines.stream()
                .map(line -> line.toCharArray())
                .forEach(arr -> {
                    int sum = 0;
                    for (char symbol : arr) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });
    }
}
