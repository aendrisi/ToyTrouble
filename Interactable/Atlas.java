package Interactable;

import ParentClasses.Item;
import java.io.File;
import java.util.*;

import ParentClasses.Dialogue;
import ParentClasses.Inventory;

/**
 * Represents an NPC named Atlas that can be drawn in a 
 * graphics window.
 */
public class Atlas extends Interactable
  {
    
    /**
     * Constructs Atlas with a specified location, width, height
     * and dialogue
     * 
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param f the dialogue file
     * @param o the outline image file
     */
    public Atlas(int x, int y, int w, int h, String f,String o)
    {
      super(x, y, w, h, "/Sprites/Atlas.png", f,o);
    }


    /**
     * Fills Atlas' dialogue queue to be drawn.
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
        repeat.add("ATLAS--You actually managed to find her, huh?");
        repeat.add("ATLAS--I'm almost impressed.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (isBadEnd())
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("ATLAS--...Well, I'm definitely out of a job now.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (!hasInteracted)
      {
        dialogue = fillDialogue(new File(dialogueFile));
      
        textBox.startDialogue(dialogue,false); 
        hasInteracted = true;
        
        inven.add("Dog Treats",new Item("Dog Treats","Generic bone shaped dog treats. Not for human consumption, or so you've been told...","/Sprites/treats.png"));
      }
      else if (inven.containsKey("Fruit Snacks") && inven.containsKey("Scissors"))
      {
       dialogue = fillDialogue(new File("atlasDialogueKey.rtf"));
      
        textBox.startDialogue(dialogue,false); 
        inven.add("Basement Key",new Item("Basement Key","A rusty, old key to the store's basement.","/Sprites/basementKey.png"));
        inven.remove("Fruit Snacks");
      } 
      else if (!inven.containsKey("Basement Key"))
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("ATLAS--Sorry, bud. Can't tell ya anything until you get me those 2 items.");
        repeat.add("ATLAS--Remember, I'm looking for FRUIT SNACKS and a pair of SCISSORS.");

        dialogue = repeat;
      
        textBox.startDialogue(dialogue,false);
      }
      else
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("ATLAS--Good luck.");
        dialogue = repeat;
      
        textBox.startDialogue(dialogue,false);
      }

      return 0;
    }

    /**
     * Prints the name of the NPC (Atlas)
     * 
     * @return name of NPC
     */
    public String toString()
    {
      return "ATLAS";
    }
  }