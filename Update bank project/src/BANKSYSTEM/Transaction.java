package BANKSYSTEM;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private String transactionID;
    private double transactionAmount;
    private String transactionType;
    private String transactionDetails;
    private Account transactionAccount;
    private Date transactionDate;

    private static final String[] keywords = {"Deposit", "Withdraw"};

    private Transaction() {
    }

    public Transaction(String transactionID, double transactionAmount, String transactionType, String transactionDetails, Account transactionAccount, Date transactionDate) {
        setTransactionID(transactionID);
        setTransactionAmount(transactionAmount);
        setTransactionType(transactionType);
        setTransactionDetails(transactionDetails);
        setTransactionDate(transactionDate);
        setTransactionAccount(transactionAccount);
    }

    public Transaction(String transactionID, double transactionAmount, String transactionType, String transactionDetails, Date transactionDate) {
        setTransactionID(transactionID);
        setTransactionAmount(transactionAmount);
        setTransactionType(transactionType);
        setTransactionDetails(transactionDetails);
        setTransactionDate(transactionDate);
        setTransactionAccount(null);
    }

    public String getTransactionID() {
        return transactionID;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getTransactionDetails() {
        return transactionDetails;
    }

    public Account getTransactionAccount() {
        return transactionAccount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionID(String transactionID) {
        if (transactionID == null) {
            System.out.println("Error...transaction ID can't be empty");
        } else {
            this.transactionID = transactionID;
        }
    }

    public void setTransactionAmount(double transactionAmount) {
        if (transactionAmount <= 0) {
            System.out.println("Error,,,transaction amount cannot be less than or equal to 0 dollars");
        } else {
            this.transactionAmount = transactionAmount;
        }
    }

    public void setTransactionDate(Date transactionDate) {
        if (transactionDate == null) {
            System.out.println("Error...date cannot be empty");
        } else {
            this.transactionDate = transactionDate;
        }
    }

    public void setTransactionDetails(String transactionDetails) {
        if (transactionDetails == null) {
            System.out.println("Error...transaction ID can't be empty");
        } else {
            this.transactionDetails = transactionDetails;
        }
    }

    private boolean checkTransactionType(String t) {
        for (int i = 0; i < keywords.length; i++) {
            if (keywords[i].compareToIgnoreCase(t) == 0) {
                return true;
            }
        }
        return false;
    }

    public void setTransactionType(String transactionType) {
        if (!(checkTransactionType(transactionType))) {
            System.out.println("Error...Invalid transaction type");
        } else {
            this.transactionType = transactionType;
        }
    }

    public void setTransactionAccount(Account transactionAccount) {
        if (transactionAccount == null) {
            BankHeadOffice head = BankHeadOffice.getBankHeadOffice();
            for (int i = 0; i < head.getBankBranches().size(); i++) {
                Branch branch = head.getBankBranches().get(i);
                ArrayList<Account> branchAccounts = branch.getBranchAccounts();
                for (int j = 0; j < branchAccounts.size(); j++) {
                    Account account = branchAccounts.get(j);
                    ArrayList<Transaction> allTransactions = account.getAccountTransactions();
                    for (int k = 0; k < allTransactions.size(); k++) {
                        Transaction transaction = allTransactions.get(k);
                        if (this.transactionID == transaction.transactionID) {
                            this.transactionAccount = account;
                            this.transactionAccount.addTransaction(this);
                            return;
                        }
                    }
                }
            }
        }else if (this.transactionAccount == null) {
            throw new RuntimeException("cannot create account without a valid registered branch");
        } else {
            this.transactionAccount = transactionAccount;
            this.transactionAccount.addTransaction(this);
        }
    }

}