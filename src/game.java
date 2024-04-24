import java.util.*;
import java.awt.*;

public class game {
    static int stickA1 = 1;
    static int stickA2 = 1;
    static int stickB1 = 1;
    static int stickB2 = 1;
    static String choice = "";
    static boolean finChoice;
    static GUI gui = new GUI();

    static boolean turn = true; // if true, it is player 1's turn, if false, it is player 2's turn
    static GUI GUI = new GUI();

    static Map<Integer, String> botChoice = new TreeMap<>();

    public static void initializeGame() {
        botChoice.put(1, "attack");
        botChoice.put(2, "switch");
        System.out.println("Sticks");
        updateInt();
    }

    static Scanner scan = new Scanner(System.in);

    // game will run while the value is true
    public static void runGame(boolean game) {
        
        while (game) {
            System.out.println("PLAYER 1:" + stickA1 + " " + stickA2 + "\nPLAYER 2:" + stickB1 + " " + stickB2);

            System.out.println(turn == true ? "PLAYER 1: What do want to do?" : "PLAYER 2: What do want to do?");

            // robot choice
            choice = botChoice.get((int) Math.random() * 3 + 1);

            // make variables in action listeners for the exit buttons for switch and attack
            while (turn == true && GUI.finChoice == false) {
                // choice = GUI.choiceStr;
                // GUI.finChoiceCheck(choice);
                // System.out.println(choice);
                if(!(GUI.choiceStr.equals(""))){
                    GUI.finChoice = true;
                }
            }
            
            switch (choice) {
                case "attack":
                    if (turn == true) {
                        addStick(stickA1, stickA2, stickB1, stickB2);
                    } else {
                        addStick(stickB1, stickB2, stickA1, stickA2);
                    }
                    break;
                case "switch":
                    if (turn == true) {
                        switchStick(stickA1, stickA2);
                    } else {
                        switchStick(stickB1, stickB2);
                    }
                    break;
            }
            turn = !turn;

        }
    }

    // add stick values together, if one hand equals 5, you lose that hand
    public static void addStick(int a1, int a2, int b1, int b2) {
        Scanner scan = new Scanner(System.in);
        String hand = "";
        String attack = "";
        Map<Integer, String> leftOrRight = new TreeMap<>();
        leftOrRight.put(1, "left");
        leftOrRight.put(2, "right");

        System.out.println("With what hand? (left/right)");
        if (turn == true) {
            hand = gui.handP;
        } else {
            hand = leftOrRight.get((int) Math.random() * 3 + 1);
        }
        System.out.println("To whom? (left/right)");
        if (turn == true) {
            attack = gui.handE;
        } else {
            attack = leftOrRight.get((int) Math.random() * 3 + 1);
            System.out.println(attack);
        }
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
        if (turn == true) {
            if (attack.equals("left")) {
                stickB1 = s2;
            } else {
                stickB2 = s2;
            }
        }
        if (turn == false) {
            if (attack.equals("left")) {
                stickA1 = s2;
            } else {
                stickA2 = s2;
            }
        }
        updateInt();
    }

    // Switch stick values for the hand
    public static void switchStick(int left, int right) {
        int total = left + right;
        int leftAmount;
        int rightAmount;
        Scanner scan = new Scanner(System.in);
        Map<Integer, String> leftOrRight = new TreeMap<>();
        leftOrRight.put(1, "left");
        leftOrRight.put(2, "right");
        System.out.println("How much do you want to put on your left hand?");
        if (turn == true) {
            leftAmount = scan.nextInt();
        } else {
            leftAmount = ((int) Math.random() * 6);
        }
        if (total - left > 0) {
            total -= left;
        }
        System.out.println("How much do you want to put on your right hand?");
        if (turn == true) {
            rightAmount = scan.nextInt();
        } else {
            rightAmount = ((int) Math.random() * 6);
        }
        if (total - right > 0) {
            total -= right;
        }
        updateInt();
    }

    public static void updateInt() {
        GUI.leftHandPNum = stickA1;
        GUI.rightHandPNum = stickA2;
        GUI.leftHandENum = stickB1;
        GUI.rightHandENum = stickB2;
    }
}
