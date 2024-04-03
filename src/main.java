import java.util.*;
import java.awt.*;
public class main {
        static int stickA1 = 1;
        static int stickA2 = 1;
        static int stickB1 = 1;
        static int stickB2 = 1;
        static boolean turn = true; //if true, it is player 1's turn, if false, it is player 2's turn
    public static void main(String[] args) throws Exception {
        boolean game = true;
        Map<Integer, String> botChoice = new TreeMap<>();
        botChoice.put(1, "attack");
        botChoice.put(2, "switch");
        
        

        System.out.println("Sticks");
        Scanner scan = new Scanner(System.in);
        //game will run while the value is true
        while(game){
        System.out.println("PLAYER 1:" + stickA1 + " " + stickA2 + "\nPLAYER 2:" + stickB1 + " " + stickB2);
        
        System.out.println(turn == true ? "PLAYER 1: What do want to do?" : "PLAYER 2: What do want to do?");
         
            //robot choice
          String choice = botChoice.get((int)Math.random()*3 + 1);
        
        if(turn == true){
         choice = scan.nextLine();
        }
        switch(choice){
            case "attack":
                if(turn == true){addStick(stickA1,stickA2,stickB1,stickB2);}
                else{addStick(stickB1,stickB2,stickA1,stickA2);}
                break;
            case "switch":
                if(turn == true){switchStick(stickA1, stickA2);}
                else{switchStick(stickB1,stickB2);}
                break;
        }
        turn = !turn;
        

    }
}
    //add stick values together, if one hand equals 5, you lose that hand
    public static void addStick(int a1, int a2, int b1, int b2){
            Scanner scan = new Scanner(System.in);
            String hand = "";
            String attack = "";
            Map<Integer, String> leftOrRight = new TreeMap<>();
                leftOrRight.put(1, "left");
                leftOrRight.put(2, "right");
            
            System.out.println("With what hand? (left/right)");//if left, then put a1 into addStick method
            if(turn == true){
             hand = scan.nextLine();}
            else{
                hand = leftOrRight.get((int)Math.random()*3 + 1);
            }
            System.out.println("To whom? (left/right)");
            if(turn == true){ attack = scan.nextLine();
            }
            else{
                attack = leftOrRight.get((int)Math.random()*3 + 1);
            }
            int s1 = hand.equals("left") ? a1 : a2;
            int s2 = attack.equals("left") ? b1 : b2;
        s2 +=s1;
        if(s2 == 5){
            s2 = 0;
        }                                                                                                                                                                                                                                      
    }
    //Switch stick values for the hand, make sure to later add that you cant just infinitely switch around the same two values
    public static void switchStick(int left, int right){
        int total = left + right;
        int leftAmount;
        int rightAmount;
        Scanner scan = new Scanner(System.in);
        Map<Integer, String> leftOrRight = new TreeMap<>();
        leftOrRight.put(1, "left");
        leftOrRight.put(2, "right");
        System.out.println("How much do you want to put on your left hand?");
        if(turn == true){leftAmount = scan.nextInt();}
        else{leftAmount = ((int)Math.random()*6);}
        if(total - left > 0){
            total -= left;
        }
        System.out.println("How much do you want to put on your right hand?");
        if(turn == true){rightAmount = scan.nextInt();}
        else{rightAmount = ((int)Math.random()*6);}
        if(total - right > 0){
            total -= right;
        }
    }
}
