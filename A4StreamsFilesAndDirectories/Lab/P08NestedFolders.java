package A4StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;

public class P08NestedFolders {

    public static void main(String[] args) {
        File root = new File("C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int folderCount = 1;
        while (!dirs.isEmpty()) {
            File file = dirs.poll();

            if (file.isDirectory()) {
                System.out.println(file.getName());
            }
            File[] nestedFiles = file.listFiles();

            assert nestedFiles != null;
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                    folderCount++;
                }

            }

        }

        System.out.println(folderCount + " folders");
    }
}
