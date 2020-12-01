package src;

public class Account {
    private static int counter;// keeps count on how many account has been created
    private int accountNumber;
    private double balance;
    private String accountType;
    private double interestRate;

    public Account(String accountType, double interestRate) { // constructor
        counter++; // each time a new account is created, we plus 1 to the counter
        this.accountNumber = counter; // use the counter to get a unique account number
        this.accountType = accountType;
        this.interestRate = interestRate;


    }

    public static int getCounter() {
        return counter;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
