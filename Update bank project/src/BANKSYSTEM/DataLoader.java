package BANKSYSTEM;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class DataLoader {
    ArrayList<Credential> allCredential = new ArrayList<Credential>();

    public DataLoader(){

        BankHeadOffice headOffice = BankHeadOffice.getBankHeadOffice();
        Branch branch1 = new Branch(1,"Square One",1255,"Mississauga Road","J2k 3U4","Mississauga","ON","Canada");
        Branch branch2 = new Branch(2,"Mackenzie",5699,"Mackenzie Road","K8C5I6","Markham","ON","Canada");
        Customer customer1 = new Customer(100,"Yaz",5544,"Mackenzie Road","K8C5I8","Markham","ON","Canada");
        Customer customer2 = new Customer(200,"Ihab",6666,"Mississauga Road","J2k 3U2","Mississauga","ON","Canada");
        Customer customer3 = new Customer(300,"Ana");
        branch1.addAccount(new CheckingAccount(30.0f,4000.0f,0,20201,customer1.getCustomerName() +" Checking Account",customer1 ));
        Account acct2 = new SavingAccount(100.0f,0.025f,30301,customer1.getCustomerName()+" Saving Account", 1000.0, customer1, branch1);
        Account acct3 = new CheckingAccount(30.0f,4000.0f,0,20202,customer2.getCustomerName() +" Checking Account",0.0,customer2, branch1 );
        Account acct4 = new CheckingAccount(30.0f,4000.0f,0,20203,customer3.getCustomerName() +" Checking Account",3000.0,customer3, branch2 );
        ArrayList<Account> customerAccounts = customer1.getCustomerAccounts();
        for(int i =0; i<customerAccounts.size();i++){
            Account acct = customerAccounts.get(i);
            if(acct instanceof CheckingAccount) {
                acct.deposit(250.25,"ATM Deposit");
                acct.withdraw(100.75,"ATM Withdraw");
                acct.deposit(60.24,"Money Transfer");
            }
        }
        //populate Credential, usually have its own system. This is just for testing
        Credential user1 = new Credential("Yaz", "5678", "Customer", customer1);
        Credential user2 = new Credential("Ihab", "1234", "Customer", customer2);
        Credential user3 = new Credential("Ana", "0000", "Customer", customer3);
        Credential user4 = new Credential("Admin", "9999", "Branch", branch1);
        Credential user5 = new Credential("Superadmin", "1212", "HeadOffice", headOffice);
        allCredential.add(user1);
        allCredential.add(user2);
        allCredential.add(user3);
        allCredential.add(user4);
        allCredential.add(user5);

    }

    public Credential login(String username, String password){
        for(int i=0; i<allCredential.size();i++){
            Credential existingCredential =allCredential.get(i);
            if(existingCredential.getUsername().equalsIgnoreCase(username) && existingCredential.getPassword().equals(password)){
                return existingCredential;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception{

      /* File branchFile = new File("branches.obj");
       boolean branchFileExist = false;
       if(branchFile.exists()){
           branchFileExist = true;
       }

       ArrayList<Branch> existingBranches = new ArrayList<Branch>();
       if(branchFileExist){
           FileInputStream fis_existingFile = new FileInputStream("branches.obj");
           ObjectInputStream ois_existingFile  = new ObjectInputStream(fis_existingFile);

           while(fis_existingFile.available()!=0){
               Object obj = ois_existingFile.readObject();
               Branch b1 = (Branch)obj;
               existingBranches.add(b1);
           }
           ois_existingFile.close();
           fis_existingFile.close();
       }
*/
        FileOutputStream fos = new FileOutputStream("branches.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
/*
        for(int i =0; i<existingBranches.size(); i++){
            oos.writeObject(existingBranches.get(i));
        }
*/
        BankHeadOffice headOffice = BankHeadOffice.getBankHeadOffice();
        Branch branch1 = new Branch(1,"Square One",1255,"Mississauga Road","J2k 3U4","Mississauga","ON","Canada");
        Branch branch2 = new Branch(2,"Mackenzie",5699,"Mackenzie Road","K8C5I6","Markham","ON","Canada");

        oos.writeObject(branch1);
        oos.writeObject(branch2);
        oos.close();
        fos.close();

       /* System.out.println("Reading objects from file .....");
        FileInputStream fis = new FileInputStream("branches.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);

        while(fis.available()!=0){
            Object obj = ois.readObject();
            Branch b1 = (Branch)obj;
            System.out.println(b1.getBranchName());
        }
        ois.close();
        fis.close();
*/
        FileOutputStream customer_fos = new FileOutputStream("customers.obj");
        ObjectOutputStream customer_oos = new ObjectOutputStream(fos);

        Customer customer1 = new Customer(100,"Yaz",5544,"Mackenzie Road","K8C5I8","Markham","ON","Canada");
        Customer customer2 = new Customer(200,"Ihab",6666,"Mississauga Road","J2k 3U2","Mississauga","ON","Canada");
        Customer customer3 = new Customer(300,"Ana");

        customer_oos.writeObject(customer1);
        customer_oos.writeObject(customer2);
        customer_oos.writeObject(customer3);
        customer_fos.close();
        customer_oos.close();

        FileOutputStream account_fos = new FileOutputStream("account.obj");
        ObjectOutputStream account_oos = new ObjectOutputStream(fos);

        branch1.addAccount(new CheckingAccount(30.0f,4000.0f,0,20201,customer1.getCustomerName() +" Checking Account",customer1 ));


        //Account acct1 = new CheckingAccount(30.0f,4000.0f,0,20201,customer1.getCustomerName() +" Checking Account",customer1 );
        Account acct2 = new SavingAccount(100.0f,0.025f,30301,customer1.getCustomerName()+" Saving Account", 1000.0, customer1, branch1);
        Account acct3 = new CheckingAccount(30.0f,4000.0f,0,20202,customer2.getCustomerName() +" Checking Account",0.0,customer2, branch1 );
        Account acct4 = new CheckingAccount(30.0f,4000.0f,0,20203,customer3.getCustomerName() +" Checking Account",3000.0,customer3, branch2 );

        ArrayList<Account> branch1_accounts = branch1.getBranchAccounts();
        for(int i=0;i<branch1_accounts.size();i++){
            Account acct = branch1_accounts.get(i);
            if(acct.getCustomer().getCustomerID() == customer1.getCustomerID() && (acct instanceof CheckingAccount) ){
                account_oos.writeObject(acct);
                break;
            }
        }
        account_oos.writeObject(acct2);
        account_oos.writeObject(acct3);
        account_oos.writeObject(acct4);
        account_fos.close();
        account_oos.close();

        FileOutputStream credential_fos = new FileOutputStream("credential.obj");
        ObjectOutputStream credential_oos = new ObjectOutputStream(fos);

        //populate Credential, usually have its own system. This is just for testing
        Credential user1 = new Credential("Yaz", "5678", "Customer", customer1);
        Credential user2 = new Credential("Ihab", "1234", "Customer", customer2);
        Credential user3 = new Credential("Ana", "0000", "Customer", customer3);
        Credential user4 = new Credential("Admin", "9999", "Branch", branch1);
        Credential user5 = new Credential("Superadmin", "1212", "HeadOffice", headOffice);



       /* DataLoader dl = new DataLoader();
        dl.allCredential.add(user1);
        dl.allCredential.add(user2);
        dl.allCredential.add(user3);
        dl.allCredential.add(user4);
        dl.allCredential.add(user5);
*/

        /*
        Transaction trans1 = new Transaction("1", 250.25, "deposit", "ATM Deposit", new Date());
        Transaction trans2 = new Transaction("2", 100.75, "withdraw", "ATM Withdrawal", new Date());
        Transaction trans3 = new Transaction("3", 60.24, "deposit", "ATM Deposit", new Date());
        */

        ArrayList<Account> customerAccounts = customer1.getCustomerAccounts();
        for(int i =0; i<customerAccounts.size();i++){
            Account acct = customerAccounts.get(i);
            if(acct instanceof CheckingAccount) {
                acct.deposit(250.25,"ATM Deposit");
                acct.withdraw(100.75,"ATM Withdraw");
                acct.deposit(60.24,"Money Transfer");
            }
        }

        System.out.println(customer1.getCustomerName());
        //ArrayList<Account> = customer1.getCustomerAccounts();
        System.out.println("Customer Accounts: ");
        for(int i =0; i<customerAccounts.size();i++){
            Account acct = customerAccounts.get(i);
            if(acct instanceof CheckingAccount){
                System.out.println("Checking Account ....");
            }else if(acct instanceof SavingAccount){
                System.out.println("Saving Account ....");
            }
            System.out.println("Account #: " + acct.getAccountNumber());
            System.out.println("Balance: "+ acct.getAccountBalance());
            ArrayList<Transaction> transactions = acct.getAccountTransactions();
            for(int j=0; j< transactions.size(); j++){
                Transaction trans = transactions.get(j);
                System.out.println(trans);
            }
        }
    }
}
