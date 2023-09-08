package A4StreamsFilesAndDirectories.Exercise.P11SerializeCustomObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class P11SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Course course = new Course("Maths", 20);

        String path = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\Exercise\\P11SerializeCustomObject\\course.ser";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(course);
        oos.close();
    }
}
