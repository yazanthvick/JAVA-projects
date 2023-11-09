package BankSystemPackage;

import java.util.Date;


public class TestClass {

    public static void main(String[] args) {
        /*Address addr = new Address(1010,"Bloor St","L2A4T7","Mississauga","ON","Canada");
        String postalCode= "L5A 3Y4";
        int index = postalCode.indexOf(" ");
        if( index != -1){
            postalCode = postalCode.replace(" ","");
        }

        System.out.println(postalCode);


        BankHeadOffice headOffice =  BankHeadOffice.getBankHeadOffice();
        System.out.println(headOffice.getBankName());

        Branch branch1 = new Branch(1,"Mississauga Branch");
        System.out.println(branch1);
        Branch branch2 = null;
        try {
             branch2 = new Branch(1, "Markham Branch");
        }catch(Exception e){

        }
        System.out.println(branch2);
        // another class
        //BankHeadOffice.headOffice = null;
*/
        Date date = new Date();

        System.out.println(date.getTime());
        System.out.println(date.toString());
    }
}
