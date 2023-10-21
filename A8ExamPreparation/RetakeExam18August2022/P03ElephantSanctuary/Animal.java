package A8ExamPreparation.RetakeExam18August2022.P03ElephantSanctuary;

public class Animal {
    private String name;
    private int age;
    private String caretaker;

    public Animal(String name, int age, String caretaker) {
        this.name = name;
        this.age = age;
        this.caretaker = caretaker;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", this.name, this.age, this.caretaker);
    }

    public String getName() {
        return name;
    }

    public String getCaretaker() {
        return caretaker;
    }

    public int getAge() {
        return age;
    }
}
