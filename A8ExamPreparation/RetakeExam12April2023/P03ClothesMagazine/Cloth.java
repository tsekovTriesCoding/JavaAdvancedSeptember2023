package A8ExamPreparation.RetakeExam12April2023.P03ClothesMagazine;

public class Cloth {
    private String color;
    private int size;
    private String type;

    public Cloth(String color, int size, String type) {
        this.color = color;
        this.size = size;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("Product: %s with size %d, color %s",this.type, this.size, this.color);
    }
}
