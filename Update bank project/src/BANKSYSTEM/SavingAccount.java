package BANKSYSTEM;

import java.util.Date;

public class SavingAccount extends Account {
    private float minimumAccountBalance;
    private float interestRate;

    private SavingAccount(){

    }

    public SavingAccount(float minimumAccountBalance, float interestRate,int accountNumber, String accountName,Customer customer){
        super(accountNumber,accountName,customer);
        setMinimumAccountBalance(minimumAccountBalance);
        setInterestRate(interestRate);
    }

    public SavingAccount(float minimumAccountBalance, float interestRate, int accountNumber, String accountName, double accountBalance,Customer customer){
        super(accountNumber,accountName,accountBalance,customer);
        setMinimumAccountBalance(minimumAccountBalance);
        setInterestRate(interestRate);
    }

    public SavingAccount(float minimumAccountBalance, float interestRate, int accountNumber, String accountName, double accountBalance,Customer customer,Branch accountBranch){
        super(accountNumber,accountName,accountBalance,accountBranch,customer);
        setMinimumAccountBalance(minimumAccountBalance);
        setInterestRate(interestRate);
    }

    public float getMinimumAccountBalance() {
        return minimumAccountBalance;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setMinimumAccountBalance(float minimumAccountBalance) {
        if(minimumAccountBalance<=0){
            System.out.println("Error...minAccountBalance must be greater than 0");
        }else{
            this.minimumAccountBalance = minimumAccountBalance;
        }
    }

    public void setInterestRate(float interestRate) {
        if(interestRate<=0){
            System.out.println("Error...interest rate must be greater than 0");
        }else{
            this.interestRate = interestRate;
        }
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
    public double withdraw(double amount,String s){
        if(amount >= minimumAccountBalance){
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
