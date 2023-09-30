package BANKSYSTEM;

import java.io.Serializable;

public class Credential implements CredentialUserTypes, Serializable {
    private String username;
    private String password;
    private int userType; // 1 = head office , 2 = branch, 3 = Customer
    private Customer customer;
    private Branch branch;
    private BankHeadOffice headOffice = BankHeadOffice.getBankHeadOffice();
    private static final String[] allUserTypes = { "HeadOffice", "Branch", "Customer"};

    private Credential(){

    }

    public Credential(String username, String password, String type, Customer customer){
        setUsername(username);
        setPassword(password);
        setUserType(mapTypeToUserType(type));
        setCustomer(customer);
        if(getUserType() != CredentialUserTypes.CUSTOMER_USER || getCustomer() == null){
            System.out.println("Error ... Cannot create Credential for customer user");
            throw new RuntimeException("Cannot create Credential...check user type or associated instances");
        }

    }

    public Credential(String username, String password, String type, Branch branch){
        setUsername(username);
        setPassword(password);
        setUserType(mapTypeToUserType(type));
        setBranch(branch);
        if(getUserType() != CredentialUserTypes.BRANCH_USER || getBranch() == null){
            System.out.println("Error ... Cannot create Credential for branch user");
            throw new RuntimeException("Cannot create Credential...check user type or associated instances");
        }

    }

    public Credential(String username, String password, String type, BankHeadOffice headOffice){
        setUsername(username);
        setPassword(password);
        setUserType(mapTypeToUserType(type));
        if(this.headOffice == null){
            this.headOffice = headOffice;
        }
        if(getUserType() != CredentialUserTypes.HEADOFFICE_USER || this.headOffice == null){
            System.out.println("Error ... Cannot create Credential for head office user");
            throw new RuntimeException("Cannot create Credential...check user type or associated instances");
        }
    }

    public String getUsername(){ return username;}
    public String getPassword(){ return password;}
    public int getUserType(){ return userType;}
    public Customer getCustomer(){ return customer;}
    public Branch getBranch(){ return branch;}

    public int mapTypeToUserType(String type){
        for(int i=0;i<allUserTypes.length;i++){
            if(allUserTypes[i].equalsIgnoreCase(type)){
                return i+1;
            }
        }
        return 0;
    }
    public void setUsername(String username){
        if(username == null){
            System.out.println("Error ... cannot have a null user name");
        }else{
            this.username = username;
        }
    }

    public void setPassword(String password){
        if(password == null){
            System.out.println("Error ... cannot have a null password");
        }else{
            this.password = password;
        }
    }

    public void setUserType(int userType){
        if(userType != CredentialUserTypes.HEADOFFICE_USER || userType != CredentialUserTypes.BRANCH_USER || userType != CredentialUserTypes.CUSTOMER_USER){
            System.out.println("Error ... incorrect user type");
        }else{
            this.userType = userType;
        }
    }

    public void setCustomer(Customer customer){
        if(userType != CredentialUserTypes.CUSTOMER_USER || customer == null){
            System.out.println("Error ... cannot set this customer instance");
        }else{
            this.customer = customer;
        }
    }

    public void setBranch(Branch branch){
        if(userType != CredentialUserTypes.BRANCH_USER || branch == null){
            System.out.println("Error ... cannot set this branch instance");
        }else{
            this.branch = branch;
        }
    }

    public boolean isHeadOfficeAdmin(){
        if(this.userType == CredentialUserTypes.HEADOFFICE_USER){
            return true;
        }
        return false;
    }
    public boolean isBranchAdmin(){
        if(this.userType == CredentialUserTypes.BRANCH_USER){
            return true;
        }
        return false;
    }
    public boolean isCustomer(){
        if(this.userType == CredentialUserTypes.CUSTOMER_USER){
            return true;
        }
        return false;
    }


}
