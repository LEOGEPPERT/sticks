import java.util.*;


public class game {
    static int stickA1 = 1;
    static int stickA2 = 1;
    static int stickB1 = 1;
    static int stickB2 = 1;
    static String choice = "";
    static boolean finChoice;
    static GUI gui = new GUI();

    static boolean turn = true; 
    static GUI GUI = new GUI();

    static Map<Integer, String> botChoice = new TreeMap<>();
    
    public static void initializeGame() {
        botChoice.put(1, "attack");
        botChoice.put(2, "switch");
        System.out.println("Sticks");
       
    }

    static Scanner scan = new Scanner(System.in);

    //Choice selection for BOGO algorithm
    public static void bogoChoice() {
            choice = botChoice.get((Math.random() <= 0.5) ? 1 : 2);
            switch (choice) {
                case "attack":
                        bogoAddStick(stickB1, stickB2, stickA1, stickA2);
                    break;
                case "switch":
                        bogoSwitchStick(stickB1, stickB2);
                    break;
                }
            }
        
    

    //Attack for BOGO algorithm
    public static void bogoAddStick(int a1, int a2, int b1, int b2) {
        String hand = "";
        String attack = "";
        Map<Integer, String> leftOrRight = new TreeMap<>();
        leftOrRight.put(1, "left");
        leftOrRight.put(2, "right");

        System.out.println("With what hand? (left/right)");  
            hand = leftOrRight.get((Math.random() <= 0.5) ? 1 : 2);
        
        System.out.println("To whom? (left/right)");
        attack = leftOrRight.get((Math.random() <= 0.5) ? 1 : 2);
        System.out.println(attack);
        int s1 = hand.equals("left") ? a1 : a2;
        int s2 = attack.equals("left") ? b1 : b2;
        s2 += s1;
        for (int i = 0; i < s2; i++) {
            if (i == 5 && i == s2) {
                s2 = 0;
            }
            if (i > 5 && i == s2) {
                s2 %= 5;
            }
        }
            if (attack.equals("left")) {
                stickA1 = s2;
            } else {
                stickA2 = s2;
            }
        
        
    }
    //Attack for player
    public static int playerAttack(int player, int enemy){
        
                enemy = (player+enemy) % 5;       
        
        return enemy;
    }
    
    //Stick Switch for BOGO algorithm
    public static void bogoSwitchStick(int left, int right) {
        int total = left + right;
         int leftAmount;
         
         int smallest;
        
        smallest = Math.min(4,total);
        System.out.println("How much do you want to put on your left hand?");
            leftAmount = ((int) Math.random() * smallest+1);  
            total -= leftAmount;
            left = leftAmount;
            right = total;
        
        }
        
    
    //Stick Switch for player
    public static void playerSwitchStick(int left, int right){
        stickA1 = left;
        stickA2 = right;
    }
    public static boolean playerSwitchCheck(int left, int right){
        if((stickA1 + stickA2) == (left + right)){
            return true;
        }
        else{
        return false;
        }
    }
    public static boolean winCheck(){
        if((stickA1 + stickA2) == 0 || (stickB1 + stickB2) == 0){
            return true;
        }
        return false;
    }
}
