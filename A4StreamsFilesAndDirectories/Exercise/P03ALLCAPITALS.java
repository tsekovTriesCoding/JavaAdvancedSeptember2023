package A4StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.file.Path;

public class P03ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathToWrite = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(Path.of(pathToWrite).toFile()));

        // 1 начин:
        /*List<String> allLines = Files.readAllLines(Path.of(filePath));
        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();*/

        // 2 начин:
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }

        writer.close();
    }
}
