package BankSystemPackage;

import java.util.Date;

public class SavingAccount extends Account{
    private float minimumAccountBalance;
    private float intrestRate;

    private SavingAccount(){

    }
    public SavingAccount(float minimumAccountBalance, float intrestRate, int accountNumber, String accountName, Customer customer){
        super(accountNumber, accountName, customer);
        setMinimumAccountBalance(minimumAccountBalance);
        setIntrestRate(intrestRate);
    }
    public SavingAccount(float minimumAccountBalance, float intrestRate, int accountNumber, String accountName, double accountBalance, Customer customer){
        super(accountNumber, accountName, accountBalance, customer);
        setMinimumAccountBalance(minimumAccountBalance);
        setIntrestRate(intrestRate);
    }
    public SavingAccount(float minimumAccountBalance, float intrestRate, int accountNumber, String accountName, double accountBalance, Customer customer, Branch accountBranch){
        super(accountNumber, accountName, accountBalance, customer, accountBranch);
        setMinimumAccountBalance(minimumAccountBalance);
        setIntrestRate(intrestRate);
    }

    public float getMinimumAccountBalance() {
        return minimumAccountBalance;
    }

    public float getIntrestRate() {
        return intrestRate;
    }

    public void setMinimumAccountBalance(float minimumAccountBalance){
        if(minimumAccountBalance <=0){
            System.out.println("Error ... minimum balance should be greater than zero");
        }else{
            this.minimumAccountBalance = minimumAccountBalance;
        }

    }
    public void setIntrestRate(float intrestRate){
        if(intrestRate <=0){
            System.out.println("Error ... interest rate should be greater than zero");
        }else{
            this.intrestRate = intrestRate;
        }
    }
    public double deposit(double amount, String info){
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

    public double withdraw(double amount, String info){
        double accountBalance = this.getAccountBalance();
        if(amount <=0){
            System.out.println("Error ... withdraw amount should be above zero");
        }else if( (accountBalance - minimumAccountBalance) < amount){
            System.out.println("Error .... unsufficient fund or exceed the minimum withdraw limit");
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
