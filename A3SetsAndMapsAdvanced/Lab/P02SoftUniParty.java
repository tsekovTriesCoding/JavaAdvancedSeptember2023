package A3SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guestInvited = scanner.nextLine();

        Set<String> guests = new TreeSet<>();
        while (!guestInvited.equals("PARTY")) {
            guests.add(guestInvited);

            guestInvited = scanner.nextLine();
        }

        String guest = scanner.nextLine();

        while (!guest.equals("END")) {
            guests.remove(guest);

            guest = scanner.nextLine();
        }

        System.out.println(guests.size());

        for (String s : guests) {
            System.out.println(s);
        }
    }
}
