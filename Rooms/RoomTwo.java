package Rooms;
import java.util.ArrayList;

import Interactable.Atlas;
import Interactable.Benji;
import Interactable.Door;
import Interactable.Howl;
import Interactable.Interactable;
import ParentClasses.Dialogue;
import ParentClasses.Inventory;
import ParentClasses.MovingBackground;
import ParentClasses.*;


import java.io.File;

/**
 * Represents the graphic environment of 
 * room 2
 */
public class RoomTwo extends RoomParent {
  //characters
  public Atlas atlas;
  public Howl howl;

  //objects
  private Door doorLeft;
  private Door doorRight;
  private Lighter lighter;
  private Candy candy;
  private Board board;

  /**
   * Creates a room 2 object, which 
   * contains all the objects and NPCs
   * in the room 
   */
  public RoomTwo() {
    //inven = new Inventory();
    ben = new Benji(75,240,170,340,30);    
    objects = new ArrayList<Interactable>();
    atlas = new Atlas(350, 225,107,138, "atlasDialogue.rtf","/Sprites/atlasoutline.png");
    lighter = new Lighter(1100,237,50,50,"lightertest.rtf","/Sprites/lighteroutline.png");
    doorLeft = new Door(10,190, 150,50,"/Sprites/exitsign.png", -1,true,"/Sprites/exitsignoutline.png","");
    doorRight = new Door(1855, 200, 300, 100,"/Sprites/drinksign.png", 1,false,"/Sprites/drinksignoutline.png","BEN--(I should probably find those fruit snacks first before looking over here.)");
    howl = new Howl(1370,380,120,120,"/Sprites/howl.png","howlDialogue.rtf",doorRight,"/Sprites/howloutline.png");
    candy = new Candy(1720,270,50,50,"candydialogue.rtf","/Sprites/candyoutline.png");
    //999,690
    board = new Board(650,180,269,169,"","/Sprites/boardoutline.png");
    //780,330
    objects.add(atlas);
    objects.add(howl);
    objects.add(doorLeft);
    objects.add(doorRight);
    objects.add(lighter);
    objects.add(candy);
    objects.add(board);


    background = new MovingBackground("/Sprites/room2DRAFT.png", 800, 2200, 600);
  }

  // public Howl getHowl()
  // {
  //   return howl;
  // }

  
  //objects in room

  /**
   * The object Lighter used in Ophelia's candle puzzle that can be
   * drawn in a graphics window.
   */
  public class Lighter extends Interactable
    {
      /**
       * Constructs lighter with a 
       * specified location, width, 
       * height, number, and linked to puzzle
       *
       * @param x the x location
       * @param y the y location
       * @param w the width
       * @param h the height
       * @param f dialogue file
       * @param o outline image file
       */
      public Lighter(int x, int y, int w, int h, String f,String o)
      {
        super(x, y, w, h, "/Spriteghter", f,o);
      }

      /**
       * Prints the name of the object (Lighter)
       * 
       * @return name of object
       */
      public String toString()
      {
        return "LIGHTER";
      }

      /**
       * Fills dialogue to be displayed
       * and adds to inventory
       * 
       * @param textBox textbox for dialogue
       * @param roomNum current room number
       * @param inven the player's inventory
       *
       * @return 0 since lighter does not change room number
       */
      public int interact(Dialogue textBox, int roomNum, Inventory inven)
      {
        dialogue = fillDialogue(new File(dialogueFile));
      
        textBox.startDialogue(dialogue,false);
        inven.add("Lighter",new Item("Lighter","a device that produces a small flame, typically used to light candles.","/Sprites/lighter.png"));
        //removes
        objects.remove(lighter);
        moveHide();
        return 0;
      }
      
    }


    /**
     * The object Candy that can be
     * drawn in a graphics window.
     */
    public class Candy extends Interactable
    {

      /**
       * Constructs candy with a 
       * specified location, width, 
       * height, number, and linked to puzzle
       *
       * @param x the x location
       * @param y the y location
       * @param w the width
       * @param h the height
       * @param f dialogue file
       * @param o outline image file
       */
      public Candy(int x, int y, int w, int h, String f,String o)
      {
        super(x, y, w, h, "/Sprites/candy.png", f,o);
      }

      /**
       * Prints the name of the object (Candy)
       * 
       * @return name of object
       */
      public String toString()
      {
        return "CANDY";
      }

      /**
       * Fills dialogue to be displayed
       * and adds to inventory
       * 
       * @param textBox textbox for dialogue
       * @param roomNum current room number
       * @param inven the player's inventory
       *
       * @return 0 since candy does not change room number
       */
      public int interact(Dialogue textBox, int roomNum, Inventory inven)
      {
        dialogue = fillDialogue(new File(dialogueFile));
        textBox.startDialogue(dialogue,false);
        inven.add("Peanut M&Ms",new Item("Peanut M&Ms","The inferior version of the classic M&Ms.","/Sprites/candy.png"));
        objects.remove(candy);
        moveHide();
        return 0;
      }
      
    }

    /**
     * The object Board that can be
     * drawn in a graphics window.
     */
    public class Board extends Interactable
    {
      /**
       * Constructs board with a 
       * specified location, width, 
       * height, number, and linked to puzzle
       *
       * @param x the x location
       * @param y the y location
       * @param w the width
       * @param h the height
       * @param f dialogue file
       * @param o outline image file
       */
      public Board(int x, int y, int w, int h, String f,String o)
      {
        super(x, y, w, h, "/Sprites/bulletinboard.png", f,o);
      }

      /**
       * Prints the name of the object (Board)
       * 
       * @return name of object
       */
      public String toString()
      {
        return "BOARD";
      }

      /**
       * Fills dialogue to be displayed
       * and adds to inventory
       * 
       * @param textBox textbox for dialogue
       * @param roomNum current room number
       * @param inven the player's inventory
       *
       * @return 0 since board does not change room number
       */
      public int interact(Dialogue textBox, int roomNum, Inventory inven)
      {
        dialogue = fillDialogue(new File(dialogueFile));
        
        textBox.setZoomImage("/Sprites/bulletinboard.png");
        textBox.startDialogue(dialogue,true);
        return 0;
      }

      
    }

}
