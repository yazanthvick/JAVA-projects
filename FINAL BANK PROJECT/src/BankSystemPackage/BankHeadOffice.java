package BankSystemPackage;

import java.io.Serializable;
import java.util.ArrayList;


public class BankHeadOffice implements Serializable {
    private int bankRegisteredId;
    private String bankName;
    private Address bankAddress;
    private ArrayList<Branch> bankBranches;
    private static BankHeadOffice headOffice;

    public static BankHeadOffice getBankHeadOffice(){
        if(headOffice == null){
            headOffice = new BankHeadOffice(1,"TD",100,"Sqare On Drive","M1C 4B2","Mississauga","ON","Canada");
        }
        return headOffice;
    }

    private BankHeadOffice(){
    }

    private BankHeadOffice(int bankRegisteredId, String bankName){
        setBankRegisteredId(bankRegisteredId);
        setBankName(bankName);
        setBankBranches();
    }

    private BankHeadOffice(int bankRegisteredId, String bankName, Address bankAddress){
        setBankRegisteredId(bankRegisteredId);
        setBankName(bankName);
        setBankAddress(bankAddress);
        setBankBranches();
    }

    private BankHeadOffice(int bankRegisteredId, String bankName, int streetNumber, String streetName, String postalCode, String city, String province, String country){
        setBankRegisteredId(bankRegisteredId);
        setBankName(bankName);
        Address bankAddress = new Address(streetNumber,streetName,postalCode,city,province,country);
        setBankAddress(bankAddress);
        setBankBranches();
    }
    public int getBankRegisteredId(){ return bankRegisteredId;}
    public String getBankName(){ return bankName;}
    public Address getBankAddress(){ return bankAddress;}
    public ArrayList<Branch> getBankBranches(){ return bankBranches;}

    private void setBankRegisteredId(int bankRegisteredId){
        if(bankRegisteredId <= 0){
            System.out.println("Error... Invalid bank registeration id");
        }else{
            this.bankRegisteredId = bankRegisteredId;
        }
    }
    private void setBankName(String bankName){
        if(bankName == null){
            System.out.println("Error... Invalid bank name");
        }else{
            this.bankName = bankName;
        }

    }
    private void setBankAddress(Address bankAddress){
        if(bankAddress == null){
            System.out.println("Error... Invalid bank address");
        }else{
            this.bankAddress = bankAddress;
        }
    }

    private void setBankAddress(int streetNumber, String streetName, String postalCode, String city, String province, String country){
        Address bankAddress = new Address(streetNumber,streetName,postalCode,city,province,country);
        setBankAddress(bankAddress);
    }

    private void setBankBranches(){
        bankBranches = new ArrayList<Branch>();
    }

    void addBranch(Branch branch){
        if(branch == null){
            System.out.println("Error... cannot add an empty branch");
        }else{
            if(branch.getBranchAddress() == null){
                System.out.println("Warning... Adding branch without address");
            }
            bankBranches.add(branch);
        }

    }

    void deleteBranch(int branchId){
        if(branchId<=0){
            System.out.println("Error... branch id is invalid during deleting branch");
        }else{
            for(int i=0; i<bankBranches.size(); i++){
                Branch branch = bankBranches.get(i);
                if(branch.getBranchID() == branchId){
                    bankBranches.remove(i);
                    break;
                }
            }
        }
    }

    public Branch getBranchByAccountId(Account acct){
        if(acct == null){
            System.out.println("Error ... account cannot be null");
            return null;
        }
        for(int i=0; i<bankBranches.size(); i++){
            Branch branch = bankBranches.get(i);
            ArrayList<Account> branchAccount = branch.getBranchAccounts();
            for(int j=0; j<branchAccount.size(); j++){
                Account account = branchAccount.get(j);
                if(account.getAccountNumber() == acct.getAccountNumber()){
                    return branch;
                }
            }

        }
        return null;
    }

    public Account getAccountByTransactionId(Transaction accountTransaction){
        if(accountTransaction == null){
            System.out.println("Error ... account transaction cannot be null");
            return null;
        }
        for(int i=0; i<bankBranches.size(); i++){
            Branch branch = bankBranches.get(i);
            ArrayList<Account> branchAccount = branch.getBranchAccounts();
            for(int j=0; j<branchAccount.size(); j++){
                Account account = branchAccount.get(j);
                ArrayList<Transaction> allTransactions = account.getAccountTransactions();
                for(int k=0; k<allTransactions.size(); k++){
                    Transaction transaction = allTransactions.get(k);
                    if(transaction.getTransactionID() == accountTransaction.getTransactionID()){
                        return account;
                    }
                }

            }

        }
        return null;
    }



}
