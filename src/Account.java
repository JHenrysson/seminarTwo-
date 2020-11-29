package src;

public class Account {
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public static int getCounter() {
        return counter;
    }

    private int accountNumber;
     private double balance;
     private String accountType;
     private double interestRate;
     private static int counter;
     public Account (String accountType, double interestRate){ // constructor
         counter ++;
         this.accountNumber = counter;
         this.accountType = accountType;
         this.interestRate = interestRate;


     }
}
