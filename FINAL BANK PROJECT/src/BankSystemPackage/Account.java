package BankSystemPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

public abstract class Account implements Serializable {
    private int accountNumber;
    private String accountName;
    private double accountBalance;
    private Branch accountBranch;
    private ArrayList<Transaction> accountTransactions;
    private Customer customer;
    static int transactionSequence =0;

    protected Account(){

    }

    public Account(int accountNumber, String accountName,Customer customer){
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setAccountBalance(0.0);
        //setAccountBranch(null);
        setCustomer(customer);
        initializeAccountTransactions();
    }

    public Account(int accountNumber, String accountName, double accountBalance, Customer customer){
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setAccountBalance(accountBalance);
        setAccountBranch(null);
        setCustomer(customer);
        initializeAccountTransactions();
    }


    public Account(int accountNumber, String accountName, double accountBalance, Customer customer, Branch accountBranch){
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setAccountBalance(accountBalance);
        setAccountBranch(accountBranch);
        setCustomer(customer);
        initializeAccountTransactions();
    }
    public int getAccountNumber(){ return accountNumber;}
    public String getAccountName(){ return accountName;}
    public double getAccountBalance(){ return accountBalance;}
    public Branch getAccountBranch(){ return accountBranch;}
    public Customer getCustomer(){ return customer;}

    public ArrayList<Transaction> getAccountTransactions(){
        return accountTransactions;
    }
    public void addTransaction(Transaction transaction){
        if(transaction == null){
            System.out.println("Error ... transation cannot be null");
        }else{
            accountTransactions.add(transaction);
        }
    }
    public void removeTransaction(String transactionID){
        if (transactionID == null) {
            System.out.println("Error... transaction id is invalid during deleting branch");
        } else {
            for (int i = 0; i < accountTransactions.size(); i++) {
                Transaction transaction = accountTransactions.get(i);
                if (transaction.getTransactionID().compareToIgnoreCase(transactionID)==0) {
                    System.out.println("Removed account from "+accountName);
                    accountTransactions.remove(i);
                    break;
                }
            }
        }
    }
    public void setAccountNumber(int accountNumber){
        if (accountNumber <= 0) {
            System.out.println("Error .... Account number cannot be less than or equal to zero");
        }else{
            this.accountNumber = accountNumber;
        }

    }
    public void setAccountName(String accountName){
        if(accountName == null){
           Logger log = BankLogger.getLogger();
           log.severe("Account name cannot be null");
           // System.out.println("Error ... Account name cannot be null");
            //log.sever("Account name cannot be null");
        }else{
            this.accountName = accountName;
        }
    }
    public void setAccountBalance(double accountBalance){
        if(accountBalance < 0){
            System.out.println("Error ... Account balance cannot be negative");
        }else{
            this.accountBalance = accountBalance;
        }
    }
    public void setAccountBranch(Branch accountBranch){
        if(accountBranch == null){
            System.out.println("Warning ... account branch cannot be null");
            BankHeadOffice headOffice = BankHeadOffice.getBankHeadOffice();
            this.accountBranch = headOffice.getBranchByAccountId(this);
            if(this.accountBranch == null){
                throw new RuntimeException("Branch cannot be found ... Account should be assosiated with a valid branch");
            }

        }else{
            this.accountBranch = accountBranch;
            addAccountToBranch();
        }
    }

    public void setCustomer(Customer customer){
        if(customer == null){
            System.out.println("Error ... customer cannot be null ");
            throw new RuntimeException("Branch cannot be found ... Account should be assosiated with a valid branch");
        }else{
            this.customer = customer;
            addAccountToCustomer();
        }
    }

    public void addAccountToBranch(){

        ArrayList<Account> allAccounts = accountBranch.getBranchAccounts();
        for(int i=0;i<allAccounts.size(); i++){
            Account account = allAccounts.get(i);
            if(account.getAccountNumber() == this.getAccountNumber()){
                System.out.println("Error... cannot add Account with same ID");
                RuntimeException rte= new RuntimeException("Cannot create object of a account with same ID");
                throw rte;
            }
        }
        accountBranch.addAccount(this);
    }

    public void addAccountToCustomer(){

        ArrayList<Account> allAccounts = customer.getCustomerAccounts();
        for(int i=0;i<allAccounts.size(); i++){
            Account account = allAccounts.get(i);
            if(account.getAccountNumber() == this.getAccountNumber()){
                System.out.println("Error... cannot add Account with same ID");
                RuntimeException rte= new RuntimeException("Cannot create object of a account with same ID");
                throw rte;
            }
        }
        customer.addAccount(this);
    }
    public void initializeAccountTransactions(){
        accountTransactions = new ArrayList<Transaction>();
    }
    public abstract double deposit(double amount,String info);
    public abstract double withdraw(double amount, String info);
}
