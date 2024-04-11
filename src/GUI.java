import javax.swing.*;
import java.awt.event.*;;

public class GUI{
    JFrame mainScreen;
    JFrame switchScreen;
    JFrame attackScreen;
    JButton attack;
    JButton switchHands;
    JTextField leftHand;
    JTextField rightHand;
    public GUI(){
    //attack
    attack = new JButton("attack");
    attack.setBounds(50,100,100, 40); 
    attack.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
          attackScreen.setVisible(true);
          mainScreen.setVisible(false);
        } 
      } );
    
    //switchHands
    switchHands = new JButton("switch");
    switchHands.setBounds(200,100,100, 40);
    
    
    switchHands.setVisible(true);
    switchHands.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
          switchScreen.setVisible(true);
          mainScreen.setVisible(false);
          leftHand.setVisible(true);
          rightHand.setVisible(true);
        } 
      } );
    //mainScreen
    mainScreen = new JFrame("What Will You Do?");
    mainScreen.setSize(600,600);
    mainScreen.setVisible(true);
    mainScreen.setLayout(null);
    

    mainScreen.add(switchHands);
    //switchScreen
    
    switchScreen = new JFrame("What values will you give your hands?");
    switchScreen.setSize(400,200);
    switchScreen.setVisible(false);
    switchScreen.setLayout(null);
    leftHand = new JTextField();
    rightHand = new JTextField();
    leftHand.setBounds(10,10,100,20);
    rightHand.setBounds(10,50,100,20);
    leftHand.setVisible(false);
    rightHand.setVisible(false);
    
    

    //attackScreen
    attackScreen = new JFrame("Choose your attack");
    attackScreen.setSize(400,200);
    attackScreen.setVisible(false);
    attackScreen.setLayout(null);

    
    } 
    
    
      
} 

