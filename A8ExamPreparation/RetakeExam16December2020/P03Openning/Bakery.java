package A8ExamPreparation.RetakeExam16December2020.P03Openning;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }

        return false;
    }

    public Employee getOldestEmployee() {
        Employee employee = null;

        int age = 0;

        for (Employee emp : this.employees) {
            if (emp.getAge() > age) {
                age = emp.getAge();
                employee = emp;
            }
        }

        return employee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }

        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery " + this.name + ":").append(System.lineSeparator());
        this.employees.forEach(e -> sb.append(e).append(System.lineSeparator()));

        return sb.toString();
    }
}
