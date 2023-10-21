package A8ExamPreparation.RetakeExam14April2021.P03University;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < this.capacity) {
            boolean isInside = false;
            for (Student stud : this.students) {
                if (stud.getFirstName().equals(student.getFirstName())
                        && stud.getLastName().equals(student.getLastName())) {
                    isInside = true;
                    break;
                }
            }
            if (!isInside) {
                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the university";
            }

        }

        return "No seats in the university";
    }

    public String dismissStudent(Student student) {
        boolean isInside = false;
        for (Student stud : this.students) {
            if (student.getFirstName().equals(stud.getFirstName())
                    && student.getLastName().equals(stud.getLastName())) {
                isInside = true;
                break;
            }
        }

        if (isInside) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }

    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }

        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        this.students.forEach(s -> sb.append(String.format("==Student: First Name = %s, " +
                        "Last Name = %s, Best Subject = %s", s.getFirstName(), s.getLastName(), s.getBestSubject()))
                .append(System.lineSeparator()));

        return sb.toString();
    }

}
