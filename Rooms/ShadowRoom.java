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
import Interactable.Sadiya;
import ParentClasses.MovingBackground;

import java.net.URL;


/**
 * Represents the graphic environment of the 
 * Shadow room
 */
public class ShadowRoom extends RoomParent{
  //characters
  private Door doorLeft;
  private Sadiya sadiya;
  
  /**
   * Creates a shadow room object, which contains all the objects and
   * NPCs in the room
   */
  public ShadowRoom() {
    //inven = new Inventory();
    objects = new ArrayList<Interactable>();
    
    background = new MovingBackground("/Sprites/shadow room.png", 800, 2000, 600);
    
    ben = new Benji(75,240,170,340,30);
    doorLeft = new Door(1600, 200, 162, 300, "/Sprites/door.png", -1, false); //left door
    sadiya = new Sadiya(480, 370, 118, 150, "/Sprites/sadiya.png", "sadiyadialogue.rtf",doorLeft);
    objects.add(doorLeft);
    objects.add(sadiya);
  }

}

