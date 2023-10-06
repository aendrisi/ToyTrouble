package Interactable;

import ParentClasses.*;
import ParentClasses.*;
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
 * Represents an NPC named Sadiya that can be drawn in a 
 * graphics window.
 */
public class Sadiya extends Interactable
  {
    private Door door;

    /**
     * Constructs Sadiya with a specified location, width, height
     * and dialogue
     * 
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param i name of image file
     * @param f the dialogue file
     * @param d door
     */
    public Sadiya(int x, int y, int w, int h, String i, String f,Door d)
    {
      super(x, y, w, h, i, f,"/Sprites/sadiyaoutline.png");
      door = d;
      door.hide();
    }

    /**
     * Prints the name of the NPC (Sadiya)
     * 
     * @return name of NPC
     */
    public String toString()
    {
      return "SADIYA";
    }

    /**
     * Fills Sadiya's dialogue queue to be drawn and unlocks
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
        repeat.add("NARRATOR--Good End.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (isBadEnd())
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("NARRATOR--Bad End.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (!hasInteracted)
      {
        if(inven.containsKey("Mango Juice"))
        {
          dialogue = fillDialogue(new File("sadiyadialogue1.rtf"));
          inven.remove("Mango Juice");
        }
        else
        {
          dialogue = fillDialogue(new File("sadiyadialogue2.rtf"));
          //testing
          inven.add("Harummer",new Item("Harummer","This thing is guaranteed to destroy anything it touches. The handle is covered in various stickers along with a label that reads ‘Harummer.’","/Sprites/hammer.jpeg"));   
          inven.remove("Harummer");
        }
      
        textBox.startDialogue(dialogue,false);
        inven.add("Scissors",new Item("Scissors","You got these metal scissors from a mysterious rat. You get the feeling you shouldn't keep it for too long. ","/Sprites/scissors.png"));   
        
        hasInteracted = true;
        door.setDoorCondition(true);
        door.show();
      }
      else
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("SADIYA--...");
        repeat.add("NARRATOR--She doesn't seem to hear you. Perhaps you're being ignored?");
        
        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      return 0;
    }

  }