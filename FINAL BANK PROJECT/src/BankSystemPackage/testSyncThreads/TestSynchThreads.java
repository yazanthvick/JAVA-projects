package BankSystemPackage.testSyncThreads;

public class TestSynchThreads {

    public static void main(String[] args) {
        Dataset ds = new Dataset();
        Dataset ds2 = new Dataset();
        MyThread t1 = new MyThread(ds,5);
        MyThread t2 = new MyThread(ds2,100);
        MyThread t3 = new MyThread(ds,1);
        MyThread t4 = new MyThread(ds2,1000);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
