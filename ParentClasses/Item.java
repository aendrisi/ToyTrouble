package ParentClasses;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

/**
 * The object item to be stored in the inventory, and that can be
 * drawn in a graphics window.
 */
public class Item
{
  private String name;
  private String description;
  private Image image;

  /**
   * Contructs a item
   * 
   * @param n name
   * @param d description
   * @param i image 
   */
  public Item(String n, String d, String i)
  {
    name = n;
    description = d;

    try {
      URL url = getClass().getResource(i);
      image = ImageIO.read(url);
    } catch (Exception e) {}
  }

  /**
   * Returns name of item
   * @return name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Returns description of item
   * @return description
   */
  public String getDesc()
  {
    return description;
  }

  /**
   * Returns image of item
   * @return image
   */
  public Image getImage()
  {
    return image;
  }

  /**
   * Sets the name of the item
   * @param n name
   */
  public void setName(String n)
  {
    name = n;
  }

  /**
   * Sets the description of the item
   * @param d description
   */
  public void setDesc(String d)
  {
    description = d;
  }

  /**
   * Sets the image of the item
   * @param i image
   */
  public void setImage(String i)
  {
    try {
      URL url = getClass().getResource(i);
      image = ImageIO.read(url);
    } catch (Exception e) {}
  }
}

  