package BankSystemPackage.testThreads;

public class MyThread2 implements Runnable{

    public void run(){
        for(int i=1; i<=5;i++){
            System.out.println("MyThread2 : "+ i);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
