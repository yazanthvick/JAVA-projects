package BankSystemPackage.testThreads;

public class MyThread1 extends Thread{

    public void run(){
        for(int i=1; i<=5;i++){
            System.out.println("MyThread1 : "+ i);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
}
