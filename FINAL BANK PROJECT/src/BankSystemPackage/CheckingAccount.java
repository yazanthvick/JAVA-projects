package BankSystemPackage;

import java.util.Date;

public class CheckingAccount extends Account{
    private float accountFees;
    private float minimumWaivedFeesAmount;
    private int maxNumberOfTransactions; // 0 means unlimited transactions

    private CheckingAccount(){

    }

    public CheckingAccount(float accountFees, float minimumWaivedFeesAmount, int maxNumberOfTransactions, int accountNumber, String accountName, Customer customer){
        super(accountNumber, accountName, customer);
        setAccoutFees(accountFees);
        setMinimumWaivedFeesAmount(minimumWaivedFeesAmount);
        setMaxNumberOfTransactions(maxNumberOfTransactions);
    }
    public CheckingAccount(float accountFees, float minimumWaivedFeesAmount, int maxNumberOfTransactions, int accountNumber, String accountName, double accountBalance, Customer customer){
        super(accountNumber, accountName, accountBalance, customer);
        setAccoutFees(accountFees);
        setMinimumWaivedFeesAmount(minimumWaivedFeesAmount);
        setMaxNumberOfTransactions(maxNumberOfTransactions);
    }
    public CheckingAccount(float accountFees, float minimumWaivedFeesAmount, int maxNumberOfTransactions, int accountNumber, String accountName, double accountBalance, Customer customer, Branch accountBranch){
        super(accountNumber, accountName, accountBalance, customer, accountBranch);
        setAccoutFees(accountFees);
        setMinimumWaivedFeesAmount(minimumWaivedFeesAmount);
        setMaxNumberOfTransactions(maxNumberOfTransactions);
    }

    public float getAccountFees() {
        return accountFees;
    }
    public float getMinimumWaivedFeesAmount() {
        return minimumWaivedFeesAmount;
    }
    public int getMaxNumberOfTransactions(){
        return maxNumberOfTransactions;
    }
    public void setAccoutFees(float accountFees){
        if(accountFees<0){
            System.out.println("Error... Fees cannot be in negative");
        }else{
            this.accountFees = accountFees;
        }

    }
    public void setMinimumWaivedFeesAmount(float minimumWaivedFeesAmount){
        if(minimumWaivedFeesAmount<=0){
            System.out.println("Error... Minimum amount to waive your fees cannot be in negative");
        }else{
            this.minimumWaivedFeesAmount = minimumWaivedFeesAmount;
        }
    }
    public void setMaxNumberOfTransactions(int maxNumberOfTransactions){
        if(maxNumberOfTransactions<0){
            System.out.println("Error... Minimum amount to waive your fees cannot be in negative");
        }else{
            this.maxNumberOfTransactions = maxNumberOfTransactions;
        }
    }
    public synchronized double deposit(double amount, String info){
        if(amount <=0){
            System.out.println("Error ... deposit amount should be above zero");
        }else{
            int transactionNextNumber = ++transactionSequence;
            Transaction depositTransaction = new Transaction(String.valueOf(transactionNextNumber), amount, "Deposit", info, new Date());
            this.addTransaction(depositTransaction);
            this.setAccountBalance(this.getAccountBalance() + amount);
        }
        return getAccountBalance();
    }
    public synchronized double withdraw(double amount, String info){
        double accountBalance = this.getAccountBalance();
        if(amount <=0){
            System.out.println("Error ... withdraw amount should be above zero");
        }else if( accountBalance < amount){
            System.out.println("Error .... unsufficient fund");
        }else{
            int transactionNextNumber = ++transactionSequence;
            Transaction depositTransaction = new Transaction(String.valueOf(transactionNextNumber), amount, "Withdraw", info, new Date());
            this.addTransaction(depositTransaction);
            accountBalance = accountBalance - amount;
            this.setAccountBalance(accountBalance);
        }
        return accountBalance;
    }
}
