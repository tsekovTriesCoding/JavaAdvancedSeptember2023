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

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }


    public void addToParentList(Person person) {
        if (isNew(person, parents)) {
            this.parents.add(person);
        }
    }

    public void addToChildrenList(Person person) {
        if (isNew(person, children)) {
            this.children.add(person);
        }
    }

    public boolean isNew(Person person, List<Person> personList) {
        for (Person p : personList) {
            if (p.equals(person)) {
                return false;
            }
        }
        return true;
    }

    public String getOutputForList(List<Person> list) {
        StringBuilder output = new StringBuilder();

        if (!list.isEmpty()) {
            for (Person p : list) {
                output.append(String.format("%s %s%n", p.getName(), p.getBirthdate()));
            }
        }
        return output.toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s%nParents:%n%sChildren:%n%s", name, String.join("/", this.birthdate), getOutputForList(parents), getOutputForList(children));
    }
}
