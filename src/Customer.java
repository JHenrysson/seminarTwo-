package src;

import java.util.ArrayList;

public class Customer {

    ArrayList<Account> accounts = new ArrayList<>(); // Create an ArrayList account
    int idNumber;
    String name;

    public Customer (String name, int idNumber ){
         this.name = name;
         this.idNumber = idNumber;

    }


}
