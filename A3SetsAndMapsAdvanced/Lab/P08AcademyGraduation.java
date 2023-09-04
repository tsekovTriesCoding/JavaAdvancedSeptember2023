package A3SetsAndMapsAdvanced.Lab;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P08AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> avgGradeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            avgGradeMap.putIfAbsent(name, new ArrayList<>());
            avgGradeMap.put(name, grades);
        }

        avgGradeMap.forEach((k, v) -> {
             double avgGrade = 0;

            for (Double grade : v) {
                avgGrade += grade;
            }
            avgGrade /= v.size();

            System.out.printf("%s is graduated with %s%n", k, avgGrade);
        });
    }
}
