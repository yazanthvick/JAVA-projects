package BANKSYSTEM;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    private String customerName;
    private int customerID;
    private Address customerAddress;
    private ArrayList<Account> customerAccounts;


    private Customer(){

    }

    public Customer(int customerID, String customerName){
        setCustomerID(customerID);
        setCustomerName(customerName);
        setCustomerAccounts();
    }

    public Customer(String customerName, int customerID, Address customerAddress){
        setCustomerName(customerName);
        setCustomerID(customerID);
        setCustomerAddress(customerAddress);
        setCustomerAccounts();

    }

    public Customer(int customerID, String customerName, int streetNumber, String streetName, String postalCode, String city, String province, String country){
        setCustomerID(customerID);
        setCustomerName(customerName);
        Address bankAddress = new Address(streetNumber,streetName,postalCode,city,province,country);
        setCustomerAddress(bankAddress);
        setCustomerAccounts();
    }


    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public ArrayList<Account> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerName(String customerName) {
        if(customerName == null){
            System.out.println("Error... empty name");
        }else{
            this.customerName = customerName;
        }
    }

    public void setCustomerID(int customerID) {
        if(customerID<=0){
            System.out.println("Error... invalid customer ID");
        }else{
            this.customerID = customerID;
        }
    }

    public void setCustomerAddress(Address customerAddress) {
        if(customerAddress == null){
            System.out.println("Error... empty name");
        }else{
            this.customerAddress = customerAddress;
            customerAddress.getCustomers().add(this);
        }
    }

    public void setCustomerAccounts(){
        this.customerAccounts = new ArrayList<Account>();
    }

    public void addAccount(Account acct){
        if(acct == null){
            System.out.println("Error ... cannot add a null account");
        }else{
            customerAccounts.add(acct);
        }
    }

    public void removeAccount(int accountNumber){
        if (accountNumber <=0) {
            System.out.println("Error... account id is invalid during deleting account");
        } else {
            for (int i = 0; i < customerAccounts.size(); i++) {
                Account acct = customerAccounts.get(i);
                if (acct.getAccountNumber()  == accountNumber)  {
                    System.out.println("Removed account from "+ customerName );
                    customerAccounts.remove(i);
                    break;
                }
            }
        }
    }
}
