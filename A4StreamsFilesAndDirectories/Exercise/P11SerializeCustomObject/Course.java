package A4StreamsFilesAndDirectories.Exercise.P11SerializeCustomObject;

import java.io.Serializable;

public class Course implements Serializable {

     private String name;

     private int numberOfStudents;

    public Course(String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }
}
