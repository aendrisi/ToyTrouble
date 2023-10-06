package Interactable;

import java.io.File;
import ParentClasses.*;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import ParentClasses.CandlePuzzle;
import ParentClasses.Dialogue;

import java.util.*;

/**
 * The object candle used in Ophelia's candle puzzle that can be
 * drawn in a graphics window.
 */
public class Candle extends Interactable
  {
    public boolean startPuzzle;
    private boolean isLit;
    public Image litImage;
    public Image unLitImage;
    private int candleNum;
    private CandlePuzzle puzzle;

    /**
     * Constructs a candle with a specified location, width, 
     * height, number, and linked to puzzle
     *
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param num candle's assigned number
     * @param candlePuzzle the puzzle the candle is a part of
     */
    public Candle(int x, int y, int w, int h, int num, CandlePuzzle candlePuzzle)
    {
      super(x, y, w, h, "/Sprites/unlitCandle.png", "");
      isLit = false;
      candleNum = num;
      puzzle = candlePuzzle;
      
      try {
        URL url = getClass().getResource("/Sprites/litCandle.png");
        litImage = ImageIO.read(url);

        url = getClass().getResource("/Sprites/unlitCandle.png");
        unLitImage = ImageIO.read(url);
      } catch (Exception e) {}
    }

    /**
     * Lights the candle.
     */
    public void light()
    {
      if (!isLit)
      {
        setImage(litImage);
        isLit = true;
        puzzle.addCandle(candleNum);
      }
        
    }

    /**
     * Unlights the candle.
     */
    public void unlight()
    {
      setImage(unLitImage);
      isLit = false;
    }

    /**
     * Returns the candle's assigned number.
     * @return candle's number
     */
    public int getNum()
    {
      return candleNum;
    }

    
    /**
     * Lights candle when interacted with or prompts user to
     * get a lighter if they are missing it.
     * 
     * @param textBox textbox for dialogue
     * @param roomNum current room number
     * @param inven the player's inventory
     *
     * @return 0 since candles do not change room number
     */
    public int interact(Dialogue textBox, int roomNum, Inventory inven)
    {
      if (puzzle.isPuzzleActive() && inven.containsKey("Lighter"))
        light();
      else
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("NARRATOR--How are you going to light candles without a lighter?");
        dialogue = repeat;
      
        textBox.startDialogue(dialogue,false);
      }
      return 0;
    }

    /**
     * Draws a candle in a specified Graphics window
     * 
     * @param window the Graphics window
     */
    public void draw(Graphics window) {
      if (puzzle.isPuzzleActive())
      {
       if(isOutline() && !isLit)
       {
         window.drawImage(outline(), xPos-5,yPos-5,width+10,height+10,null);
       }
       window.drawImage(image, xPos, yPos, width, height, null);
      }
    }

    /**
     * Prints the name of the object (Candle)
     * 
     * @return name of object
     */
    public String toString()
    {
      return "CANDLE";
    }
  }