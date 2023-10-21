package A8ExamPreparation.RetakeExam18August2022.P03ElephantSanctuary;

public class Elephant {
    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        this.name = name;
        this.age = age;
        this.retiredFrom = retiredFrom;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s", this.name, this.age, this.retiredFrom);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRetiredFrom() {
        return retiredFrom;
    }
}
