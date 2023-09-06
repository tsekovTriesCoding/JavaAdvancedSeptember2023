package A4StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int currentByte = inputStream.read();

        while (currentByte >= 0) {
            System.out.print(Integer.toBinaryString(currentByte) + " ");
            currentByte = inputStream.read();
        }

        inputStream.close();

    }
}
