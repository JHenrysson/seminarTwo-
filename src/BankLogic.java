package src;

import java.util.ArrayList;
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

        System.out.println("Please enter a customer ID");

        Scanner scanner = new Scanner(System.in);
        int inputCustomerId = scanner.nextInt();
        Customer loggedInCustomer = null;
        //if inputCustomerId

        for (Customer customer : customers) {
            if (inputCustomerId == customer.getidNumber()) {
                loggedInCustomer = customer; // this holds the customer it has matched with
                break;
            }
        }
        if (loggedInCustomer == null) {
            System.out.println("Customer not found");
        } else {
            boolean status = true;
            while (status) {
                System.out.println("1.Create a saving account for the customer");
                System.out.println("2.Create a credit account for the customer");
                System.out.println("3.View all accounts");
                System.out.println("4.Deposit money ");
                System.out.println("5.Withdraw money");
                System.out.println("6.Exit");
                System.out.println("Please enter a choice: ");

                int customerMenuInput = scanner.nextInt();

                switch (customerMenuInput) {
                    case 1:
                        new SavingAccount();
                        loggedInCustomer.getaccounts().add(new SavingAccount());
                        break;
                    case 2:
                        loggedInCustomer.getaccounts().add(new CreditAccount());
                        break;
                    case 3:
                        for (Account account : loggedInCustomer.getaccounts()) {//getting the list of accounts for that customer
                            System.out.println("Your account(s):" + account.getAccountType());
                            System.out.println("Your Balance: " + account.getBalance());
                            System.out.println("Your account Number: " + account.getAccountNumber());

                        }
                        break;
                    case 4:
                        System.out.println("Enter an account number");
                        int accountNumberInput = scanner.nextInt();
                        for (Account account : loggedInCustomer.getaccounts()) {
                            if (accountNumberInput == account.getAccountNumber()) {
                                System.out.println("Enter a deposit amount: ");
                                int depositAmount = scanner.nextInt();
                                 account.setBalance(account.getBalance() + depositAmount);
                                System.out.println("Your new balance: " + account.getBalance());
                            }


                        }
                        break;
                    case 5:
                        System.out.println("Enter an account number");
                        int accountNumberInput2 = scanner.nextInt();
                        for (Account account : loggedInCustomer.getaccounts()) {
                            if (accountNumberInput2 == account.getAccountNumber()) {
                                System.out.println("Enter a withdrawal amount: ");
                                int withdrawalAmount = scanner.nextInt();
                                if (account.getBalance() - withdrawalAmount < 0) {
                                    System.out.println("Sorry try again");
                                } else {
                                    account.setBalance(account.getBalance()- withdrawalAmount);
                                    System.out.println("New Balance: " + account.getBalance());
                                }
                            }
                        }
                        break;
                    case 6:
                        status = false;
                        break;
                }
            }

        }
    }

}



