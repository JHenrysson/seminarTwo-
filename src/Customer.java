package src;

import java.util.ArrayList;

public class Customer {

    private ArrayList<Account> accounts = new ArrayList<>(); // Create an ArrayList account
    private int idNumber;
    private String name;

    public Customer (String name, int idNumber ){
         this.name = name;
         this.idNumber = idNumber;

    }
    public int getidNumber(){
        return idNumber;
    }
    public ArrayList<Account> getaccounts(){
        return accounts;
    }


}
