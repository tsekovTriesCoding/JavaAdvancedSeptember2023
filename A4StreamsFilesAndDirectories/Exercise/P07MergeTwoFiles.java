package A4StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.file.Path;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String firstPath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondPath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\P07output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(Path.of(outputPath).toFile()));

        BufferedReader reader = new BufferedReader(new FileReader(firstPath));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }

        reader = new BufferedReader(new FileReader(secondPath));
        line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }

        writer.close();

    }
}
