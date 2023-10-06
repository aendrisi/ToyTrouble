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
import Interactable.Haruki;
import Interactable.Interactable;
import ParentClasses.MovingBackground;
import java.net.URL;


/**
 * Represents the graphic environment of room one
 */
public class RoomOne extends RoomParent{
  //characters
  public Haruki haru;
  private Door doorRight;
  
  
  /**
   * Creates a room one object, which contains all the objects and
   * NPCs in the room
   */
  public RoomOne() {
    objects = new ArrayList<Interactable>();
    //inven = new Inventory();
    background = new MovingBackground("/Sprites/room1bg.png", 800, 1400, 600);
    
    
    ben = new Benji(75,240,170,340,30);
    doorRight = new Door(1075, 200, 162, 300,"/Sprites/door.png", 1,false,"BEN--(Wait, what's that hiding beside the building?"); //right door
    haru = new Haruki(480, 370, 118, 150, "/Sprites/Haruki.png", "harukidialogue.rtf",doorRight,"/Sprites/haruoutline.png");
    objects.add(haru);
    objects.add(doorRight);
  }
  
}

