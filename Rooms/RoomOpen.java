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

import ParentClasses.*;
import Interactable.*;

import java.net.URL;


/**
 * Represents the graphic environment of the start menu
 */
public class RoomOpen extends RoomParent{
  //characters
  public Door startButton;
  public BufferedImage back;

  /**
   * Creates a room open object, which contains intructions and a button to
   * start the game
   */
  public RoomOpen() {
    objects = new ArrayList<Interactable>();
    background = new MovingBackground("/Sprites/opening.png", 600, 800, 600);
    ben = new Benji(300,270,150,300,30);
    startButton = new Door(250, 480, 250, 70, "/Sprites/tempStart3.png", 1, true);
    objects.add(startButton);

    specialPaint = true;
  }

  /**
   * Draws the room without Ben
   *
   * @param graphToBack the graphics window
   */
  public Graphics paintSpecial(Graphics graphToBack) {
      background.draw(graphToBack);
      startButton.draw(graphToBack);
    return graphToBack; 
  }
    
}
