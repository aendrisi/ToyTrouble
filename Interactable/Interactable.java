package Interactable;

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import ParentClasses.Dialogue;
import ParentClasses.Inventory;
import ParentClasses.*;

import java.util.*;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;


public class Interactable {
  int xPos;
  int yPos;
  int width;
  int height;
  protected Image image;
  protected String dialogueFile;
  protected Queue<String> dialogue;
  protected Boolean door;
  public Image pfp;
  public Boolean hasInteracted;
  public Boolean isHidden;
  private boolean outline;
  private Image outlineImage;
  private boolean goodEnd;
  private boolean badEnd;
  private boolean customOutline;
  

  /**
   * Constructs an interactable object with specified position, size, image, and dialogue file
   * 
   * @param x the specified x position
   * @param y the specified y position
   * @param w the specified width 
   * @param h the specified height
   * @param i the specified character image
   * @param f the specified dialogue file
   * @param o outline image
   */
  public Interactable(int x, int y, int w, int h, String i, String f, String o) {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    dialogueFile = f;
    try {
      URL url = getClass().getResource(i);
      image = ImageIO.read(url);

      url = getClass().getResource(o);
      outlineImage = ImageIO.read(url);
    } catch (Exception e) {}
    customOutline = true;
    
    door = false;
    hasInteracted = false;
    isHidden = false;
    outline = false;

    goodEnd = false;
    badEnd = false;
  }

  /**
   * Constructs an interactable object with specified position, size, image, and dialogue file
   * 
   * @param x the specified x position
   * @param y the specified y position
   * @param w the specified width 
   * @param h the specified height
   * @param i the specified character image
   * @param f the specified dialogue file
   */
  public Interactable(int x, int y, int w, int h, String i, String f) {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    dialogueFile = f;
    try {
      URL url = getClass().getResource(i);
      image = ImageIO.read(url);

      url = getClass().getResource("/Sprites/white.png");
      outlineImage = ImageIO.read(url);
    } catch (Exception e) {}
    
    door = false;
    hasInteracted = false;
    isHidden = false;
    outline = false;

    goodEnd = false;
    badEnd = false;
  }

  
  /**
   * Allows draw method to draw object outline
   */
  public void drawOutline()
  {
    outline = true;
  }

  /**
   * Prevents draw method from drawing object outline
   */
  public void unDraw()
  {
    outline = false;
  }

  /**
   * Returns whether object is outlined
   *
   * @return whether object is outlined or not
   */
  public boolean isOutline()
  {
    return outline;
  }

  /**
   * Returns object's outline image
   *
   * @return the outline image
   */
  public Image outline()
  {
    return outlineImage;
  }

  /**
   * Sets the outline image
   *
   * @param outline image
   */
  public void setOutline(String out)
  {
    try {
      URL url = getClass().getResource(out);
      outlineImage = ImageIO.read(url);
    } catch (Exception e) {}
  }

  /**
   * Sets the position of an interactable object
   * 
   * @param x the new x position
   * @param y the new y position
   */
  public void setPos(int x, int y)
  {
    xPos = x;
    yPos = y;
  }

  /**
   * Sets the x position of an interactable object
   * 
   * @param x the new x
   */
  public void setX(int x)
  {
    xPos = x;
  }

  /**
   * Sets the y position of an interactable object
   * 
   * @param y the new y
   */
  public void setY(int y)
  {
    yPos = y;
  }

  /**
   * Gets the x position of an interactable object
   * 
   * @return the x position
   */
  public int getX()
  {
    return xPos;
  }

  /**
   * Gets the y position of an interactable object
   * 
   * @return the y position
   */
  public int getY()
  {
    return yPos;
  }

  /**
   * Gets the width of an interactable object
   * 
   * @return the width
   */
  public int getWidth()
  {
    return width;
  }

  /**
   * Gets the height of an interactable object
   * 
   * @return the height
   */
  public int getHeight()
  {
    return height;
  }

  /**
   * Sets the width of an interactable object
   * 
   * @param w the new width
   */
  public void setWidth(int w)
  {
    width = w;
  }

  /**
   * Sets the height of an interactable object
   * 
   * @param h the new height
   */
  public void setHeight(int h)
  {
    height = h;
  }

  /**
   * Gets the profile picture of an interactable object if 
   * they're an NPC
   * 
   * @return the pfp
   */
  public Image getPFP()
  {
    return pfp;
  }

  /**
   * Sets the image of an interactable object
   * 
   * @param i the new image
   */
  public void setImage(Image i)
  {
    image = i;
  }

  /**
   * Returns if the object has been interacted with
   *
   * @return if the object has been interacted with
   */
  public boolean hasInteracted()
  {
    return hasInteracted;
  }

  /**
   * Sets object to interacted
   */
  public void interacted()
  {
    hasInteracted = true;
  }

  /**
   * sets object to not interacted
   */
  public void interactAgain()
  {
    hasInteracted = false;
  }

  /**
   * hides object out of bounds
   */
  public void moveHide()
  {
    setPos(-1000- width, -1000 - height);
    isHidden = true;
  }

  /**
   * Hides object
   */
  public void hide()
  {
    isHidden = true;
  }

  /**
   * Shows object
   */
  public void show()
  {
    isHidden = false;
  }

  /**
   * Returns if object is hidden
   * @return is object hidden
   */
  public Boolean isHidden()
  {
    return isHidden;
  }

  /**
   * Returns if game is in good end state
   * @return good end state
   */
  public Boolean isGoodEnd()
  {
    return goodEnd;
  }

  /**
   * Returns if game is in bad end state
   * @return bad end state
   */
  public Boolean isBadEnd()
  {
    return badEnd;
  }

  /**
   * Starts good end
   */
  public void startGoodEnd()
  {
    goodEnd = true;
  }

  /**
   * Starts bad end
   */
  public void startBadEnd()
  {
    badEnd = true;
  }
  
  /**
   * Returns if the interactable object is near the main character (Ben)
   * 
   * @param ben the main character
   * @return if object is near Ben
   */
  public Boolean isNear(Benji ben)
    {
      int distance = -2;

      int minBen = ben.getX();
      int maxBen = ben.getX()+ben.getWidth();

      int min = xPos-distance;
      int max = xPos+width+distance;

      return (min > minBen && min < maxBen) || (max > minBen && max < maxBen || (min < minBen && minBen < max));
    }

  /**
   * Moves object with the background
   * 
   * @param direction direction to be moved
   * @param speed the speed to be moved at
   */
  public void move(String direction, int speed) {
  		switch(direction)
  		{
  			case "LEFT": 
          xPos = xPos-speed;
  				break;
  			case "RIGHT": 
          xPos = xPos+speed;
  				break;
  		}
    }

  
  /**
   * Fills a queue with all the dialogue in the given file and 
   * returns the queue
   * 
   * @param text the file containing the dialogue
   */
  public Queue<String> fillDialogue(File text)
  {
    Queue<String> queue = new LinkedList<String>();
    try {
      Scanner read = new Scanner(text);
      while(read.hasNextLine())
      {
    	  queue.add(read.nextLine());
      }
      read.close();
    } catch (Exception e) {
    	System.out.println("Dialogue file couldn't be opened: " + e.getMessage());
    }
    
    return queue;
  }

  
  /**
   * Returns dialogue queue
   * @return dialogue queue
   */
  public Queue<String> getDialogueQueue()
  {
    return dialogue;
  }

  /**
   * Checks if object is a door
   * @return door
   */
  public Boolean isDoor()
  {
    return door;
  }

  /**
   * Default interact method fills dialogue queue to be drawn 
   *
   * @param textBox textbox for dialogue
   * @param roomNum current room number
   * @param inven the player's inventory
   *
   * @return side key (determines whether the object 
   * changes the room)
   */
  public int interact(Dialogue textBox, int roomNum, Inventory inven)
  {  
    if (isGoodEnd())
    {
      Queue<String> repeat = new LinkedList<String>();
        repeat.add("NARRATOR--Good End");
        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
    }
    else if (isBadEnd())
    {
      Queue<String> repeat = new LinkedList<String>();
        repeat.add("NARRATOR--Bad End");
        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
    }
    else
    {
      dialogue = fillDialogue(new File(dialogueFile));
      textBox.startDialogue(dialogue,false);
    }
    return 0;
  }

  /**
   * Draws the object in a specified window
   * @param window the graphics window
   */
  public void draw(Graphics window) {
    if(!isHidden) 
    {
      if(outline)
      {
        window.drawImage(outlineImage,xPos-15,yPos-15,width+30,height+30,null);
      }
      window.drawImage(image, xPos, yPos, width, height, null);
    }
  }

}