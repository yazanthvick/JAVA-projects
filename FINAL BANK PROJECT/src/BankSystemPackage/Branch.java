package BankSystemPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class Branch implements Serializable{
    private int branchID;
    private String branchName;
    private Address branchAddress;
    private ArrayList<Account> branchAccounts;
    private static BankHeadOffice headOffice = BankHeadOffice.getBankHeadOffice();



    private Branch(){
    }

    public Branch(int branchID, String branchName){
        setBranchID(branchID);
        setBranchName(branchName);
        setHeadOffice();
        addBranchToHeadOffice(this);
        setBranchAccounts();
    }

    public Branch(int branchID, String branchName, Address branchAddress){
        setBranchID(branchID);
        setBranchName(branchName);
        setBranchAddress(branchAddress);
        setHeadOffice();
        addBranchToHeadOffice(this);
        setBranchAccounts();
    }
    public Branch(int branchID, String branchName, int streetNumber, String streetName, String postalCode, String city, String province, String country){
        setBranchID(branchID);
        setBranchName(branchName);
        setBranchAddress(new Address(streetNumber,streetName,postalCode,city,province,country));
        setHeadOffice();
        addBranchToHeadOffice(this);
        setBranchAccounts();
    }
    public int getBranchID(){ return branchID;}
    public String getBranchName(){ return branchName;}
    public Address getBranchAddress(){ return branchAddress;}
    public BankHeadOffice getHeadOffice(){ return headOffice;}
    public ArrayList<Account> getBranchAccounts(){ return branchAccounts;}

    public void setBranchID(int branchID){
        if(branchID<=0){
            System.out.println("Error... invalid branch id");
        }else{
            this.branchID = branchID;
        }
   }

    public void setBranchName(String branchName){
        if(branchName == null){
            System.out.println("Error... invalid branch name");
        }else{
            this.branchName = branchName;
        }
    }

    public static void setHeadOffice(){
            headOffice = BankHeadOffice.getBankHeadOffice();

    }

    private void setBranchAddress(int streetNumber, String streetName, String postalCode, String city, String province, String country){
        setBranchAddress(new Address(streetNumber,streetName,postalCode,city,province,country));
    }

    public void setBranchAddress(Address branchAddress){
        if(branchAddress == null){
            System.out.println("Error... Invlid Address");
        }else{
            this.branchAddress = branchAddress;
        }
    }
    public void setBranchAccounts(){
        branchAccounts = new ArrayList<Account>();
    }

    private static void addBranchToHeadOffice(Branch branch){
        if(branch == null){
            System.out.println("Error... Cannot add an empty branch");
            return;
        }
        if(headOffice == null){
            setHeadOffice();
        }

        BankHeadOffice head_office = BankHeadOffice.getBankHeadOffice();
        ArrayList<Branch> allBranches = head_office.getBankBranches();
        for(int i=0;i<allBranches.size(); i++){
            Branch tmpBranch = allBranches.get(i);
            if(tmpBranch.getBranchID() == branch.getBranchID()){
                System.out.println("Error... cannot add branch with same ID");
                RuntimeException rte= new RuntimeException("Cannot create object of a branch with same ID");
                throw rte;
            }
        }
        headOffice.addBranch(branch);

    }

     void addAccount(Account acct){
        if(acct == null){
            System.out.println("Error ... Cannaot add an empty account");
            return;
        }

        for(int i=0;i<branchAccounts.size(); i++){
            Account account = branchAccounts.get(i);
            if(account.getAccountNumber() == acct.getAccountNumber()){
                System.out.println("Warning ... Trying to add the same account twice ");
                return;
            }
        }
        branchAccounts.add(acct);
    }

    void deleteAccount(int accountId){
        if(accountId<=0){
            System.out.println("Error... account id is invalid during deleting account");
        }else{
            for(int i=0; i<branchAccounts.size(); i++){
                Account account = branchAccounts.get(i);
                if(account.getAccountNumber() == accountId){
                    branchAccounts.remove(i);
                    break;
                }
            }
        }
    }

}
