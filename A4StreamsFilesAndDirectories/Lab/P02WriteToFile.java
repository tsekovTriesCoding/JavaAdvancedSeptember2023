package A4StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P02WriteToFile {

    public static void main(String[] args) throws IOException {
        String readPath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream outputStream = new FileOutputStream(writePath);

        int currentByte = inputStream.read();

        while (currentByte >= 0) {
            char currentSymbol = (char) currentByte;

            if (currentSymbol != '.' && currentSymbol != ',' && currentSymbol != '!' && currentSymbol != '?') {
                outputStream.write(currentSymbol);
            }

            currentByte = inputStream.read();
        }

        inputStream.close();
        outputStream.close();

    }
}
