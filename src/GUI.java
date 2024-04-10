import javax.swing.*;
import java.awt.event.*;;

public class GUI{
    JFrame mainScreen;
    JFrame switchScreen;
    JFrame attackScreen;
    JButton attack;
    JButton switchHands;
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
    switchHands.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
          switchScreen.setVisible(true);
          mainScreen.setVisible(false);
        } 
      } );
    //mainScreen
    mainScreen = new JFrame("What Will You Do?");
    mainScreen.setSize(600,600);
    mainScreen.setVisible(true);
    mainScreen.setLayout(null);
    


    //switchScreen
    switchScreen = new JFrame("What values will you give your hands?");
    switchScreen.setSize(400,200);
    switchScreen.setVisible(true);
    switchScreen.setLayout(null);
    
    //attackScreen
    attackScreen = new JFrame("Choose your attack");
    attackScreen.setSize(400,200);
    attackScreen.setVisible(false);
    attackScreen.setLayout(null);

    
    } 
    
    
      
} 

