package A4StreamsFilesAndDirectories.Exercise.P12CreateZipArchive;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) throws IOException {

        String file1 = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String file2 = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String file3 = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";

        String zipFilename = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\P12CreateZipArchive\\p12.zip";
        File zipFile = new File(zipFilename);
        FileOutputStream fos  = new FileOutputStream(zipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);
        zipFile(file1, zos);
        zipFile(file2, zos);
        zipFile(file3,zos);
        zos.close();
    }

    private static void zipFile(String fileName, ZipOutputStream zos) throws IOException
    {
        final int BUFFER = 1024;
        BufferedInputStream bis = null;
        try
        {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis, BUFFER);

            // ZipEntry --- Here file name can be created using the source file
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);
            byte[] data = new byte[BUFFER];
            int count;
            while((count = bis.read(data, 0, BUFFER)) != -1)
            {
                zos.write(data, 0, count);
            }
            // close entry every time
            zos.closeEntry();
        }
        finally
        {
            try
            {
                assert bis != null;
                bis.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
