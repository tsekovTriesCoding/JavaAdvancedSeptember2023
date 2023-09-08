package A4StreamsFilesAndDirectories.Exercise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class P10SerializeArrayList {
    public static void main(String[] args) throws IOException {

        ArrayList<Double> array = new ArrayList<>();
        String path = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\P10.ser";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(array);
        oos.close();

    }
}
