package Rooms;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.util.*;

import Interactable.Benji;
import Interactable.Interactable;
import ParentClasses.Dialogue;
import ParentClasses.MovingBackground;


/**
 * Superclass for all room objects, which is able to draw the room,
 * get all the objects of the room, and get the background of the 
 * room
 */
public abstract class RoomParent extends Canvas{  
  public List<Interactable> objects;
  public MovingBackground background;
  public Benji ben;
  public Boolean specialPaint;
  
  /**
   * Creates a room object, which sets the specialPaint variable to false as default
   */
  public RoomParent() {
    specialPaint = false;
  }

  /**
   * Generic paint method for rooms
   *
   * @param graphToBack window
   * @param textBox dialogue's textbox
   * @param keys array of keys
   * @param width width of screen
   */
  public void paint(Graphics graphToBack, Dialogue textBox, boolean[] keys, int width){}

  public Graphics paintSpecial(Graphics window){
    return null;
  }

  /**
   * Special paint method for rooms without Ben
   *
   * @return special paint??
   */
  public Boolean getSpecial()
  {
    return specialPaint;
  }

  /**
   * Returns list of objects in room
   *
   * @return list of objects in room
   */
  public List<Interactable> getObjects()
  {
    return objects;
  }

  /**
   * Returns ben 
   *
   * @return ben
   */
  public Benji getBen()
  {
    return ben;
  }

  /**
   * Returns background image
   *
   * @return background
   */
  public MovingBackground getBG()
  {
    return background;
  }

}
