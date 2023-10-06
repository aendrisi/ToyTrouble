package Rooms;
import java.awt.Color;
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

import Interactable.Atlas;
import Interactable.Benji;
import Interactable.Door;
import Interactable.Growl;
import Interactable.Howl;
import Interactable.Interactable;
import ParentClasses.Dialogue;
import ParentClasses.Inventory;
import ParentClasses.MovingBackground;

import java.net.URL;
import java.io.File;

/**
 * Represents the graphic environment room
 * 2 in the good end state
 */
public class RoomTwoGood extends RoomParent {
  //characters
  public Atlas atlas;
  public Howl howl;
  private Growl growl;

  //objects
  private Door doorLeft;
  private Door doorRight;
  private Board board;
  private Inventory inven;

  /**
   * Creates a room 2 object, which 
   * contains all the objects and NPCs
   * in the room and sets them to their
   * good end state
   */
  public RoomTwoGood(Inventory inventory) {
    inven = inventory;
    background = new MovingBackground("/Sprites/room2DRAFT.png", 800, 2200, 600);
    int bgMove = background.moveCameraToEnd();
    ben = new Benji(475,240,170,340,30);    
    objects = new ArrayList<Interactable>();
    atlas = new Atlas(350, 225,107,138, "atlasDialogue.rtf","/Sprites/atlasoutline.png");
    
    doorLeft = new Door(10,190, 150,50,"/Sprites/exitsign.png", -1,true,"/Sprites/exitsignoutline.png","");
    doorRight = new Door(1855, 200, 300, 100,"/Sprites/drinksign.png", 1,true,"/Sprites/drinksignoutline.png","");
    howl = new Howl(1370,380,120,120,"/Sprites/howl.png","howlDialogue.rtf",doorRight,"/Sprites/howloutline.png");
    growl = new Growl(1370-130,380,120,120,"/Sprites/growl.png","growlDialogue.rtf",doorRight,"/Sprites/growloutline.png");
  
    board = new Board(650,180,269,169,"","/Sprites/boardoutline.png");

    objects.add(atlas);
    objects.add(howl);
    objects.add(growl);
    objects.add(doorLeft);
    objects.add(doorRight);
    objects.add(board);

    for (Interactable obj: objects)
      {
        obj.startGoodEnd();
        obj.setX(obj.getX()-bgMove);
      }
  }

  // public Howl getHowl()
  // {
  //   return howl;
  // }

  

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
