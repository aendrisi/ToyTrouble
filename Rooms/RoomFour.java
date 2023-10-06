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
import Interactable.VendingMachine;
import ParentClasses.MovingBackground;

import java.net.URL;


/**
 * Represents the graphic environment of room 4
 */
public class RoomFour extends RoomParent{
  //characters
  private Door doorLeft;
  private VendingMachine boss;
  //private Inventory inven;
  
  /**
   * Creates a room one object, which contains all the objects and
   * NPCs in the room
   */
  public RoomFour() {
    //inven = new Inventory();
    objects = new ArrayList<Interactable>();
    background = new MovingBackground("/Sprites/room4.png", 800, 1400, 600);
    ben = new Benji(75,250,170,340,30);
    boss = new VendingMachine (1000, 150, 200, 400, "/Sprites/boss.png");
    doorLeft = new Door(105, 115, 180, 190,"/Sprites/door.png", -2,true);
    objects.add(boss);
    objects.add(doorLeft);

    
  }
}

