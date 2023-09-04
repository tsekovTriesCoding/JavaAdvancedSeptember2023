package A3SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P05AverageStudentsGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String studentName = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsGrades.putIfAbsent(studentName, new ArrayList<>());
            studentsGrades.get(studentName).add(grade);
        }

        studentsGrades.entrySet().forEach(entry -> {
            System.out.printf("%s -> ", entry.getKey());
            double totalGrade = 0;
            for (Double grade : entry.getValue()) {
                System.out.printf("%.2f ", grade);
                totalGrade += grade;
            }
            System.out.printf("(avg: %.2f)%n", totalGrade / entry.getValue().size());
        });


    }
}
