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

/**
 * Represents an NPC named Haruki that can be drawn in a 
 * graphics window.
 */
public class Haruki extends Interactable
  {
    private Door door;

    /**
     * Constructs Haruki with a specified location, width, height
     * and dialogue
     * 
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param i name of image file
     * @param f the dialogue file
     * @param d door
     * @param o the outline image file
     */
    public Haruki(int x, int y, int w, int h, String i, String f,Door d,String o)
    {
      super(x, y, w, h, i, f, o);
      door = d;
    }

    /**
     * Prints the name of the NPC (Haruki)
     * 
     * @return name of NPC
     */
    public String toString()
    {
      return "HARUKI";
    }

    /**
     * Fills Haruki's dialogue queue to be drawn and unlocks
     * door.
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
        repeat.add("HARUKI--You found her! Thank you so much!");
        repeat.add("MAO--Thanks!");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (isBadEnd())
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("HARUKI--Mao?! What did you do??");
        repeat.add("MAO--Hey! This wasn't MY fault. Mostly.");
        repeat.add("MAO--How were we supposed to know scissors could do so much damage?");
        repeat.add("HARUKI--Well, thanks for finding her, I guess.");
        repeat.add("BEN--You're welcome!");
        repeat.add("BEN--(I guess I can't get that mango juice now.)");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (!hasInteracted)
      {
        dialogue = fillDialogue(new File(dialogueFile));
      
        textBox.startDialogue(dialogue,false);
        inven.add("Harummer",new Item("Harummer","This thing is guaranteed to destroy anything it touches. The handle is covered in various stickers along with a label that reads ‘Harummer.’","/Sprites/hammer.jpeg"));   
        
        hasInteracted = true;
        door.setDoorCondition(true);
      }
      else
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("HARUKI--Please find my sister!");
        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      } 
      return 0;
    }

  }