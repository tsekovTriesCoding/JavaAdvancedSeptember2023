package A4StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {

    public static void main(String[] args) throws IOException {
        String readPath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream outputStream = new FileOutputStream(writePath);

        int currentByte = inputStream.read();

        while (currentByte >= 0) {
            String digits = String.valueOf(currentByte);

            if (digits.equals("32")) {
                outputStream.write(" ".getBytes());
            } else if (digits.equals("10")) {
                outputStream.write("\n".getBytes());
            } else {
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            }

            currentByte = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
