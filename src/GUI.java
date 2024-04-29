
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GUI {
  // mainScreen
  static JFrame mainScreen;
  static JFrame switchScreen;
  static JFrame attackScreen;
  JButton attack;
  JButton switchHands;
  static JLabel handCountP;
  static JLabel handCountE;
  static String choiceStr;
  static boolean finChoice = false;
  // switchScreen
  JTextField leftHand;
  JTextField rightHand;
  JButton exitSwitchScreen;
  static JLabel handCountPsw;
  static JLabel handCountEsw;
  int leftNum;
  int rightNum;
  // attackscreen
  static JLabel yourHand;
  static JLabel enemyHand;
  JButton yHL;
  JButton yHR;
  JButton eHL;
  JButton eHR;
  JButton exitAttackScreen;
  String handP;
  String handE;
  // enemy move screen
  static JLabel enemyMoveLabel;
  static JFrame enemyMoveFrame;
  JButton enemyMoveButton;
  JButton exitEnemyMoveScreen;
  // win screen
  static JFrame winFrame;
  JLabel winLabel;
  static Map<String,Integer> handValues = new TreeMap<>();
    public GUI(){
   //mainScreen
    mainScreen = new JFrame("What Will You Do?");
    mainScreen.setSize(600, 600);
    mainScreen.setVisible(true);
    mainScreen.setLayout(null);

    handCountP = new JLabel("PLAYER- L: " + game.stickA1 + " R: " + game.stickA2);
    handCountE = new JLabel("ENEMY- L: " + game.stickB1 + " R:" + game.stickB2);
    handCountP.setBounds(300, 50, 200, 50);
    handCountE.setBounds(300, 100, 200, 50);

    // switch to attack screen
    attack = new JButton("attack");
    attack.setBounds(250, 500, 100, 50);
    attack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        attackScreen.setVisible(true);
        mainScreen.setVisible(false);
      }
    });

    // switch to switchScreen
    switchHands = new JButton("switch");
    switchHands.setBounds(350, 500, 100, 50);
    switchHands.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        switchScreen.setVisible(true);
        mainScreen.setVisible(false);
      }
    });
    mainScreen.add(switchHands);
    mainScreen.add(attack);
    mainScreen.add(handCountP);
    mainScreen.add(handCountE);

    // switchScreen

    switchScreen = new JFrame("What values will you give your hands?");
    switchScreen.setSize(400, 200);
    switchScreen.setVisible(false);
    switchScreen.setLayout(null);
    exitSwitchScreen = new JButton("OK");
    leftHand = new JTextField();
    rightHand = new JTextField();
    exitSwitchScreen.setBounds(300, 150, 50, 50);
    leftHand.setBounds(10, 50, 100, 30);
    rightHand.setBounds(10, 100, 100, 30);
    switchScreen.add(exitSwitchScreen);
    switchScreen.add(leftHand);
    switchScreen.add(rightHand);
    handCountPsw = new JLabel("L: " + game.stickA1);
    handCountEsw = new JLabel("R: " + game.stickA2);
    handCountPsw.setBounds(50, 10, 200, 50);
    handCountEsw.setBounds(50, 60, 200, 50);
    switchScreen.add(handCountPsw);
    switchScreen.add(handCountEsw);
    exitSwitchScreen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        leftNum = Integer.valueOf(leftHand.getText());
        rightNum = Integer.valueOf(rightHand.getText());
        if(game.playerSwitchCheck(leftNum, rightNum) == true){
        game.playerSwitchStick(leftNum, rightNum);
        updateJLabel();
        enemyMoveFrame.setVisible(true);
        switchScreen.setVisible(false);
        }
      }
    });

    // attackScreen

    attackScreen = new JFrame("Choose your attack");
    attackScreen.setSize(400, 200);
    attackScreen.setVisible(false);
    attackScreen.setLayout(null);

    // Buttons in attackScreen

    handP = "left";
    handE = "left";
    handValues.put("PLAYER",game.stickA1);
    handValues.put("ENEMY",game.stickB1);
    yHL = new JButton("Left");
    yHR = new JButton("Right");
    eHL = new JButton("Left");
    eHR = new JButton("Right");
    exitAttackScreen = new JButton("OK");

    yHL.setBounds(100, 50, 100, 30);
    yHR.setBounds(200, 50, 100, 30);
    eHL.setBounds(100, 100, 100, 30);
    eHR.setBounds(200, 100, 100, 30);
    exitAttackScreen.setBounds(310, 135, 75, 30);

    yourHand = new JLabel("PLAYER- L: " + game.stickA1 + " R: " + game.stickA2);
    enemyHand = new JLabel("ENEMY- L: " + game.stickB1 + " R:" + game.stickB2);
    yourHand.setBounds(25,50,100,50);
    enemyHand.setBounds(25,100,100,50); 

    attackScreen.add(yourHand);
    attackScreen.add(enemyHand);
    attackScreen.add(yHL);
    attackScreen.add(yHR);
    attackScreen.add(eHL);
    attackScreen.add(eHR);
    attackScreen.add(exitAttackScreen);
    yHL.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handValues.put("PLAYER",game.stickA1);
      }
    });
    yHR.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handValues.put("PLAYER",game.stickA2);
      }
    });
    eHL.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handValues.put("ENEMY",game.stickB1);
        handE = "left";
      }
    });
    eHR.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handValues.put("ENEMY",game.stickB2);
        handE = "right";
      }
    });
    exitAttackScreen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(handE.equals("left")){
          game.stickB1 = game.playerAttack(handValues.get("PLAYER"), handValues.get("ENEMY"));
        }
        else{
          game.stickB2 = game.playerAttack(handValues.get("PLAYER"), handValues.get("ENEMY"));
        }
        enemyMoveFrame.setVisible(true);
        attackScreen.setVisible(false);
        displayWinScreen();
      }
    });
    
      //enemy move screen  
      enemyMoveFrame = new JFrame("ENEMY'S TURN");
      enemyMoveFrame.setSize(400, 200);
      enemyMoveFrame.setVisible(false);
      enemyMoveFrame.setLayout(null);

      enemyMoveLabel = new JLabel("It's now the Enemy's turn.");
      enemyMoveLabel.setBounds(25,-50,300,150);

      enemyMoveButton = new JButton("OK");
      enemyMoveButton.setBounds(200,15, 60, 20);
      exitEnemyMoveScreen = new JButton("Ok");
      exitEnemyMoveScreen.setBounds(310, 135, 75, 30);
      exitEnemyMoveScreen.setVisible(false);

      enemyMoveFrame.add(enemyMoveLabel);
      enemyMoveFrame.add(enemyMoveButton);
      enemyMoveFrame.add(exitEnemyMoveScreen);
      enemyMoveButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          enemyMoveButton.setVisible(false);
          exitEnemyMoveScreen.setVisible(true);
          game.bogoChoice();
          enemyMoveLabel.setText(game.choice.equals("attack") ? "The Enemy chose to attack one of your hands!" : "The enemy chose to switch their hands!");
        }
      });
      exitEnemyMoveScreen.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          exitEnemyMoveScreen.setVisible(false);
          enemyMoveButton.setVisible(true);
          enemyMoveFrame.setVisible(false);
          mainScreen.setVisible(true);
          displayWinScreen();
          updateJLabel();
        }
      });
      //win screen
      winFrame = new JFrame("RESULTS");
      winFrame.setSize(400, 200);
      winFrame.setVisible(false);
      winFrame.setLayout(null);

      winLabel = new JLabel((game.stickA1 + game.stickA2 == 0) ? "The BOGO Algorithm Wins!" : "The player wins!");
      winLabel.setBounds(25,-50,300,150);

      winFrame.add(winLabel);
  }
    //update labels in mainScreen -- doesn't work for some reason 
    public static void updateJLabel(){
      handCountP.setText("PLAYER- L: " + game.stickA1 + " R: " + game.stickA2);
      handCountE.setText("ENEMY- L: " + game.stickB1 + " R:" + game.stickB2);
      yourHand.setText("PLAYER- L: " + game.stickA1 + " R: " + game.stickA2);
      enemyHand.setText("ENEMY- L: " + game.stickB1 + " R:" + game.stickB2);
      handCountPsw.setText("L: " + game.stickA1);
      handCountEsw.setText("R: " + game.stickA2);
      enemyMoveLabel.setText("It's now the Enemy's turn."); 
    }
    public static void displayWinScreen(){
      if(game.winCheck() == true){
        mainScreen.setVisible(false);
        attackScreen.setVisible(false);
        switchScreen.setVisible(false);
        enemyMoveFrame.setVisible(false);
        winFrame.setVisible(true);
      }
    }

}


