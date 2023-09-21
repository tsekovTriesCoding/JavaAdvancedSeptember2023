package A6DefiningClasses.Exercise.P08FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String personToFindInfoAbout = scanner.nextLine();
        String input = scanner.nextLine();
        LinkedHashMap<String, List<String>> childrenByParents = new LinkedHashMap<>();
        List<Person> peopleList = new ArrayList<>();
        Set<String> inputSet = new LinkedHashSet<>();

        while (!input.equals("End")) {
            if (input.contains("-")) {
                String[] tokens = input.split(" - ");
                String parentData = tokens[0];
                String childData = tokens[1];

                childrenByParents.putIfAbsent(parentData, new ArrayList<>());
                childrenByParents.get(parentData).add(childData);
                inputSet.add(parentData);
                inputSet.add(childData);
            } else {
                String personFirstName = input.split("\\s+")[0];
                String personLastName = input.split("\\s+")[1];
                String personBirthdate = input.split("\\s+")[2];
                String fullName = personFirstName + " " + personLastName;

                Person person = new Person(fullName, personBirthdate);
                peopleList.add(person);
            }

            input = scanner.nextLine();
        }

        for (String inputInfo : inputSet) {
            Person currentPerson = getPersonInfo(inputInfo, peopleList);

            for (Map.Entry<String, List<String>> entry : childrenByParents.entrySet()) {
                Person parent = getPersonInfo(entry.getKey(), peopleList);

                for (String childInfo : entry.getValue()) {
                    Person child = getPersonInfo(childInfo, peopleList);

                    if (currentPerson == child) {
                        currentPerson.addToParentList(parent);
                    } else if (currentPerson == parent) {
                        currentPerson.addToChildrenList(child);
                    }
                }
            }

        }

        System.out.println(getPersonInfo(personToFindInfoAbout, peopleList).toString());
    }

    private static Person getPersonInfo(String info, List<Person> personList) {
        Person currentPerson = null;
        for (Person person : personList) {
            if (person.getName().equals(info) || person.getBirthdate().equals(info)) {
                currentPerson = person;
            }
        }
        return currentPerson;
    }
}
