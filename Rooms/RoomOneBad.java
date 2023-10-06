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

import Interactable.Atlas;
import Interactable.Benji;
import Interactable.Growl;
import Interactable.Haruki;
import Interactable.Howl;
import Interactable.Interactable;
import Interactable.Mao;
import Interactable.Ophelia;
import ParentClasses.MovingBackground;

import java.net.URL;


/**
 * Represents the graphic environment of room one of the bad
 * ending
 */
public class RoomOneBad extends RoomParent{
  //characters
  public Haruki haru;
  private Mao mao;
  private Howl howl;
  private Growl growl;
  private Atlas atlas;
  private Ophelia ophelia;

  /**
   * Creates a room one bad ending object, which contains all the 
   * objects and NPCs in the room and sets them to their bad end
   * state
   */
  public RoomOneBad() {
    objects = new ArrayList<Interactable>();
    //inven = new Inventory();
    background = new MovingBackground("/Sprites/room1bgbad.png", 800, 1400, 600);
    int bgMove = background.moveCameraToEnd();
    
    ben = new Benji(475,240,170,340,30);
    
    haru = new Haruki(480, 370, 118, 150, "/Sprites/Haruki.png", "",null,"/Sprites/haruoutline.png");
    mao = new Mao(480+128, 370, 118, 150, "/Sprites/mao.png", "",null,"/Sprites/maooutline.png");
    
    howl = new Howl(480+128+130+130,400,120,120,"/Sprites/howl.png","howlDialogue.rtf",null,"/Sprites/howloutline.png");
    growl = new Growl(480+128+130,520-120,120,120,"/Sprites/growl.png","growlDialogue.rtf",null,"/Sprites/growloutline.png");

    atlas = new Atlas(20, 520-138,107,138, "atlasDialogue.rtf","/Sprites/atlasoutline.png");

    ophelia = new Ophelia(20+107+60, 520-150, 150,150, "OpheliaTXT.rtf", null, null, null,"/Sprites/opheliaoutline.png");

    
    objects.add(haru);
    objects.add(mao);
    objects.add(howl);
    objects.add(growl);
    objects.add(atlas);
    objects.add(ophelia);

    for (Interactable obj: objects)
      {
        obj.startBadEnd();
        obj.setX(obj.getX()-bgMove);
      }
  }
  
}

