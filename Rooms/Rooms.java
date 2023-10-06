package Rooms;
//import ParentClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.Image;
import javax.imageio.ImageIO;

import Interactable.*;
import ParentClasses.*;

import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


/**
 * Represents the graphic environment of the game
 */
public class Rooms extends Canvas implements KeyListener, Runnable, ActionListener
{
  //setBackground(Color.black);
  public boolean[] keys;
  public BufferedImage back;

  //public MovingBackground background;
  //characters
  public Dialogue textBox;

  public int roomNum;
  RoomOpen room0;
  RoomOne room1;
  RoomTwo room2;
  RoomThree room3;
  RoomFour room4;
  ShadowRoom roomShadow;

  RoomOneBad room6;
  RoomOneGood room7;
  RoomTwoGood room8;
  RoomThreeGood room9;
  RoomFourGood room10;
  
  RoomParent[] rooms;

  Inventory inventory;

  /**
   * Creates a Rooms object which contains the various
   * rooms for the game
   */
  public Rooms() {
    keys = new boolean[13];
    roomNum = 0; 
    textBox = new Dialogue("/Sprites/textBoxSample.png");

    inventory = new Inventory(); 
    
    this.addKeyListener(this);
    new Thread(this).start();

    rooms = new RoomParent[11];
    room0 = new RoomOpen();
    rooms[0] = room0;
    room1 = new RoomOne();
    rooms[1] = room1;
    room2 = new RoomTwo();
    rooms[2] = room2;
    room3 = new RoomThree();
    rooms[3] = room3;
    roomShadow = new ShadowRoom();
    rooms[4] = roomShadow;
    room4 = new RoomFour();
    rooms[5] = room4;
    
    room6 = new RoomOneBad();
    rooms[6] = room6;
    room7 = new RoomOneGood();
    rooms[7] = room7;
    room8 = new RoomTwoGood(inventory);
    rooms[8] = room8;
    room9 = new RoomThreeGood(inventory);
    rooms[9] = room9;
    room10 = new RoomFourGood();
    rooms[10] = room10;
    

    setVisible(true);
  }


  /**
   * Updates the graphics window
   * 
   * @param window the graphics window
   */
  public void update(Graphics window) {
    paint(window);
  }

  /**
   * Updates the contents of the graphics window using double buffering
   * 
   * @param window the graphics window
   */
  public void paint(Graphics window) {
    Graphics2D twoDGraph = (Graphics2D) window;
    if (back == null)
        back = (BufferedImage) (createImage(getWidth(), getHeight()));
    Graphics graphToBack = back.createGraphics();

    
    if (rooms[roomNum].getSpecial()) //special paint
    {
      graphToBack = rooms[roomNum].paintSpecial(graphToBack);
    }
    else //regular paint
    {
      Benji ben = rooms[roomNum].getBen();
      MovingBackground bg = rooms[roomNum].getBG();

      for (Interactable obj : rooms[roomNum].getObjects())
      {
        if (obj.isNear(rooms[roomNum].getBen()))
        {
          obj.drawOutline();
          break;
        }
        else
        {
          obj.unDraw();
        }
      }

      
      if(textBox.isDialogueMode())
        textBox.draw(graphToBack); 
      else if(inventory.isOpen())
        inventory.draw(graphToBack);
      else if(textBox.isGlyphPuzzle())
        textBox.draw(graphToBack);
      else 
      {
        if (keys[0]) 
          {
            if (ben.getX() > 0)
              ben.move("LEFT", getWidth());
            else if (bg.move("RIGHT", ben.getSpeed()))
              {
                ben.left();
                for (Interactable obj : rooms[roomNum].getObjects())
                  {obj.move("RIGHT", ben.getSpeed());}
              }   
          }
        else if (keys[1])
          {
            if (ben.getX() < getWidth() - ben.getWidth() - 10)
              ben.move("RIGHT", getWidth());
            else if (bg.move("LEFT", ben.getSpeed()))
              {
                ben.right();
                for (Interactable obj : rooms[roomNum].getObjects())
                  {obj.move("LEFT", ben.getSpeed());}
              }
          }
        else
            ben.forward();
  
        bg.draw(graphToBack);
        for (Interactable obj : rooms[roomNum].getObjects())
          {obj.draw(graphToBack);}
        ben.draw(graphToBack);
      }
    }
      
    twoDGraph.drawImage(back, null, 0, 0); 
  }

  /**
   * Updates the keys array based on the key that was pressed
   * left, right, X, B, T, A, C, D, E, and Enter
   * 
   * @param e the KeyEvent representing the pressed key
   */
  public void keyPressed(KeyEvent e) {
    if (roomNum == 0)
    {
      if (e.getKeyCode() == KeyEvent.VK_X) 
      {
        keys[2] = true;
        for (Interactable obj : rooms[roomNum].getObjects())
          {
            roomNum += obj.interact(textBox, roomNum, inventory);
          }
      }  
    }
    else
    {
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        if(!inventory.isOpen())  
          keys[0] = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        if(!inventory.isOpen())
          keys[1] = true;
      }
      if (e.getKeyCode() == KeyEvent.VK_X) {
        if(!inventory.isOpen())  {
          keys[2] = true;
          if(textBox.isDialogueMode())
            textBox.next();
          else if(textBox.isGlyphPuzzle())
          {
            textBox.escGlyphPuzzle();
          }
          else
          {
            for (Interactable obj : rooms[roomNum].getObjects())
            {
              if (obj.isNear(rooms[roomNum].getBen()))
              {
                roomNum += obj.interact(textBox, roomNum, inventory);
                break;
              }
            }
          }
        }
      }
      
      if (e.getKeyCode() == KeyEvent.VK_B) {
        if (!textBox.isGlyphPuzzle())
        {
          keys[3] = true;
          inventory.open();
          //System.out.println(inventory.toString());
        }
      }
    }

    
    // for (Interactable obj : rooms[roomNum].getObjects())
    // {
    //   if (obj.isNear(rooms[roomNum].getBen()))
    //   {
    //     obj.drawOutline();
    //     //System.out.println(obj);
    //     break;
    //   }
    //   else
    //   {
    //     obj.unDraw();
    //     //break;
    //   }
    // }

    
    if (inventory.isOpen())
    {
      if (e.getKeyCode() == KeyEvent.VK_LEFT)
      {
        keys[10] = true;
        inventory.left();
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT)
      {
        keys[11] = true;
        inventory.right();
      }
    }
    
    if(textBox.isGlyphPuzzle())
    {
      //textBox.glyphPuzzle();
      if (e.getKeyCode() == KeyEvent.VK_T) {
        keys[12] = true;
        if(!textBox.isInstructions())
          textBox.showInstructions();
        else
          textBox.hideInstructions();
      }
      if (e.getKeyCode() == KeyEvent.VK_A) {
        keys[4] = true;
        textBox.addGlyph("A");
        //System.out.println("A pressed");
        // if(textBox.checkGlyph())
        // {
        //   textBox.correctGlyph();
        // }
      }
      if (e.getKeyCode() == KeyEvent.VK_B) {
        keys[5] = true;
        textBox.addGlyph("B");
        // if(textBox.checkGlyph())
        // {
        //   textBox.correctGlyph();
        // }
      }
      if (e.getKeyCode() == KeyEvent.VK_C) {
        keys[6] = true;
        textBox.addGlyph("C");
        // if(textBox.checkGlyph())
        // {
        //   textBox.correctGlyph();
        // }
      }
      if (e.getKeyCode() == KeyEvent.VK_D) {
        keys[7] = true;
        textBox.addGlyph("D");
        // if(textBox.checkGlyph())
        // {
        //   textBox.correctGlyph();
        // }
      }
      if (e.getKeyCode() == KeyEvent.VK_E) {
        keys[8] = true;
        textBox.addGlyph("E");
        // if(textBox.checkGlyph())
        // {
        //   textBox.correctGlyph();
        // }
      }
      if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        keys[9] = true;
        //System.out.println(textBox.attemptString());
        // if(textBox.isChoiceMode())
        // {
        //   textBox.isCorrectChoice();
        // }
        if(textBox.checkGlyph())
        {
          textBox.correctGlyph();
        }
        else
        {
          //System.out.println("reset");
          textBox.resetGlyph();
        }
      }
      
      // if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      //   keys[9] = true;
      //   System.out.println(textBox.attemptString());
      //   if(textBox.checkGlyph())
      //   {
      //     textBox.correctGlyph();
      //   }
      //   else
      //   {
      //     System.out.println("reset");
      //     textBox.resetGlyph();
      //   }
      // }
    }
    //repaint();
  }



  /**
   * Updates the keys array based on the key that was released
   * 
   * @param e the KeyEvent representing the released key
   */
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      keys[0] = false;
      keys[10] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      keys[1] = false;
      keys[11] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_X) {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_B) {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_A) {
      keys[4] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_W) {
      keys[5] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_C) {
      keys[6] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_D) {
      keys[7] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_E) {
      keys[8] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      keys[9] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_T) {
      keys[12] = false;
    }
  }
  

  /**
   * Needed to satisfy the KeyListener
   * 
   * @param e not used
   */
  public void keyTyped(KeyEvent e) {}

  public void actionPerformed(ActionEvent e){}

  /**
   * Runs the thread in an infinite loop with a pause of 5 miliseconds between
   * updates
   */
  public void run() {
    try {
      while (true) {
        Thread.currentThread().sleep(100);
        repaint();
      }
    } catch (Exception e) {
    }
  }

}
