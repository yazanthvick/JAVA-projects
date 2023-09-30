package BANKSYSTEM;


import java.io.Serializable;
import java.util.ArrayList;

public class Branch implements Serializable {
    private int branchId;
    private String bankName;
    private Address bankAddress;
    private static BankHeadOffice headOffice = BankHeadOffice.getBankHeadOffice();
    private ArrayList<Account> branchAccounts;


    private Branch() {
    }

    public Branch(int BranchId, String bankName) {
        setBranchId(BranchId);
        setBankName(bankName);
        setHeadOffice();
        setBranchAccounts();
        headOffice.addBranch(this);
    }

    public Branch(int BranchId, String bankName, Address bankAddress) {
        setBranchId(BranchId);
        setBankName(bankName);
        setBankAddress(bankAddress);
        setHeadOffice();
        setBranchAccounts();
        headOffice.addBranch(this);
    }

    public Branch(int BranchId, String bankName, int streetNumber, String streetName, String postalCode, String city, String province, String country) {
        setBranchId(BranchId);
        setBankName(bankName);
        setBankAddress(streetNumber, streetName, postalCode, city, province, country);
        setHeadOffice();
        setBranchAccounts();
        headOffice.addBranch(this);
    }

    public int getBranchId() {
        return branchId;
    }

    public String getBankName() {
        return bankName;
    }

    public Address getBankAddress() {
        return bankAddress;
    }

    public static BankHeadOffice getHeadOffice() {
        return headOffice;
    }

    public ArrayList<Account> getBranchAccounts() {
        return branchAccounts;
    }

    public void setBankName(String bankName) {
        if (bankName == null) {
            System.out.println("Invalid..empty bank name");
        }
        this.bankName = bankName;
    }

    public void setBranchId(int branchId) {
        if (branchId < 0) {
            System.out.println("Invalid branch Id");
        } else {
            this.branchId = branchId;
        }
    }

    public void setBranchAccounts() {
        this.branchAccounts = new ArrayList<Account>();
    }

    public void setBankAddress(Address bankAddress) {
        if (bankAddress == null) {
            System.out.println("Invalid bank address");
        } else {
            this.bankAddress = bankAddress;
        }
    }

    public void setBankAddress(int streetNumber, String streetName, String postalCode, String city, String province, String country) {
        setBankAddress(new Address(streetNumber, streetName, postalCode, city, province, country));
    }

    public static void setHeadOffice() {
        headOffice = BankHeadOffice.getBankHeadOffice();
    }

    void addAccount(Account account) {
        if (account == null) {
            System.out.println("Error... Cannot add an empty branch");
            return;
        }
        for (int i = 0; i < branchAccounts.size(); i++) {
            if (account.getAccountNumber() == branchAccounts.get(i).getAccountNumber()) {
                RuntimeException re = new RuntimeException("Cannot add account with an accountID that already exists");
                throw re;
            }
        }
        System.out.println("Added account to " + bankName);
        branchAccounts.add(account);
    }

    void deleteAccount(int accountNumber) {
        if (accountNumber <= 0) {
            System.out.println("Error... branch id is invalid during deleting branch");
        } else {
            for (int i = 0; i < branchAccounts.size(); i++) {
                Account account = branchAccounts.get(i);
                if (account.getAccountNumber() == accountNumber) {
                    System.out.println("Removed account from"+bankName);
                    branchAccounts.remove(i);
                    break;
                }
            }
        }
    }
}