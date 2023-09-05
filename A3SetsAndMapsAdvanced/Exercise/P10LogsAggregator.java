package A3SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P10LogsAggregator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Set<String>> ipMap = new TreeMap<>();
        Map<String, Integer> durationMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String[] tokens = input.split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if (!ipMap.containsKey(user)) {
                ipMap.put(user, new TreeSet<>());
                ipMap.get(user).add(ip);
            } else {
                ipMap.get(user).add(ip);
            }

            if (!durationMap.containsKey(user)) {
                durationMap.put(user, duration);
            } else {
                durationMap.put(user, durationMap.get(user) + duration);
            }
        }

        durationMap.forEach((k, v) -> {
            System.out.printf("%s: %d ", k, v);
            System.out.println(ipMap.get(k));
        });
    }
}
