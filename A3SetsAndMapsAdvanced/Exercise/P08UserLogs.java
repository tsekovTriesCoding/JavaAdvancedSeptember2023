package A3SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P08UserLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> usernameLog = new TreeMap<>();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");

            String ip = tokens[0].split("=")[1];
            String username = tokens[2].split("=")[1];

            if (!usernameLog.containsKey(username)) {
                usernameLog.put(username, new LinkedHashMap<>());

                if (!usernameLog.get(username).containsKey(ip)) {
                    usernameLog.get(username).put(ip, 1);
                } else {
                    usernameLog.get(username).put(ip, usernameLog.get(username).get(ip) + 1);
                }
            } else {
                if (!usernameLog.get(username).containsKey(ip)) {
                    usernameLog.get(username).put(ip, 1);
                } else {
                    usernameLog.get(username).put(ip, usernameLog.get(username).get(ip) + 1);
                }
            }

            input = scanner.nextLine();
        }

        usernameLog.forEach((k, v) -> {
            System.out.println(k + ": ");

            int size = v.size();
            for (Map.Entry<String, Integer> entry : v.entrySet()) {
                if (size > 1) {
                    System.out.printf("%s => %d, ", entry.getKey(), entry.getValue());
                    size--;
                } else {
                    System.out.printf("%s => %d.%n", entry.getKey(), entry.getValue());
                }
            }
        });
    }
}
