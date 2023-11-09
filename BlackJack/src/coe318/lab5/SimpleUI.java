package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {   
         System.out.println("House Holds: \n===========" + this.game.getHouseCards().toString()); 
         System.out.println("You Hold: \n===========" + this.game.getYourCards().toString());
//FIX THIS
    }

  @Override
    public boolean hitMe() {
     
      String response;
        System.out.println("Do you want anotha one? Answer with either 'yes'or 'no'");
        response = user.nextLine();
        while(!(response.equals("yes") || response.equals("no"))){
         if(response.equals("yes")){
             return true;
         }
         else if(response.equals("no")){
         return false;
         }
         else{
           System.out.println("Please enter proper response (either 'yes' or 'no') "); 
           response = user.nextLine();
         }
        }
         return false;       
    }

  @Override
    public void gameOver() {
       display();
       int HouseScore, YourScore;
       HouseScore = this.game.score(this.game.getHouseCards());
       YourScore = this.game.score(this.game.getYourCards());
       System.out.println("HouseScore: " + HouseScore + "\n");
       System.out.println("YourScore: " + YourScore + "\n");
       if(YourScore < 21 && HouseScore > 21 || YourScore <= 21 && HouseScore <= 21 && YourScore > HouseScore){
           System.out.println("You WIN!");
       }
       else {
           System.out.println("House WINS!");
       }       
       System.out.println("Thank you for playing!");
    }
}
