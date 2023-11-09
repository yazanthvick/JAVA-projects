package BankSystemPackage;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class DataLoader { // this class will be converted to interactive data access layer in the future
   ArrayList<Credential> allCredential = new ArrayList<Credential>();
   ArrayList<Branch> allBranches = new ArrayList<Branch>();
   ArrayList<Customer> allCustomers = new ArrayList<Customer>();
   ArrayList<Account> allAccounts = new ArrayList<Account>();
   ArrayList<Transaction> allTransactions = new ArrayList<Transaction>();

   public DataLoader(){
    try {


        BankHeadOffice headOffice = BankHeadOffice.getBankHeadOffice();
        //Loading branches from data source
        FileInputStream fis = new FileInputStream("branches.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);

        while (fis.available() != 0) {
            Object obj = ois.readObject();
            Branch b1 = (Branch) obj;
            allBranches.add(b1);
        }
        ois.close();
        fis.close();
        System.out.println(allBranches.size());


        //Loading Customers from Data source
        FileInputStream customer_fis = new FileInputStream("customers.obj");
        ObjectInputStream customer_ois = new ObjectInputStream(customer_fis);
        System.out.println("Reading Customer from file .....");
        while (customer_fis.available() != 0) {
            Object obj = customer_ois.readObject();
            Customer c = (Customer) obj;
            ArrayList<Account> act = c.getCustomerAccounts();
            System.out.println("Reading customer accounts ...");
            for(int i=0;i<act.size();i++){
                Account a = act.get(i);
                System.out.println("From File ... Balance = " + a.getAccountBalance());
            }
            allCustomers.add(c);
        }

        customer_ois.close();
        customer_fis.close();


        //Loading Accounts from Data source
        FileInputStream account_fis = new FileInputStream("accounts.obj");
        ObjectInputStream account_ois = new ObjectInputStream(account_fis);

        while (account_fis.available() != 0) {
            Object obj = account_ois.readObject();
            Account a = (Account) obj;
            allAccounts.add(a);
        }
        account_ois.close();
        account_fis.close();

        //Loading Transactions from Data source
        FileInputStream trans_fis = new FileInputStream("transactions.obj");
        ObjectInputStream trans_ois = new ObjectInputStream(trans_fis);

        while (trans_fis.available() != 0) {
            Object obj = trans_ois.readObject();
            Transaction t = (Transaction) obj;
            allTransactions.add(t);
        }
        trans_ois.close();
        trans_fis.close();

        //Loading Credential from Data source
        FileInputStream users_fis = new FileInputStream("users.obj");
        ObjectInputStream users_ois = new ObjectInputStream(users_fis);

        while (users_fis.available() != 0) {
            Object obj = users_ois.readObject();
            Credential cred = (Credential) obj;
            allCredential.add(cred);
        }
        users_ois.close();
        users_fis.close();

    }catch(Exception e){
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
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

        FileOutputStream customer_fos= new FileOutputStream("customers.obj");
        ObjectOutputStream customer_oos = new ObjectOutputStream(customer_fos);

        Customer customer1 = new Customer(100,"Yaz",5544,"Mackenzie Road","K8C5I8","Markham","ON","Canada");
        Customer customer2 = new Customer(200,"Ihab",6666,"Mississauga Road","J2k 3U2","Mississauga","ON","Canada");
        Customer customer3 = new Customer(300,"Ana");



        FileOutputStream acct_fos = new FileOutputStream("accounts.obj");
        ObjectOutputStream acct_oos= new ObjectOutputStream(acct_fos);

        branch1.addAccount(new CheckingAccount(30.0f,4000.0f,0,20201,customer1.getCustomerName() +" Checking Account",customer1 ));


        //Account acct1 = new CheckingAccount(30.0f,4000.0f,0,20201,customer1.getCustomerName() +" Checking Account",customer1 );
        Account acct2 = new SavingAccount(100.0f,0.025f,30301,customer1.getCustomerName()+" Saving Account", 1000.0, customer1, branch1);
        Account acct3 = new CheckingAccount(30.0f,4000.0f,0,20202,customer2.getCustomerName() +" Checking Account",0.0,customer2, branch1 );
        Account acct4 = new CheckingAccount(30.0f,4000.0f,0,20203,customer3.getCustomerName() +" Checking Account",3000.0,customer3, branch2 );



        FileOutputStream users_fos = new FileOutputStream("users.obj");
        ObjectOutputStream users_oos = new ObjectOutputStream(users_fos);
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

        FileOutputStream trans_fos = new FileOutputStream("transactions.obj");
        ObjectOutputStream trans_oos= new ObjectOutputStream(trans_fos);

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
                trans_oos.writeObject(trans);
            }
        }

        trans_oos.close();
         trans_fos.close();

        ArrayList<Account> branch1_accounts = branch1.getBranchAccounts();
        for(int i=0;i<branch1_accounts.size();i++){
            Account acct = branch1_accounts.get(i);
            if(acct.getCustomer().getCustomerID() == customer1.getCustomerID() && (acct instanceof CheckingAccount) ){
                acct_oos.writeObject(acct);
                System.out.println("Checking account balance ----> " + acct.getAccountBalance());
                break;
            }
        }
        acct_oos.writeObject(acct2);
        acct_oos.writeObject(acct3);
        acct_oos.writeObject(acct4);

        acct_oos.close();
        acct_fos.close();

        customer_oos.writeObject(customer1);
        customer_oos.writeObject(customer2);
        customer_oos.writeObject(customer3);

        customer_oos.close();
        customer_fos.close();

        oos.writeObject(branch1);
        oos.writeObject(branch2);
        oos.close();
        fos.close();

        users_oos.writeObject(user1);
        users_oos.writeObject(user2);
        users_oos.writeObject(user3);
        users_oos.writeObject(user4);
        users_oos.writeObject(user5);

        users_oos.close();
        users_fos.close();
    }
}
