package Rooms;
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

import Interactable.Benji;
import Interactable.Door;
import Interactable.Interactable;
import ParentClasses.MovingBackground;

import java.net.URL;


/**
 * Represents the graphic environment of good end's room 4
 */
public class RoomFourGood extends RoomParent{
  private Door doorLeft;
  
  /**
   * Creates a room 4 good ending object, which contains all the 
   * objects and NPCs in the room and sets them to their good end
   * state
   */
  public RoomFourGood() {
    //inven = new Inventory();
    background = new MovingBackground("/Sprites/room4.png", 800, 1400, 600);
    ben = new Benji(75,250,170,340,30);
    doorLeft = new Door(105, 115, 180, 190,"/Sprites/door.png", -1,true);
    objects = new ArrayList<Interactable>();
    objects.add(doorLeft);

    for (Interactable obj: objects)
      {
        obj.startGoodEnd();
      }
  }
}

