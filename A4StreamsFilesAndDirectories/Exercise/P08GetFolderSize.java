package A4StreamsFilesAndDirectories.Exercise;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {

        String folderPath = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(folderPath);

        File[] allFilesInFolder = folder.listFiles();

        int folderSize = 0;

        assert allFilesInFolder != null;
        for (File file : allFilesInFolder) {
            folderSize+= file.length();
        }

        System.out.println("Folder size: "+ folderSize);
    }
}
