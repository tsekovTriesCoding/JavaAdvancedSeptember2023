package A6DefiningClasses.Exercise.P08FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthdate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

}
