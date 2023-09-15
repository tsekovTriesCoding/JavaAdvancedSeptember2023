package A6DefiningClasses.Exercise.P07Google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.department).append(" ")
                .append(String.format("%.2f",this.salary)).append(System.lineSeparator());

        return sb.toString();
    }
}
