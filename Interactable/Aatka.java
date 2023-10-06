package Interactable;

import ParentClasses.*;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import java.util.*;

/**
 * Represents an NPC named Aatka that can be drawn in a 
 * graphics window.
 */
public class Aatka extends Interactable
  {
    
    /**
     * Constructs Aatka with a specified location, width, height
     * and dialogue
     * 
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param f the dialogue file
     * @param o the outline image file
     */
    public Aatka(int x, int y, int w, int h, String f,String o)
    {
      super(x, y, w, h, "/Sprites/aatka.png", f, o);
    }

    /**
     * Interact method fills dialogue queue to be drawn 
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
          repeat.add("AATKA--I think I found your owl.");
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
     * Prints the name of the NPC (Aatka)
     * 
     * @return name of NPC
     */
    public String toString()
    {
      return "AATKA";
    }
  }
