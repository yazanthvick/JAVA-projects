package BankSystemPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Transaction implements Serializable {
    private String transactionID;
    private double transactionAmount;
    private String transactionType;
    private String transactionDetails;
    private Account transactionAccount;
    private Date transactionDate;

    private static final String[] transactionAllowedTypes = { "Deposit", "Withdraw"};

    private Transaction(){

    }

    public Transaction(String transactionID, double transactionAmount, String transactionType, String transactionDetails, Date transactionDate){
        setTransactionID(transactionID);
        setTransactionAmount(transactionAmount);
        setTransactionType(transactionType);
        setTransactionDetails(transactionDetails);
        setTransactionDate(transactionDate);
       // setTransactionAccount(null);
    }

    public Transaction(String transactionID, double transactionAmount, String transactionType, String transactionDetails, Date transactionDate, Account transactionAccount){
        setTransactionID(transactionID);
        setTransactionAmount(transactionAmount);
        setTransactionType(transactionType);
        setTransactionDetails(transactionDetails);
        setTransactionDate(transactionDate);
        setTransactionAccount(transactionAccount);
    }
   public String toString(){
       return "Transaction ID:"+ transactionID + ", Amount:" +transactionAmount + ", transaction Type:"+transactionType+", Details:"+ transactionDetails +", Date:"+ transactionDate;

    }

    public String getTransactionID(){
        return transactionID;
    }
    public double getTransactionAmount(){
        return transactionAmount;
    }
    public String getTransactionType(){
        return transactionType;
    }
    public String getTransactionDetails(){
        return transactionDetails;
    }
    public Account getTransactionAccount(){
        return transactionAccount;
    }
    public Date getTransactionDate(){
        return transactionDate;
    }

    public void setTransactionID(String transactionID){
        if(transactionID == null){
            System.out.println("Error ... transaction ID cannot be null");
        }else{
            this.transactionID = transactionID;
        }

    }
    public void setTransactionAmount(double transactionAmount){
        if(transactionAmount <=0){
            System.out.println("Error ... transaction amount should be positive");
        }else{
            this.transactionAmount = transactionAmount;
        }

    }
    private boolean validateTransactionType(String transactionType){

        for( int i=0; i< transactionAllowedTypes.length; i++){
            if(transactionAllowedTypes[i].equalsIgnoreCase(transactionType)){
                return true;
            }
        }
        return false;
    }
    public void setTransactionType(String transactionType){
        if(transactionType == null){
            System.out.println(("Error ... transaction type cannot be null"));
        }
        if(validateTransactionType(transactionType)){
            this.transactionType = transactionType;
        }else{
            System.out.println("Error ..." + transactionType + " is invalid transaction type");
        }

    }
    public void setTransactionDetails(String transactionDetails){
        if(transactionDetails == null){
            System.out.println("Error ... transaction details cannot be null");
        }else{
            this.transactionDetails = transactionDetails;
        }
    }
    public void setTransactionDate(Date transactionDate){
        if(transactionDate == null){
            System.out.println("Error ... Transaction Date cannot be null");
        }else{
            this.transactionDate = transactionDate;
        }

    }

    public void setTransactionAccount(Account transactionAccount){
        if(transactionAccount == null){
            System.out.println("Warning ... Transaction Account cannot be null .. trying to find it ...");
            BankHeadOffice headOffice = BankHeadOffice.getBankHeadOffice();
            this.transactionAccount = headOffice.getAccountByTransactionId(this);
            if(this.transactionAccount == null){
                throw new RuntimeException("Account cannot be found ... Transaction should be assosiated with a valid Account");
            }

        }else{
            this.transactionAccount = transactionAccount;
            addTransactionToAccount();
        }

    }

    public void addTransactionToAccount(){

        ArrayList<Transaction> allTransactions = transactionAccount.getAccountTransactions();
        for(int i=0;i<allTransactions.size(); i++){
            Transaction transaction = allTransactions.get(i);
            if(transaction.getTransactionID() == this.getTransactionID()){
                System.out.println("Error... Transaction ID should be unique");
                RuntimeException rte= new RuntimeException("Cannot create object of a transaction with same ID");
                throw rte;
            }
        }
        transactionAccount.addTransaction(this);
    }

}
