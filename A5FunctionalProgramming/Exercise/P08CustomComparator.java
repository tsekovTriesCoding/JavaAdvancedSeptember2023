package A5FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> comparator = ((num1, num2) -> {
            //първо четно, второ нечетно -> не разменяме
            if (num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;
            }
            //първо нечетно, второ четно -> размяна
            else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;
            } else {
                //първо четно, второто четно или първo нечетно, второто нечетно :
                return num1.compareTo(num2);
                //num1 == num2 -> 0 -> няма размяна
                //num1 < num2 -> -1 -> няма размяна
                //num1 > num2 -> 1 -> има размяна
            }

        });

        numbers.stream().sorted(comparator).forEach(number -> System.out.print(number + " "));

        //1 2 3 4 5 6
        //1 и 2 -> comparator 1 -> sorted(1) -> размяна -> 2 1 3 4 5 6
        //1 и 3 -> comparator -1 -> sorted(-1) -> няма размяна ->  2 1 3 4 5 6
        //3 и 4 -> comparator 1 -> sorted (1) -> размяна -> 2 1 4 3 5 6
        //5 и 6 -> comparator 1 -> sorted (1) -> размяна -> 2 1 4 3 6 5 и т.н.
    }
}
