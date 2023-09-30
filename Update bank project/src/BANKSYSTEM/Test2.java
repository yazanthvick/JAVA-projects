package BANKSYSTEM;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("Welcome to Java");

        BankHeadOffice headOffice = BankHeadOffice.getBankHeadOffice();
        System.out.println(headOffice.getBankName());

        Branch b = new Branch(1,"LOLO");
        Branch be = new Branch(3,"lolol");

        //Account a = new Account(1,"yuh",40.00, b);
        //Account aa = new Account(6,"lol",50,b);

        String myStr1 = "HELLO";
        String myStr2 = "HELLO";
        System.out.println(myStr1.compareToIgnoreCase(myStr2));
    }
}
