package ParentClasses;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 * The object inventory containing all the player's collected
 * items and can be drawn in a graphics window
 */
public class Inventory
{
  private Map<String,Item> inventory;
  private ArrayList<String> list;
  private Image select;
  private Image inven;
  private Image grid;
  private Boolean isOpen;

  private int currItem;


  /**
   * Constructs the inventory with Map to hold items and
   * images to display
   */
  public Inventory()
  {
    inventory = new TreeMap<String,Item>();

    try {
      URL url = getClass().getResource("/Sprites/inventory.png");
      inven = ImageIO.read(url);

      url = getClass().getResource("/Sprites/3x3grid.png");
      grid = ImageIO.read(url);

      url = getClass().getResource("/Sprites/selected.png");
      select = ImageIO.read(url);
    } catch (Exception e) {
      System.out.println(e);
    }

    isOpen = false;
    currItem = 0;

    list = new ArrayList<String>();


  }

  /**
   * Opens the inventory allowing it to be drawn
   */
  public void open()
  {
    if (isOpen)
    {
      isOpen = false;
      list.clear();
    }
    else
    {
      isOpen = true;
      Set<String> keys = inventory.keySet();
      for (String key : keys)
      {
        list.add(key);
      }
      currItem = 0;
    }
  }

  /**
   * Moves cursor on items to the right
   */
  public void right()
  {
    if(currItem != list.size() - 1)
    {
      currItem++;
    }
    else
      currItem = 0;
  }

  /**
   * Moves cursor on items to the left
   */
  public void left()
  {
    if(currItem != 0)
    {
      currItem--;
    }
    else
      currItem = list.size() - 1;
  }

  /**
   * Checks if inventory is open
   * @return if inventory is open
   */
  public boolean isOpen()
  {
    return isOpen;
  }

  /**
   * Returns the current item cursor is over
   * @return the corrent item the cursor is over
   */
  public String currentItem()
  {
    return list.get(currItem);
  }
  

  /**
   * Adds item to inventory
   * @param key key for treemap
   * @param item the item to add, linked to the key
   */
  public void add(String key, Item item)
  {
    inventory.put(key,item);
  }

  /**
   * removes items from inventory
   * @param key the item's key to be removed
   */
  public void remove(String key)
  {
    inventory.remove(key);
  }

  /**
   * Checks if inventory contains a key
   * 
   * @return if inventory contains this item
   */
  public boolean containsKey(String key)
  {
    return inventory.containsKey(key);
  }

  /**
   * Draws the inventory in a specified Graphics window
   * 
   * @param window the Graphics window
   */
  public void draw(Graphics window) {
    if (isOpen)
    {
      Set<String> keys = inventory.keySet();
      // System.out.println(inventory);
      // System.out.println(keys);
      // window.drawImage(inventory.get("Lighter").getImage(),0,0,100,100,null);
      
      window.drawImage(inven,0,0,800,600,null);
      //int changePos = 100;
      int currentX = 204-(309-204);
      int currentY = 161;
      int rowCounter = 0;

      JTextArea ta;
      for(String key : keys) 
      {
        //System.out.println("runs");
        Item value = inventory.get(key);
window.drawImage(value.getImage(),currentX,currentY,299-204,257-161,null);
        rowCounter++;
        if(rowCounter > 2)
        {
          currentX = 95;
          currentY+=266-161;
          rowCounter = 0;
        }
        else
        {
          currentX+=309-204;
        }
      } 

      window.drawImage(grid,89,152,323,321,null);

      
      if(inventory.size() != 0)
      {
        switch(currItem)
        {
          case 0: window.drawImage(select,160,220,60,60,null);
            break;
          case 1: window.drawImage(select,160+110,220,60,60,null);
            break;
          case 2: window.drawImage(select,160+210,220,60,60,null);
            break;
          case 3: window.drawImage(select,160,330,60,60,null);
            break;
          case 4: window.drawImage(select,160+110,330,60,60,null);
            break;
          case 5: window.drawImage(select,160+210,330,60,60,null);
            break;
          case 6: window.drawImage(select,160,430,60,60,null);
            break;
          case 7: window.drawImage(select,160+110,430,60,60,null);
            break;
          case 8: window.drawImage(select,160+210,430,60,60,null);
            break;
        }
        Item select = inventory.get(list.get(currItem));
        String desc = select.getDesc();
        ta = new JTextArea(desc);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setBounds(500, 160, 200, 500-160);
        ta.setForeground(Color.black);
        ta.setFont(new Font("Arial Black", Font.BOLD, 15));
        Graphics g2 = window.create(500, 160, 200, 500-160);
        ta.paint(g2);
      }
      
    }
  }

  /**
   * Returns string of inventory
   * @return inventory as string
   */
  public String toString()
  {
    String str = "";
    Iterator<String> it;
    it = inventory.keySet().iterator();
    while(it.hasNext())
    {
      String c = it.next();
      str += c + ": " + inventory.get(c) + "\n\n";
    }
    return str;
  }
}