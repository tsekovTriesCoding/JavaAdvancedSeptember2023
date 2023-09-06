package A4StreamsFilesAndDirectories.Lab;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (folder.exists()) {

            if (folder.isDirectory()) {
                File[] allFiles = folder.listFiles();

                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%d]%n", file.getName(), file.length());
                    }
                }
            }
        }

    }
}
