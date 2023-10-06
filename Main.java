import javax.swing.JFrame;

import Rooms.Rooms;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Environment for running the game
 */
public class Main extends JFrame
{
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  /**
   * Launches the game
   * 
   * @param args not used
   */
  public static void main(String args[]) {
    JFrame frame = new JFrame();
 		
 		frame.setSize(WIDTH,HEIGHT);
 		frame.setLocation(5, 5);
 		//frame.setUndecorated(true); //comment this out 
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Rooms rooms = new Rooms();
    
    frame.add(rooms); 
 		frame.setVisible(true);
  }
}

