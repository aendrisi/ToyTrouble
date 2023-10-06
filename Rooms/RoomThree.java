package Rooms;
import Interactable.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Image;
import javax.imageio.ImageIO;

import Interactable.Aatka;
import Interactable.Benji;
import Interactable.Candle;
import Interactable.Door;
import Interactable.Interactable;
import Interactable.Ophelia;
import ParentClasses.CandlePuzzle;
import ParentClasses.Dialogue;
import ParentClasses.Inventory;
import ParentClasses.Item;
import ParentClasses.MovingBackground;

import java.net.URL;
import java.io.File;
import java.util.*;


/**
 * Represents the graphic environment of 
 * room 3
 */
public class RoomThree extends RoomParent{
  //characters
  private Door doorLeft;
  private BasementDoor doorRight;

  private Aatka aatka;
  private MangoJuice mango;
  private AppleJuice apple;
  private OrangeJuice orange;
  

  public Ophelia ophelia;
  private Candle candle1;
  private Candle candle2;
  private Candle candle3;
  private Candle candle4;
  private Candle candle5;
  private CandlePuzzle puzzle;

  public ArrayList<Integer> candleOrder;
  
  /**
   * Creates a room 3 object, which 
   * contains all the objects and NPCs
   * in the room 
   */
  public RoomThree() {
    //inven = new Inventory();
    objects = new ArrayList<Interactable>();
    background = new MovingBackground("/Sprites/room3.png", 800, 2600, 600);
    ben = new Benji(75,240,170,340,30);
    doorRight = new BasementDoor(2150, 150, 162, 280,"/Sprites/door.png", 2);
    doorLeft = new Door(25, 150, 250,100,"/Sprites/checksign.png", -1,true,"/Sprites/checksignoutline.png","");

    ArrayList<Candle> candles =  new ArrayList<Candle>();
    candleOrder = new ArrayList<Integer>();
    candleOrder.add(1);
    candleOrder.add(3);
    candleOrder.add(4);
    candleOrder.add(2);
    candleOrder.add(5);

    puzzle = new CandlePuzzle(candleOrder);

    candle1 = new Candle (1200-600, 370, 35, 125, 1, puzzle);
    candles.add(candle1);
    objects.add(candle1);
    candle2 = new Candle (1350-600, 370, 35, 125, 2, puzzle);
    candles.add(candle2);
    objects.add(candle2);
    candle3 = new Candle (1500-600, 370, 35, 125, 3, puzzle);
    candles.add(candle3);
    objects.add(candle3);
    candle4 = new Candle (1650-600, 370, 35, 125, 4, puzzle);
    candles.add(candle4);
    objects.add(candle4);
    candle5 = new Candle (1800-600, 370, 35, 125, 5, puzzle);
    candles.add(candle5);
    objects.add(candle5);

    aatka = new Aatka(-1, -1, 100, 100, "aatkaDialogue.rtf","/Sprites/aatkaoutline.png");
    aatka.moveHide();
    ophelia = new Ophelia(950-600, 350, 150,150, "opheliaDialogue.rtf", candles, puzzle, aatka,"/Sprites/opheliaoutline.png");

    mango = new MangoJuice(1960, 355, 60, 60);
    apple = new AppleJuice(1425, 220, 60,60);
    orange = new OrangeJuice(2525, 220,60,60);
   

    objects.add(doorRight);
    objects.add(doorLeft);
    objects.add(ophelia);
    objects.add(aatka);
    objects.add(mango);
    objects.add(apple);
    objects.add(orange);
  }

   /** 
    * The object mango juice which can 
    * be drawn in the graphics window
    */
   public class MangoJuice extends Interactable
   {

     /**
     * Constructs mango juice box with a 
     * specified location, width, 
     * height, number, and linked to puzzle
     *
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     */
     public MangoJuice(int x, int y, int w, int h)
     {
       super(x, y, w, h, "/Sprites/mangojuice.png", "","/Sprites/juiceoutline.png");
     }

     /**
     * Prints the name of the object (Mango Juice)
     * 
     * @return name of object
     */
     public String toString()
     {
       return "MANGO JUICE";
     }

     /**
     * Fills dialogue to be displayed
     * and adds to inventory
     * 
     * @param textBox textbox for dialogue
     * @param roomNum current room number
     * @param inven the player's inventory
     *
     * @return 0 since juice does not change room number
     */
     public int interact(Dialogue textBox, int roomNum, Inventory inven)
     {
       if (!hasInteracted)
       {
         Queue<String> repeat = new LinkedList<String>();
        repeat.add("NARRATOR--A mango juice box.");
         repeat.add("NARRATOR--It's the only one left on the shelf.");
         repeat.add("BEN--(Hey, isn't this the whole reason I came here for?)");
         repeat.add("NARRATOR--Mango Juice added to your cart.");
        
        dialogue = repeat;
        textBox.startDialogue(dialogue,false);
         inven.add("Mango Juice",new Item("Mango Juice","You were craving some sweet, sweet mango juice just a few hours ago. Now, you're stuck solving everyone's problems, and you can't drink any.","/Sprites/mangojuice.png"));   

         moveHide();
         objects.remove(mango);
         hasInteracted = true;
       }
       return 0;
     }
  }

  /** 
    * The object apple juice which can 
    * be drawn in the graphics window
    */
  public class AppleJuice extends Interactable
  {

    /**
     * Constructs apple juice box with a 
     * specified location, width, 
     * height, number, and linked to puzzle
     *
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     */
    public AppleJuice(int x, int y, int w, int h)
    {
      super(x, y, w, h, "/Sprites/applejuice.png", "","/Sprites/juiceoutline.png");
    }

    /**
     * Fills dialogue to be displayed
     * and adds to inventory
     * 
     * @param textBox textbox for dialogue
     * @param roomNum current room number
     * @param inven the player's inventory
     *
     * @return 0 since juice does not change room number
     */
    public int interact(Dialogue textBox, int roomNum, Inventory inven)
    {
      Queue<String> repeat = new LinkedList<String>();
      repeat.add("NARRATOR--An apple juice box.");
      dialogue = repeat;
      textBox.startDialogue(dialogue,false); 
      return 0;
    }

    /**
     * Prints the name of the object (Apple Juice)
     * 
     * @return name of object
     */
    public String toString()
    {
      return "APPLE JUICE";
    }
  }

  /** 
    * The object orange juice which can 
    * be drawn in the graphics window
    */
  public class OrangeJuice extends Interactable
  {

    /**
     * Constructs orange juice box with a 
     * specified location, width, 
     * height, number, and linked to puzzle
     *
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     */
    public OrangeJuice(int x, int y, int w, int h)
    {
      super(x, y, w, h, "/Sprites/orangejuice.png", "","/Sprites/juiceoutline.png");
    }

    /**
     * Fills dialogue to be displayed
     * and adds to inventory
     * 
     * @param textBox textbox for dialogue
     * @param roomNum current room number
     * @param inven the player's inventory
     *
     * @return 0 since juice does not change room number
     */
    public int interact(Dialogue textBox, int roomNum, Inventory inven)
     {
       Queue<String> repeat = new LinkedList<String>();
        repeat.add("NARRATOR--An orange juice box.");
         repeat.add("BEN--(I hate this brand.)");
         
       if (!hasInteracted)
       {
         repeat.add("NARRATOR--You turn it around and see something peeking out from behind the carton.");
          repeat.add("NARRATOR--Yellow Sticky Note added to your cart.");
         inven.add("Yellow Sticky Notes",new Item("Yellow Sticky Note","4-6-7-5-8\nKEY = 3","/Sprites/stickynote.png"));   
         hasInteracted = true;
       }

       dialogue = repeat;
      textBox.startDialogue(dialogue,false);
       
       return 0;
      
     }

    /**
     * Prints the name of the object (Orange Juice)
     * 
     * @return name of object
     */
    public String toString()
    {
      return "ORANGE JUICE";
    }
  }

  /**
   * The object door leads to the basement
   * and remains locked until Atlas'
   * objectives are complete; can be drawn 
   * in the
   * graphics window.
   */
  public class BasementDoor extends Interactable
  {
    private int side;
    
    /**
     * Constructs a basement door with a specified location, width, 
     * height, image, key, specific dialogue
     *
     * @param x the x location
     * @param y the y location
     * @param w the width
     * @param h the height
     * @param i the image file
     * @param s the side key (determines which room the door
     * leads to)
     */
    public BasementDoor(int x, int y, int w, int h, String i, int s)
    {
      super(x, y, w, h, i, "");
      door = true;
      side = s; //-1 == left, 1 == right
    }

    /**
     * Gives locked message or changes room.
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
      if(inven.containsKey("Basement Key"))
        return side;
      else
      {
        Queue<String> repeat = new LinkedList<String>();
        repeat.add("NARRATOR--Looks like the door is locked.");
        
        dialogue = repeat;
        textBox.startDialogue(dialogue,false);

        return 0;
      }
    }

    /**
     * Prints the name of the object (Basement Door)
     * 
     * @return name of object
     */
    public String toString()
    {
      return "BASEMENT DOOR";
    }
  }




  
}

