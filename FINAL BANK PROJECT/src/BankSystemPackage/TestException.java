package BankSystemPackage;


import java.io.IOException;
import java.lang.module.FindException;

public class TestException {

    public void fun1() throws IOException{
        System.out.println("Begin Fun1");
        try {
            fun2();
        }catch(IOException ioe){
            System.out.println("We handle IO Exception ... But we are not done yet...");
            throw ioe;
        }catch(Exception e){
            System.out.println("Exception handlened in Fun1");
        }
        System.out.println("End Fun1");

    }

    public void fun2() throws IOException{
        System.out.println("Begin Fun2");
        try {
            fun3();
        }catch(FindException e){
            System.out.println(e.getMessage()+ " .... never mind");
        }catch(RuntimeException rte){
            System.out.println("Runtime Exception handled");
        }
        System.out.println("End Fun2");
    }


    public void fun3() throws IOException{
        System.out.println("Begin Fun3");
        RuntimeException rte = new RuntimeException("Oh you got a problem");
        IOException ioe = new IOException("Some input output exception");
        throw ioe;

       // System.out.println("End Fun3");
    }
    public static void main(String[] args) {
        TestException obj = new TestException();
        try{
            obj.fun1();
        }catch(Exception e){
            System.out.println("Handle it in the main....");
        }
    }
}
