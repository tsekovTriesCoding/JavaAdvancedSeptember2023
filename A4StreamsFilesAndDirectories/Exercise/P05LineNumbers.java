package A4StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException  {

        String filePath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(filePath));

        String newFilePath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\outputLineNumbers.txt";
        File file = new File(newFilePath);
        PrintWriter writer = new PrintWriter(file);

        int lineCount = 1;
        for (String line : allLines) {
            writer.println(lineCount + ". " + line);
            lineCount++;
        }

        writer.close();
    }
}
