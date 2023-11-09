package BankSystemPackage.testThreads;

public class TestThreads {

    public static void main(String[] args) throws Exception{

        MyThread1 thread1 = new MyThread1();
        MyThread2 runnableObj = new MyThread2();
        Thread thread2 = new Thread(runnableObj);
        MyThread1 thread3 = new MyThread1();

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(1000);
        System.out.println("End of main thread");
    }
}
