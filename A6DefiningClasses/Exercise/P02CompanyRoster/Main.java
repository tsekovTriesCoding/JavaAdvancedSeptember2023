package A6DefiningClasses.Exercise.P02CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = null;
            // при подадени всички параметри:
            if(tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 5) {
                //5 параметъра - без имейл или възраст:
                String fourthVariable = tokens[4];
                if(fourthVariable.contains("@")) {
                    String email = fourthVariable;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(fourthVariable);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else {
                // при 4 параметъра - без имейл и възраст:
                employee = new Employee(name, salary, position, department);
            }

            if(!departments.containsKey(department)) {
                departments.put(department, new Department(department));
            }

            //добавяне на служителя в списъка със служителите на отдела:
            departments.get(department).getEmployees().add(employee);

        }

        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
        }
    }

