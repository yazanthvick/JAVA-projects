package BANKSYSTEM;
import java.util.ArrayList;
public class BankHeadOffice {
    private int bankRegisteredId;
    private String bankName;
    private Address headOfficeAddress;
    private ArrayList<Branch> bankBranches;
    private static BankHeadOffice headOffice;

    public static BankHeadOffice getBankHeadOffice(){
        if(headOffice == null){
          headOffice = new BankHeadOffice(1,"TD",100,"Yonge St","M1N0A5","Toronto","ON","Canada");
        }
        return headOffice;
    }

    private BankHeadOffice(){
    }

    private BankHeadOffice(int bankRegisteredId,String bankName, Address headOfficeAddress){
        setBankRegisteredId(bankRegisteredId);
        setBankName(bankName);
        setHeadOfficeAddress(headOfficeAddress);
        setBankBranches();
    }

    private BankHeadOffice(int bankRegisteredId, String bankName, int streetNumber, String streetName, String postalCode, String city, String province, String country){
        setBankRegisteredId(bankRegisteredId);
        setBankName(bankName);
        setHeadOfficeAddress(streetNumber,streetName,postalCode,city,province,country);
        setBankBranches();
    }

    public Address getHeadOfficeAddress() {
        return headOfficeAddress;
    }

    public int getBankRegisteredId() {
        return bankRegisteredId;
    }

    public String getBankName() {
        return bankName;
    }

    public ArrayList<Branch> getBankBranches() {
        return bankBranches;
    }

    private void setBankRegisteredId(int bankRegisteredId) {
        if(bankRegisteredId < 0){
            System.out.println("Invalid ID");
        }else {
            this.bankRegisteredId = bankRegisteredId;
        }
    }

    private void setHeadOfficeAddress(int streetNumber, String streetName, String postalCode, String city, String province, String country){
        setHeadOfficeAddress(new Address(streetNumber,streetName,postalCode,city,province,country));
    }

    private void setHeadOfficeAddress(Address headOfficeAddress) {
        if(headOfficeAddress == null){
            System.out.println("Error... Invalid bank address");
        }else{
            this.headOfficeAddress = headOfficeAddress;
        }
    }

    private void setBankName(String bankName) {
        if(bankName == null){
            System.out.println("Error... Invalid bank name");
        }else{
            this.bankName = bankName;
        }
    }
    private void setBankBranches(){
        bankBranches = new ArrayList<Branch>();
    }

     void addBranch(Branch branch) {
         if(branch == null){
             System.out.println("Error... Cannot add an empty branch");
             return;
         }
        for(int i=0; i < bankBranches.size(); i++){
            if(branch.getBranchId() == bankBranches.get(i).getBranchId()){
                RuntimeException re = new RuntimeException("Cannot add branchID that already exists");
                throw re;
            }
        }if(branch.getBankAddress() == null){
            System.out.println("Warning...setting Branch without address");
            bankBranches.add(branch);
        }else{
            bankBranches.add(branch);
             System.out.println("Successfully added bank branchId" + branch.getBranchId());
        }
    }
    void deleteBranch(int branchId){
        if(branchId<=0){
            System.out.println("Error... branch id is invalid during deleting branch");
        }else{
            for(int i=0; i<bankBranches.size(); i++){
                Branch branch = bankBranches.get(i);
                if(branch.getBranchId() == branchId){
                    bankBranches.remove(i);
                    break;
                }
            }
        }
    }
}
