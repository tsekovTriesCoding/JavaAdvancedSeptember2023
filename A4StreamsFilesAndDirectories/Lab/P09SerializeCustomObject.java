package A4StreamsFilesAndDirectories.Lab;

import java.io.*;

public class P09SerializeCustomObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube= new Cube("green", 15.3, 12.4, 3);

        String path = "C:\\Users\\ktsek\\Softuni\\Projects\\JavaAdvanced\\src\\A4StreamsFilesAndDirectories\\cubeInfo.ser";

        //записваме обект във файл (сериализация):
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(cube);
        oos.close();

        //прочитане на обект от файл (десериализация):
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Cube cubeNew = (Cube)ois.readObject();

    }

}
