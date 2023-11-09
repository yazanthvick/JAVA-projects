package BankSystemPackage.testSyncThreads2;

public class MyAccount {

    int balance;
    String name;

    public MyAccount(int balance){
        this.balance = balance;
    }

    public synchronized void operation(int op, int value){
       // int currentBalance = balance;
        try{
            Thread.sleep(1000);
            if(op ==1){
                balance = balance + value;
            }else{
                balance = balance - value;
            }
            //this.balance = currentBalance;
            System.out.println("Current Balance = "+ this.balance + " "+name);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
