package Interactable;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import ParentClasses.Dialogue;
import ParentClasses.Inventory;

import java.util.*;

/**
 * The object door is used to change rooms and can be drawn in a 
 * graphics window.
 */
public class Door extends Interactable
  {
    private int side;
    private boolean doorCondition;
    private String lock;
    
    /**
     * Constructs a door with a specified location, width, 
     * height, image, key, and door condition
     *
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param i the image file
     * @param s the side key (determines which room the door
     * leads to)
     * @param d locks door if true until a condition is met
     */
    public Door(int x, int y, int w, int h, String i, int s, boolean d)
    {
      super(x, y, w, h, i, "");
      door = true;
      side = s; //-1 == left, 1 == right
      doorCondition = d;
      lock = "NARRATOR--Looks like the door is locked.";
    }

    /**
     * Constructs a door with a specified location, width, 
     * height, image, key, specific dialogue, and door condition
     *
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param i the image file
     * @param s the side key (determines which room the door
     * leads to)
     * @param d locks door if true until a condition is met
     * @param l dialogue of locked door
     */
    public Door(int x, int y, int w, int h, String i, int s, boolean d, String l)
    {
      super(x, y, w, h, i, "");
      door = true;
      side = s; //-1 == left, 1 == right
      doorCondition = d;
      lock = l;
    }
    
    /**
     * Constructs a door with a specified location, width, 
     * height, image, key, specific dialogue, custom outline
     * image, and door condition
     *
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param i the image file
     * @param s the side key (determines which room the door
     * leads to)
     * @param d locks door if true until a condition is met
     * @param o outline image file
     * @param l dialogue of locked door
     */
    public Door(int x, int y, int w, int h, String i, int s, boolean d,String o,String l)
    {
      super(x, y, w, h, i, "",o);
      door = true;
      side = s; //-1 == left, 1 == right
      doorCondition = d;
      lock = l;
    }

    /**
     * Returns whether the door is locked
     *
     * @return whether door is locked or not
     */
    public boolean getDoorCondition()
    {
      return doorCondition;
    }

    /**
     * Locks or unlocks door
     * 
     * @param d door locked or unlocked
     */
    public void setDoorCondition(boolean d)
    {
      doorCondition = d;
    }

    /**
     * Gives locked message or changes room.
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
      if(doorCondition)
        return side;
      else 
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add(lock);
        
        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
        return 0;
      }
    }
  }


