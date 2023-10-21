package A8ExamPreparation.RetakeExam14December2022.SoftUnisStudents;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        String firstName = student.getFirstName();
        String lastName = student.getLastName();

        if (this.data.size() < capacity) {
            for (Student stud : this.data) {
                if (stud.getFirstName().equals(firstName) && stud.getLastName().equals(lastName)) {
                    return "Student is already in the hall.";
                }
            }
            this.data.add(student);
            return String.format("Added student %s %s.", firstName, lastName);
        } else {
            return "The hall is full.";
        }
    }

    public String remove(Student student) {
        String firstName = student.getFirstName();
        String lastName = student.getLastName();

        for (Student stud : this.data) {
            if (stud.getFirstName().equals(firstName) && stud.getLastName().equals(lastName)) {
                this.data.remove(student);
                return String.format("Removed student %s %s.", firstName, lastName);
            }
        }
        return "Student not found.";

    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }

        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("Hall size: ").append(this.data.size()).append(System.lineSeparator());
        this.data.forEach(student -> sb.append(String.format("Student: %s %s, Best Course = %s"
                , student.getFirstName(), student.getLastName(), student.getBestCourse())).append(System.lineSeparator()));

        return sb.toString();
    }
}
