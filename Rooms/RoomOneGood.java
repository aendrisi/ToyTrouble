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
import Interactable.Mao;
import ParentClasses.MovingBackground;

import java.net.URL;


/**
 * Represents the graphic environment of room one of the good
 * ending
 */
public class RoomOneGood extends RoomParent{
  //characters
  public Haruki haru;
  private Mao mao;
  private Door doorRight;
  
  
  /**
   * Creates a room one good ending object, which contains all the 
   * objects and NPCs in the room and sets them to their good end
   * state
   */
  public RoomOneGood() {
    objects = new ArrayList<Interactable>();
    background = new MovingBackground("/Sprites/room1bg.png", 800, 1400, 600);
    int bgMove = background.moveCameraToEnd();
    
    ben = new Benji(475,240,170,340,30);
    doorRight = new Door(1075, 200, 162, 300,"/Sprites/door.png", 1,true); //right door
    haru = new Haruki(480, 370, 118, 150, "/Sprites/Haruki.png", "harukidialogue.rtf",null,"/Sprites/haruoutline.png");
    mao = new Mao(480+128, 370, 118, 150, "/Sprites/mao.png", "",null,"/Sprites/maooutline.png");
    objects.add(haru);
    objects.add(mao);
    objects.add(doorRight);
    
    for (Interactable obj: objects)
      {
        obj.startGoodEnd();
        obj.setX(obj.getX()-bgMove);
      }
  }
  
}

