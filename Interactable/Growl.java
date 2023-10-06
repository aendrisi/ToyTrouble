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
 * Represents an NPC named Growl that can be drawn in a 
 * graphics window.
 */
public class Growl extends Interactable
  {
    private Door door;

    /**
     * Constructs Growl with a specified location, width, height
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
    public Growl(int x, int y, int w, int h, String i, String f,Door d,String o)
    {
      super(x, y, w, h, i, f, o);
      door = d;
    }

    /**
     * Prints the name of the NPC (Growl)
     * 
     * @return name of NPC
     */
    public String toString()
    {
      return "'GROWL'";
    }

    /**
     * Fills Growl's dialogue queue to be drawn and unlocks
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
        repeat.add("HOWL--Oh hey Growl, what's up?");
        repeat.add("'GROWL'--Not you too...Did you even notice that I was missing?");
        repeat.add("HOWL--Huh? I saw you like, 15 minutes ago.");
        repeat.add("'GROWL'--(Sighs) Never mind.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (isBadEnd())
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("HOWL--NOOO MY iPAD!!");
        repeat.add("'GROWL'--You are WAY too addicted to that thing.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (!hasInteracted)
      {
        dialogue = fillDialogue(new File(dialogueFile));
      
        textBox.startDialogue(dialogue,false);        
        hasInteracted = true;
        door.setDoorCondition(true);
      }
      else
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("'GROWL'--My name is Luke, not 'Growl.'");
        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      return 0;
    }

  }