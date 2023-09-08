package A4StreamsFilesAndDirectories.Exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyAPicture {
    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream("C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\kiwi.png");
        FileOutputStream out = new FileOutputStream("C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.png");

        int currentByte = in.read();

        while (currentByte >= 0) {

            out.write(currentByte);

            currentByte = in.read();
        }

        in.close();
        out.close();

    }
}
