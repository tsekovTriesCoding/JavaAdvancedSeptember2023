package A3SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P11LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> items = new LinkedHashMap<>();

        items.put("shards", "Shadowmourne");
        items.put("fragments", "Valanyr");
        items.put("motes", "Dragonwrath");

        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkItems = new TreeMap<>();

        boolean legendaryObtained = false;
        String legendaryItem = "";
        while (!legendaryObtained) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int i = 0; i < input.length - 1; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String item = input[i + 1].toLowerCase();

                switch (item) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        keyMaterials.put(item, keyMaterials.get(item) + quantity);
                        break;
                    default:
                        if (!junkItems.containsKey(item)) {
                            junkItems.put(item, quantity);
                        } else {
                            junkItems.put(item, junkItems.get(item) + quantity);
                        }
                        break;
                }

                if ((item.equals("shards") || item.equals("fragments") || item.equals("motes")) && keyMaterials.get(item) >= 250) {
                    legendaryObtained = true;
                    keyMaterials.put(item, keyMaterials.get(item) - 250);
                    legendaryItem = items.get(item);
                    break;
                }
            }
        }

        System.out.printf("%s obtained!%n", legendaryItem);

//        keyMaterials.entrySet()
//        .stream()
//        .sorted((e1, e2) -> {
//            int res = e2.getValue().compareTo(e1.getValue());
//            if (res == 0) res = e1.getKey().compareTo(e2.getKey());
//            return res;
//        }).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        keyMaterials.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        junkItems.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }
}
