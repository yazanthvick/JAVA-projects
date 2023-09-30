package BANKSYSTEM;

import java.util.Date;
import java.util.concurrent.TransferQueue;

public class CheckingAccount extends Account {
    private float accountFees;
    private float minimumWaivedFeesAmount;
    private int maxNumberOfTransactions;

    private CheckingAccount(){
    }

    public CheckingAccount(float accountFees, float minimumWaivedFeesAmount,int maxNumberOfTransactions, int accountNumber, String accountName,Customer customer){
        super(accountNumber,accountName,customer);
        setAccountFees(accountFees);
        setMinimumWaivedFeesAmount(minimumWaivedFeesAmount);
        setMaxNumberOfTransactions(maxNumberOfTransactions);
    }

    public CheckingAccount(float accountFees, float minimumWaivedFeesAmount, int maxNumberOfTransactions, int accountNumber, String accountName,double accountBalance,Customer customer){
        super(accountNumber,accountName,accountBalance,customer);
        setAccountFees(accountFees);
        setMinimumWaivedFeesAmount(minimumWaivedFeesAmount);
        setMaxNumberOfTransactions(maxNumberOfTransactions);
    }

    public CheckingAccount(float accountFees, float minimumWaivedFeesAmount, int maxNumberOfTransactions, int accountNumber, String accountName,double accountBalance,Customer customer,Branch accountBranch){
        super(accountNumber,accountName,accountBalance,accountBranch,customer);
        setAccountFees(accountFees);
        setMinimumWaivedFeesAmount(minimumWaivedFeesAmount);
        setMaxNumberOfTransactions(maxNumberOfTransactions);
    }

    public float getAccountFees() {
        return accountFees;
    }

    public float getMinimumWaivedFeesAmount() {
        return minimumWaivedFeesAmount;
    }

    public int getMaxNumberOfTransactions() {
        return maxNumberOfTransactions;
    }

    public void setAccountFees(float accountFees) {
        if(accountFees < 0){
            System.out.println("Error...Cannot set 0 or negative account fees");
        }else{
            this.accountFees = accountFees;
        }
    }

    public void setMaxNumberOfTransactions(int maxNumberOfTransactions) {
        if(maxNumberOfTransactions < 0){
            System.out.println("Error...Cannot set 0 or negative max number of transactions");
        }else{
            this.maxNumberOfTransactions = maxNumberOfTransactions;
        }

    }

    public void setMinimumWaivedFeesAmount(float minimumWaivedFeesAmount){
        if(minimumWaivedFeesAmount < 0){
            System.out.println("Error...Cannot set 0 or negative minimum waived fees am ount");
        }
        this.minimumWaivedFeesAmount = minimumWaivedFeesAmount;
    }

    @Override
    public  double deposit(double amount,String s){
       if(amount <= 0){
           System.out.println("Error...Cannot deposit negative or 0 dollars");
       }else{
           amount = getAccountBalance() + amount;
           setAccountBalance(amount);
           Transaction transaction = new Transaction("ID"+transactionSequence,amount,"Deposit",s,this,new Date());
           transactionSequence++;
       }
       return getAccountBalance();
    }

    @Override
    public  double withdraw(double amount,String s) {
        if (amount > getAccountBalance()) {
            System.out.println("Error...cannot withdraw amount higher than current account balance");
        }else{
            amount = getAccountBalance() - amount;
            setAccountBalance(amount);
            Transaction transaction = new Transaction("ID"+transactionSequence,amount,"Withdraw",s,this,new Date());
            transactionSequence++;
        }
        return getAccountBalance();
    }
}
