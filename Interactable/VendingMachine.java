package Interactable;
import java.util.*;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import ParentClasses.Dialogue;
import ParentClasses.Inventory;

/**
 * Represents an object Vending Machine that
 * can be drawn in a 
 * graphics window.
 */
public class VendingMachine extends Interactable
  {
    /**
     * Constructs Vending Machine with a specified location, width, height
     * and dialogue
     * 
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param i name of image file
     */
    public VendingMachine(int x, int y, int w, int h, String i)
    {
      super(x, y, w, h, i, "");
      door = true;
    }

    /**
     * Prints the name of the object
     * (Vending Machine)
     * 
     * @return name of NPC
     */
    public String toString()
    {
      return "VENDING MACHINE";
    }

    /**
     * Fills Vending Machine's dialogue
     * queue to be drawn and starts good/bad
     * ending.
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
       Queue<String> repeat = new LinkedList<String>();
        repeat.add("NARRATOR--Boss fight");

      /*if (isGoodEnd())
      {
        repeat.add("NARRATOR--Good End.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (isBadEnd())
      {
        repeat.add("NARRATOR--Bad End.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else */if(inven.containsKey("Harummer"))
      {
        //repeat.add("NARRATOR--Good ending.");
        //dialogue = repeat;
        dialogue = fillDialogue(new File("VendingMachineGood.rtf"));
        textBox.startDialogue(dialogue,false);
        return 5;
      }
      else
      {
        //repeat.add("NARRATOR--Bad ending.");
        //dialogue = repeat;
        dialogue = fillDialogue(new File("VendingMachineBad.rtf"));
        textBox.startDialogue(dialogue,false);
        //System.out.println("Change to good bad");
        return 1;
      }
      //return 0;
        
    }

  }