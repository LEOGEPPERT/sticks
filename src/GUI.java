
import javax.swing.*;
import java.awt.event.*;

public class GUI {
  // mainScreen
  JFrame mainScreen;
  JFrame switchScreen;
  JFrame attackScreen;
  JButton attack;
  JButton switchHands;
  JLabel handCountP;
  JLabel handCountE;
  static int leftHandPNum;
  static int rightHandPNum;
  static int leftHandENum;
  static int rightHandENum;
  static String choiceStr;
  static boolean finChoice = false;
  // switchScreen
  JTextField leftHand;
  JTextField rightHand;
  JButton exitSwitchScreen;
  JLabel handCountPsw;
  JLabel handCountEsw;
  int leftNum;
  int rightNum;
  // attackscreen
  JLabel yourHand;
  JLabel enemyHand;
  JButton yHL;
  JButton yHR;
  JButton eHL;
  JButton eHR;
  JButton exitAttackScreen;
  String handP;
  String handE;
    public GUI(){
      leftHandPNum = 1;
      rightHandPNum = 1;
      leftHandENum = 1;
      rightHandENum = 1;
   //mainScreen
    mainScreen = new JFrame("What Will You Do?");
    mainScreen.setSize(600, 600);
    mainScreen.setVisible(true);
    mainScreen.setLayout(null);

    handCountP = new JLabel("PLAYER- L: " + leftHandPNum + " R: " + rightHandPNum);
    handCountE = new JLabel("ENEMY- L: " + leftHandENum + " R:" + rightHandENum);
    handCountP.setBounds(300, 50, 200, 50);
    handCountE.setBounds(300, 100, 200, 50);

    // switch to attack screen
    attack = new JButton("attack");
    attack.setBounds(250, 500, 100, 50);
    attack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        attackScreen.setVisible(true);
        mainScreen.setVisible(false);
        choiceStr = "attack";
        finChoice = true;
      }
    });

    // switch to switchScreen
    switchHands = new JButton("switch");
    switchHands.setBounds(350, 500, 100, 50);
    switchHands.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        switchScreen.setVisible(true);
        mainScreen.setVisible(false);
        choiceStr = "switch";
        finChoice = true;
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
    handCountPsw = new JLabel("L: " + leftHandPNum);
    handCountEsw = new JLabel("R: " + rightHandPNum);
    handCountPsw.setBounds(50, 10, 200, 50);
    handCountEsw.setBounds(50, 60, 200, 50);
    switchScreen.add(handCountPsw);
    switchScreen.add(handCountEsw);
    exitSwitchScreen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        leftNum = Integer.valueOf(leftHand.getText());
        rightNum = Integer.valueOf(rightHand.getText());
        mainScreen.setVisible(true);
        switchScreen.setVisible(false);
        finChoice = false;
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
    yHL = new JButton("Left");
    yHR = new JButton("Right");
    eHL = new JButton("Left");
    eHR = new JButton("Right");
    exitAttackScreen = new JButton("OK");
    yHL.setBounds(100, 50, 50, 25);
    yHR.setBounds(200, 50, 50, 25);
    eHL.setBounds(100, 100, 50, 25);
    eHR.setBounds(200, 100, 50, 25);
    exitAttackScreen.setBounds(300, 150, 50, 25);
    attackScreen.add(yHL);
    attackScreen.add(yHR);
    attackScreen.add(eHL);
    attackScreen.add(eHR);
    attackScreen.add(exitAttackScreen);
    yHL.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handP = "left";
      }
    });
    yHR.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handP = "right";
      }
    });
    eHL.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handE = "left";
      }
    });
    eHR.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handE = "right";
      }
    });
    exitAttackScreen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        mainScreen.setVisible(true);
        attackScreen.setVisible(false);
        finChoice = false;
      }
    });
    
      
  }

}
  

