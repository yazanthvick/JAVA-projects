package BANKSYSTEM;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Account implements Serializable {
    int accountNumber;
    String accountName;
    double accountBalance;
    private Branch accountBranch;
    private ArrayList<Transaction> accountTransactions;
    private Customer customer;
    static int transactionSequence = 0;

     protected Account(){

     }

     public Account(int accountNumber, String accountName,Customer customer){
        setCustomer(customer);
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setAccountBalance(0.0);
        setAccountBranch(null);
     }

     public Account(int accountNumber, String accountName, double accountBalance,Customer customer){
         setCustomer(customer);
         setAccountNumber(accountNumber);
         setAccountName(accountName);
         setAccountBalance(accountBalance);
         setAccountBranch(null);
     }

     public Account(int accountNumber, String accountName, double accountBalance, Branch accountBranch,Customer customer){
         setCustomer(customer);
         setAccountNumber(accountNumber);
         setAccountName(accountName);
         setAccountBalance(accountBalance);
         setAccountBranch(accountBranch);
     }

    public Branch getAccountBranch() {
        return accountBranch;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public ArrayList<Transaction> getAccountTransactions() {
        return accountTransactions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
         if(customer == null){
             System.out.println("Customer not valid");
         }else {
             this.customer = customer;
         }
    }

    public void setAccountBalance(double accountBalance) {
         if(accountBalance < 0){
             RuntimeException r = new RuntimeException("cannot set account balance less than 0 dollars");
             throw r;
         }
             this.accountBalance = accountBalance;
    }

    public void setAccountBranch(Branch accountBranch) {
         if(accountBranch == null){
           BankHeadOffice head = BankHeadOffice.getBankHeadOffice();
           for(int i=0; i < head.getBankBranches().size(); i++){
               Branch branch = head.getBankBranches().get(i);
               ArrayList<Account> branchAccounts = branch.getBranchAccounts();
               for(int j=0; j < branchAccounts.size(); j++){
                    if(this.accountNumber == branchAccounts.get(j).accountNumber){
                        this.accountBranch = branch;
                        this.accountBranch.addAccount(this);
                        return;
                    }
               }
           }if(this.accountBranch == null){
                 throw new RuntimeException("cannot create account without a valid registered branch");
             }
         }else{
             this.accountBranch = accountBranch;
             this.accountBranch.addAccount(this);
         }
    }

    public void setAccountName(String accountName) {
         if(accountName == null){
             System.out.println("Error...empty account name");
         }else {
             this.accountName = accountName;
         }

    }

    public void setAccountNumber(int accountNumber) {
         if(accountNumber < 0){
             System.out.println("Error...cannot assign negative account ID");
         }else {
             this.accountNumber = accountNumber;
         }
    }

    public void setAccountTransactions() {
        this.accountTransactions = new ArrayList<Transaction>();
    }

    public void addTransaction(Transaction t){
        if (t == null) {
            System.out.println("Error... Cannot add an empty transaction");
            return;
        }
        System.out.println("Added transaction to " + accountName);
        accountTransactions.add(t);
    }

    public void removeTransaction(String transactionID){
        if (transactionID == null) {
            System.out.println("Error... transaction id is invalid during deleting branch");
        } else {
            for (int i = 0; i < accountTransactions.size(); i++) {
                Transaction transaction = accountTransactions.get(i);
                if (transaction.getTransactionID().compareToIgnoreCase(transactionID)==0) {
                    System.out.println("Removed account from"+accountName);
                    accountTransactions.remove(i);
                    break;
                }
            }
        }
    }

    public abstract double deposit(double amount,String s);
    public abstract double withdraw(double amount, String s);
}
