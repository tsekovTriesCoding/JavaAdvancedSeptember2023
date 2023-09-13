package A6DefiningClasses.Lab.P03BankAccount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccountsMap = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Create":
                    BankAccount acc = new BankAccount();
                    bankAccountsMap.put(acc.getId(), acc);
                    System.out.printf("Account ID%d created\n", acc.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Integer.parseInt(tokens[2]);

                    if (bankAccountsMap.containsKey(id)) {
                        bankAccountsMap.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d\n", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double newInterestRate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newInterestRate);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (bankAccountsMap.containsKey(id)) {
                        System.out.printf("%.2f\n", bankAccountsMap.get(id).getInterestRate(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
