package A2MultidimentisionalArrays.Exercise;

import java.util.Scanner;

public class P08TheHeiganDance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double d = Double.parseDouble(scanner.nextLine());

        int playerRow = 7;
        int playerCol = 7;
        double playerHp = 18500;
        double heiganHp = 3000000;
        boolean activeCloud = false;
        String lastSpell = "";

        while (true) {
            if (playerHp >= 0) {
                heiganHp -= d;
            }
            if (activeCloud) {
                playerHp -= 3500;
                activeCloud = false;
            }
            if (heiganHp <= 0 || playerHp <= 0) {
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int attackRow = Integer.parseInt(tokens[1]);
            int attackCol = Integer.parseInt(tokens[2]);


            switch (spell) {
                case "Cloud":
                    int spellDamage = 3500;

                    if (isInAreaOfDamage(attackRow, attackCol, playerRow, playerCol)) {
                        if (!isInAreaOfDamage(attackRow, attackCol, playerRow - 1, playerCol)
                                && (playerRow - 1 >= 0 && playerRow - 1 < 15)) {
                            playerRow--;
                        } else if (!isInAreaOfDamage(attackRow, attackCol, playerRow, playerCol + 1)
                                && (playerCol + 1 >= 0 && playerCol + 1 < 15)) {
                            playerCol++;
                        } else if (!isInAreaOfDamage(attackRow, attackCol, playerRow + 1, playerCol)
                                && (playerRow + 1 >= 0 && playerRow + 1 < 15)) {
                            playerRow++;
                        } else if (!isInAreaOfDamage(attackRow, attackCol, playerRow, playerCol - 1)
                                && (playerCol - 1 >= 0 && playerCol - 1 < 15)) {
                            playerCol--;
                        } else {
                            playerHp -= spellDamage;
                            activeCloud = true;
                            lastSpell = spell;
                        }
                    }

                    break;
                case "Eruption":
                    spellDamage = 6000;

                    if (isInAreaOfDamage(attackRow, attackCol, playerRow, playerCol)) {
                        if (!isInAreaOfDamage(attackRow, attackCol, playerRow - 1, playerCol)
                                && (playerRow - 1 >= 0 && playerRow - 1 < 15)) {
                            playerRow--;
                        } else if (!isInAreaOfDamage(attackRow, attackCol, playerRow, playerCol + 1)
                                && (playerCol + 1 >= 0 && playerCol + 1 < 15)) {
                            playerCol++;
                        } else if (!isInAreaOfDamage(attackRow, attackCol, playerRow + 1, playerCol)
                                && (playerRow + 1 >= 0 && playerRow + 1 < 15 )) {
                            playerRow++;
                        } else if (!isInAreaOfDamage(attackRow, attackCol, playerRow, playerCol - 1)
                                && (playerCol - 1 >= 0 && playerCol -1 < 15)) {
                            playerCol--;
                        } else {
                            playerHp -= spellDamage;
                            lastSpell = spell;
                        }
                    }
                    break;
            }

        }
        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        boolean heiganIsDead = heiganHp <= 0;
        boolean playerIsDead = playerHp <= 0;
        if (heiganIsDead) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHp);
        }

        if (playerIsDead) {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %.0f%n", playerHp);
        }

        System.out.printf("Final position: %d, %d", playerRow, playerCol);


    }

    private static boolean isInAreaOfDamage(int attackRow, int attackCol, int playerRow, int playerCol) {

        return ((attackRow - 1 <= playerRow && attackRow + 1 >= playerRow)
                && (attackCol - 1 <= playerCol && attackCol + 1 >= playerCol));
    }

}
