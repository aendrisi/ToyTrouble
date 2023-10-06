package Interactable;

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
 * Represents an NPC named Howl that can be drawn in a 
 * graphics window.
 */
public class Howl extends Interactable
  {
    private boolean hasInteracted;
    private boolean hasInteracted2;
    private boolean givenTreats;
    private Door door;

    /**
     * Constructs Howl with a specified location, width, height
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
    public Howl(int x, int y, int w, int h, String i, String f, Door d,String o)
    {
      super(x, y, w, h, i, f,o);
      givenTreats = false;
      door = d;
    }

    /**
     * Fills Howl's dialogue queue to be drawn and unlocks
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
      //textBox.startChoice(inven);
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
      else if (!inven.containsKey("Dog Treats") && !givenTreats)
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("NARRATOR--He seems occupied with his little iPad game.");

        dialogue = repeat;
      
        textBox.startDialogue(dialogue,false); 
      }
      else if(!hasInteracted)
      {
        dialogue = fillDialogue(new File(dialogueFile));
      
        textBox.startDialogue(dialogue,false); 
        inven.remove("Dog Treats");
        hasInteracted = true;
        givenTreats = true;
      }
      else if(!hasInteracted2)
      {
        boolean flag = textBox.startGlyph();
        if(!flag)
        {
          Queue<String> repeat = new LinkedList<String>();
          repeat.add("HOWL--thanks man.");
          repeat.add("HOWL--here r ur fruitds sn4cks.");
          repeat.add("BEN--(Why is he speaking like that?)");
          repeat.add("NARRATOR--Fruit Snacks added to inventory.");
          inven.add("Fruit Snacks",new Item("Fruit Snacks","One of Atlas' desired items.","/Sprites/fruit.jpeg")); 

          dialogue = repeat;
      
          textBox.startDialogue(dialogue,false);
          door.setDoorCondition(true);
          hasInteracted2 = true;
        }
      }
      else
      {
        Queue<String> repeat2 = new LinkedList<String>();
        repeat2.add("NARRATOR--His face is glued to his iPad. Again.");

        dialogue = repeat2;
      
        textBox.startDialogue(dialogue,false);
      }

      return 0;
    }

    /**
     * Prints the name of the NPC (Howl)
     * 
     * @return name of NPC
     */
    public String toString()
    {
      return "HOWL";
    }
  }