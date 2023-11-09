package BankSystemPackage.testSyncThreads;

public class MyThread extends Thread{
    Dataset ds;
    int value;

    public MyThread(Dataset ds, int value){
        this.ds = ds;
        this.value = value;
    }

    public void run(){
        ds.print(value);
    }
}
