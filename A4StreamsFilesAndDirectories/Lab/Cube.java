package A4StreamsFilesAndDirectories.Lab;

import java.io.Serializable;

public class Cube implements Serializable {
    private String color;
    private double width;
    private double length;
    private double height;

    public Cube(String color, double width, double length, double height) {
        this.color = color;
        this.width = width;
        this.length = length;
        this.height = height;
    }
}
