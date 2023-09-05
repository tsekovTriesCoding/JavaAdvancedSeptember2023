package A3SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P13DragonArmy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, TreeMap<String, int[]>> dragonsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String name = tokens[1];
            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            addNewDragonType(dragonsMap, type);
            addNewDragon(dragonsMap, type, name);
            addStats(dragonsMap, type, name, damage, health, armor);

        }

        for (Map.Entry<String, TreeMap<String, int[]>> dragonType : dragonsMap.entrySet()) {
            double[] avgStats = getAvgStats(dragonType.getValue());

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", dragonType.getKey(), avgStats[0], avgStats[1], avgStats[2]);

            dragonType.getValue().forEach((name, stats) -> {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", name, stats[0], stats[1], stats[2]);
            });
        }
    }

    private static double[] getAvgStats(TreeMap<String, int[]> dragons) {
        int dragonsCount = dragons.size();
        double totalDamage = 0;
        double totalHealth = 0;
        double totalArmor = 0;

        for (Map.Entry<String, int[]> type : dragons.entrySet()) {
            totalDamage += type.getValue()[0];
            totalHealth += type.getValue()[1];
            totalArmor += type.getValue()[2];
        }
        return new double[]{totalDamage / dragonsCount,
                totalHealth / dragonsCount,
                totalArmor / dragonsCount
        };
    }

    private static void addStats(Map<String, TreeMap<String, int[]>> dragonsMap, String type, String name, int damage, int health, int armor) {
        dragonsMap.get(type).get(name)[0] = damage;
        dragonsMap.get(type).get(name)[1] = health;
        dragonsMap.get(type).get(name)[2] = armor;
    }

    private static void addNewDragon(Map<String, TreeMap<String, int[]>> dragonsMap, String type, String name) {
        if (!dragonsMap.get(type).containsKey(name)) {
            dragonsMap.get(type).put(name, new int[3]);
        }
    }

    private static void addNewDragonType(Map<String, TreeMap<String, int[]>> dragonsMap, String type) {
        if (!dragonsMap.containsKey(type)) {
            dragonsMap.put(type, new TreeMap<>());
        }
    }
}
