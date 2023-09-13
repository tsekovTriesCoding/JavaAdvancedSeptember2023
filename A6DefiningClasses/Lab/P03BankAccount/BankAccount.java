package A6DefiningClasses.Lab.P03BankAccount;

public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCounter = 1;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = bankAccountCounter++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public int getId() {
        return id;
    }
}
