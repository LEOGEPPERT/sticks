import java.util.*;
import java.awt.*;
public class main {
    public static void main(String[] args) throws Exception {
        boolean game = true;
        int stickA1 = 1;
        int stickA2 = 1;
        int stickB1 = 1;
        int stickB2 = 1;
        Map<Integer, String> botChoice = new TreeMap<>();
        botChoice.put(1, "attack");
        botChoice.put(2, "switch");
        
        System.out.println("Sticks");
        Scanner scan = new Scanner(System.in);
        //game will run while the value is true
        while(game){
        
        boolean turn = true; //if true, it is player 1's turn, if false, it is player 2's turn
        System.out.println(turn == true ? "PLAYER 1: What do want to do?" : "PLAYER 2: What do want to do?");
         
            //robot choice
          String choice = botChoice.get((int)Math.random()*3 + 1);
        
        if(turn == true){
         choice = scan.nextLine();
        }
        switch(choice){
            case "attack":

                addStick(1,2,32,1);
                break;
            case "switch":
                switchStick(stickA1, stickA2);
        }
        turn != turn;
        

    }
}
    //add stick values together, if one hand equals 5, you lose that hand
    public static void addStick(int a1, int a2, int b1, int b2){
        System.out.println("With what hand? (left/right)");//if left, then put a1 into addStick method
            Scanner scan = new Scanner(System.in);
            String hand = scan.nextLine();
            System.out.println("To whom? (left/right)");
            String attack = scan.nextLine();
            int s1 = hand.equals("left") ? a1 : a2;
            int s2 = hand.equals("left") ? b1 : b2;

        s2 +=s1;
        if(s2 == 5){
            s2 = 0;
        }
    }
    /* public static boolean checkStick(int s1, int s2){
        if(s1 > 5 || s2 > 5){
            return false;
        }
        return true;
    } */
    public static void player1Turn(){
        System.out.println("Player 1's turn:");
    }
    //Switch stick values for the hand, make sure to later add that you cant just infinitely switch around the same two values
    public static void switchStick(int left, int right){
        int total = left + right;
        Scanner scan = new Scanner(System.in);
        System.out.println("How much do you want to put on your left hand?");
        left = scan.nextInt();
        if(total - left > 0){
            total -= left;
        }
        System.out.println("How much do you want to put on your right hand?");
        right = scan.nextInt();
        if(total - right > 0){
            total -= right;
        }
    }
}
