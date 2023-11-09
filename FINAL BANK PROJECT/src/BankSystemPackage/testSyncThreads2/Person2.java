package BankSystemPackage.testSyncThreads2;

public class Person2 extends Thread{
    MyAccount acct;
    int op;
    int value;

    public Person2(MyAccount acct, int op, int value){
        this.acct = acct;
        this.op = op;
        this.value =value;
    }
    public void run(){
        acct.operation(op,value);
    }
}
