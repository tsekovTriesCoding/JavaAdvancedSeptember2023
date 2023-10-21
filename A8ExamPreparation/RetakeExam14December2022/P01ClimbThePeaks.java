package A8ExamPreparation.RetakeExam14December2022;

import java.util.*;

public class P01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> dailyPortions = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(dailyPortions::push);

        ArrayDeque<Integer> dailyStamina = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(dailyStamina::offer);

        Map<String, Integer> peaks = new LinkedHashMap<>();
        peaks.put("Vihren", 80);
        peaks.put("Kutelo", 90);
        peaks.put("Banski Suhodol", 100);
        peaks.put("Polezhan", 60);
        peaks.put("Kamenitza", 70);

        ArrayDeque<String> peaksToClimb = new ArrayDeque<>();
        peaksToClimb.offer("Vihren");
        peaksToClimb.offer("Kutelo");
        peaksToClimb.offer("Banski Suhodol");
        peaksToClimb.offer("Polezhan");
        peaksToClimb.offer("Kamenitza");

        List<String> climbedPeaks = new ArrayList<>();
        while (!dailyPortions.isEmpty() && !dailyStamina.isEmpty() && !peaksToClimb.isEmpty()) {
            int sum = dailyPortions.pop() + dailyStamina.poll();

            String currentPeak = peaksToClimb.peek();
            if (sum >= peaks.get(currentPeak)) {
                peaksToClimb.poll();
                climbedPeaks.add(currentPeak);
            }
        }

        if (peaksToClimb.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (climbedPeaks.size() > 0) {
            System.out.println("Conquered peaks:");
            climbedPeaks.forEach(System.out::println);
        }

    }
}
