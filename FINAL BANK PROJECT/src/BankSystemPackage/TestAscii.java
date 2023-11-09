package BankSystemPackage;

import java.util.Scanner;

public class TestAscii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a charachter:");
        String s = sc.next();

        char c = s.charAt(0);
        System.out.println("Ascii code: "+ (byte)c);
        byte asc = (byte)c;
        if(asc >=97 && asc <=122){
            System.out.println("small caps letter");
        }
        //97
        //00000097
        //characthers range from 65 to 90 AND 97 to 122
        // numbers 48 to 57



    }
}
