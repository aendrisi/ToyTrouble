package Interactable;


import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import ParentClasses.CandlePuzzle;
import ParentClasses.Dialogue;
import ParentClasses.Inventory;

import java.util.*;

/**
 * Represents an NPC named Ophelia that can be drawn in a 
 * graphics window.
 */
public class Ophelia extends Interactable
  {    
    private boolean finishedPuzzle;
    private ArrayList<Candle> candles;
    private CandlePuzzle puzzle;
    private Aatka aatka;
    

    /**
     * Constructs Ophelia with a specified location, width, height
     * and dialogue, as well as sets up candle puzzle
     * 
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param i name of image file
     * @param candList list of candles for puzzle
     * @param candlePuzzle the puzzle
     * @param aa an Aatka NPC
     * @param o the outline image file
     */
    public Ophelia(int x, int y, int w, int h, String f, ArrayList<Candle> candleList, CandlePuzzle candlePuzzle, Aatka aa, String o)
    {
      super(x, y, w, h, "/Sprites/ophelia.png", f, o);
      finishedPuzzle = false;

      door = true;
      candles = candleList;
      puzzle = candlePuzzle;
      aatka = aa;
    }

    /**
     * Prints the name of the NPC (Ophelia)
     * 
     * @return name of NPC
     */
    public String toString()
    {
      return "OPHELIA";
    }



    /**
     * Fills Ophelia's dialogue queue to be drawn and unlocks
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
        repeat.add("OPHELIA--Hello again.");
        repeat.add("OPHELIA--I presume you've found what you're looking for?");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (isBadEnd())
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("OPHELIA--This marks the end of an era.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
      }
      else if (!hasInteracted) //first time talking
      {
        dialogue = fillDialogue(new File(dialogueFile));
        
        textBox.startDialogue(dialogue,false);

        hasInteracted = true;
        puzzle.startPuzzle();
      }
      else if (puzzle.isPuzzleActive() && !puzzle.isSolved()) //if you haven't solved the puzzle
      {
        for (Candle candle: candles)
          candle.unlight(); 
        puzzle.clear();
        
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("OPHELIA--Looks like that isn't the right order. I'll clear the candles for you.");
        repeat.add("OPHELIA--Check your cart to see if you already found the sticky note.");

        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
        
      }
      else if (puzzle.isPuzzleActive()) //finishing the puzzle
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("OPHELIA--It's working!");
        repeat.add("BEN--What's working?!");
        repeat.add("OPHELIA--Good luck in there! Don't make her mad at any cost if you wish to live!");
        repeat.add("BEN--What?! Make who mad—");
        dialogue = repeat;
        textBox.startDialogue(dialogue,false);

        //shows aatka
        aatka.setPos(getX()+250, getY());
        aatka.show();

        //moves everything off screen
        moveHide();
        for (Candle candle: candles)
          candle.moveHide();

        puzzle.finishPuzzle();
        return 1;
      }

      return 0;
    }



    /**
     * Draws Ophelia in a specified window
     * @param window the graphics window
     */
    public void draw(Graphics window) {
     if(!finishedPuzzle)
     {
       if(isOutline())
         window.drawImage(outline(),xPos-15,yPos-15,width+30,height+30,null);
       window.drawImage(image, xPos, yPos, width, height, null);
     }
    }

  }