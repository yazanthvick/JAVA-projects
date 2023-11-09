package BankSystemPackage.testSyncThreads2;

public class Person1 extends Thread{
    MyAccount acct;
    int op;
    int value;

    public Person1(MyAccount acct, int op, int value){
        this.acct = acct;
        this.op = op;
        this.value =value;
    }
    public void run(){
        acct.operation(op,value);
    }
}
