package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankLogic {

    ArrayList<Customer> customers = new ArrayList<>(); // Create an ArrayList object


    void startUp() { // start up method here without a return type
        Customer customer1 = new Customer("Joe", 12345); //creating an object
        Customer customer2 = new Customer("Daniel", 54321); //creating an object
        Customer customer3 = new Customer("Joe", 12121); //creating an object

        customers.add(customer1);// adding the object to arraylist
        customers.add(customer2);
        customers.add(customer3);


        System.out.println("Please enter a customer ID (five digit)");
        Scanner scanner = new Scanner(System.in);
        int inputCustomerId = 0; // set it to 0 to have something compare to

        while (inputCustomerId <= 0) {
            try {
                inputCustomerId = Integer.parseInt(scanner.next());
                if (inputCustomerId <= 0){
                    System.out.println("Not a valid ID");
                }
            } catch (NumberFormatException e) { // the input is not a valid number
                System.out.println("Not a number");
            }
        }
        Customer loggedInCustomer = null; // to later check if it was valid

        for (Customer customer : customers) { // looping throuhgh all the customers in arraylist
            if (inputCustomerId == customer.getidNumber()) {
                loggedInCustomer = customer; // if there is a match --this holds the customer it has matched with --> so we know who is logged in
                break;
            }
        }
        if (loggedInCustomer == null) {
            System.out.println("Customer not found");
        } else {
            boolean status = true; // the check for the while loop ---
            while (status) {
                System.out.println("1.Create a saving account for the customer");
                System.out.println("2.Create a credit account for the customer");
                System.out.println("3.View all accounts");
                System.out.println("4.Deposit money ");
                System.out.println("5.Withdraw money");
                System.out.println("6.Exit");
                System.out.println("Please enter a choice: ");

                int customerMenuInput;
                try{
                    customerMenuInput = Integer.parseInt(scanner.next());
                }catch (NumberFormatException e){
                    customerMenuInput = 0;
                }
                switch (customerMenuInput) { // instead of using if, else if, else
                    case 1:
                        new SavingAccount();// creates a new instance of saving account
                        loggedInCustomer.getaccounts().add(new SavingAccount());// adds the newly created account to that customer
                        break;
                    case 2:
                        loggedInCustomer.getaccounts().add(new CreditAccount());// adds the newly created account to that customer
                        break;
                    case 3:
                        for (Account account : loggedInCustomer.getaccounts()) {//getting the list of accounts for that customer
                            System.out.println("Your account(s):" + account.getAccountType()); // because account type is private use a getter to get valuese
                            System.out.println("Your Balance: " + account.getBalance());
                            System.out.println("Your account Number: " + account.getAccountNumber());
                        }
                        break;
                    case 4:
                        deposit(scanner, loggedInCustomer);
                        break;
                    case 5:
                        withdrawal(scanner, loggedInCustomer);
                        break;
                    case 6:
                        status = false;
                        break;
                    default: System.out.println("Not a valid menu item"); // if something other than menu is inserted
                    break;
                }
            }

        }
    }

    private void withdrawal(Scanner scanner, Customer loggedInCustomer) { // this is the withdrawl method
        System.out.println("Enter an account number");
        int accountNumberInput2 = 0; // to have a value to compare to
        try {
            accountNumberInput2 = Integer.parseInt(scanner.next());
        }catch(NumberFormatException e){
            System.out.println("Not a valid account number");
        }
        for (Account account : loggedInCustomer.getaccounts()) { // loops through accts for cust
            if (accountNumberInput2 == account.getAccountNumber()) { // if the input and accNum are the same you have the option to withdraw
                System.out.println("Enter a withdrawal amount: ");
                try{
                    int withdrawalAmount = Integer.parseInt(scanner.next());

                if (account.getBalance() - withdrawalAmount < 0) { // withdrawal amount cannot be less than 0
                    System.out.println("Sorry try again");
                } else {
                    account.setBalance(account.getBalance() - withdrawalAmount);
                    System.out.println("New Balance: " + account.getBalance());
                }
                }catch (NumberFormatException e){
                    System.out.println("Sorry not a valid number");//
                }
            }
        }
    }

    private void deposit(Scanner scanner, Customer loggedInCustomer) { // the deposit method
        System.out.println("Enter an account number");
        int accountNumberInput = 0;// need value to compare to
        try {
            accountNumberInput = Integer.parseInt(scanner.next()); // taking input making sure its an int
        }catch (NumberFormatException e){
            System.out.println("Not a valid account number");
        }
        for (Account account : loggedInCustomer.getaccounts()) { // loops through accounts of logged in cust
            if (accountNumberInput == account.getAccountNumber()) {
                System.out.println("Enter a deposit amount: ");
                try {
                    int depositAmount = Integer.parseInt(scanner.next());
                    account.setBalance(account.getBalance() + depositAmount);
                    System.out.println("Your new balance: " + account.getBalance());
                }catch (NumberFormatException e){
                    System.out.println("Not a valid amount");
                }
            }

        }
    }

}



