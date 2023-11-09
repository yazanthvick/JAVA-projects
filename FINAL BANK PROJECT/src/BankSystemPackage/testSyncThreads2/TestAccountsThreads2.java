package BankSystemPackage.testSyncThreads2;

import java.util.ArrayList;

public class TestAccountsThreads2 {

    public static void main(String[] args) {
        MyAccount acct1 = new MyAccount(100);
        acct1.name = "Account1 ";
        MyAccount acct2 = new MyAccount(100);
        acct2.name = "Account2 ";
        ArrayList<Person1> person1s = new ArrayList<Person1>();
        ArrayList<Person2> person2s = new ArrayList<Person2>();
        for(int i =0; i<10; i++){
            person1s.add(new Person1(acct1,1,10));
            person2s.add(new Person2(acct2,0,5));
        }
        for(int i =0; i<10; i++){
            person1s.get(i).start();
            person2s.get(i).start();
        }


    }
}
