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

        //if inputCustomerId




        System.out.println("1.Create a saving account for the customer");
        System.out.println("2.Create a credit account for the customer");
        System.out.println("3.View all accounts");
        System.out.println("4.Deposit money ");
        System.out.println("5.Withdraw money");


    }
}
