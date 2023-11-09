package BankSystemPackage.testSyncThreads;

public class Dataset {

    public synchronized void print(int x){
        for(int i=1; i<=5;i++){
            System.out.println(i*x);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
