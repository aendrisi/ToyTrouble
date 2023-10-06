package Interactable;

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * Represents a moving Benji that can be drawn in a graphics window.
 */
  public class Benji extends Interactable
  {
  private int speed;
  private Image[] walkAnimation;
  private int walk;


  /**
   * Constructs a Benji at a specified location with a specified speed, width and
   * height.
   * 
   * @param x the x location
   * @param y the y location
   * @param w the width
   * @param h the height
   * @param s the speed
   */
  public Benji(int x, int y, int w, int h, int s) {
    super(x, y, w, h, "", "");
    speed = s;
    walkAnimation = new Image[17];
    walk = 0;
    String file = "";

    try {
      URL url;

      for (int i = 0; i<17; i++)
        {
          file = "/Sprites/aben" + i + ".png";
          url = getClass().getResource(file);
          walkAnimation[i] = ImageIO.read(url);
        }
      image = walkAnimation[0];
      
    } catch (Exception e) {
      System.out.println("Error at " + file);
    }
  }

  /**
   * Makes Ben face the screen when he's not moving.
   */
  public void forward()
    {
      walk = 0;
      image = walkAnimation[walk];
    }

  /**
   * Changes Ben's walk cycle when moving to the right.
   */
  public void right()
    {
      if (walk < 8)
          walk++;
        else
          walk = 1;
      image = walkAnimation[walk];
    }

    /**
     * Changes Ben's walk cycle when moving to the left.
     */
    public void left()
    {
      if (walk >= 8 && walk<16)
          walk++;
        else
          walk = 9;
      image = walkAnimation[walk];
    }


  /**
   * Adjusts the x and y of the Benji based on a specified direction, and the speed
   * at which the Benji is moving. Benjis can move LEFT or RIGHT
   * 
   * @param direction the direction in which to move
   */
  public void move(String direction, int screenW) {
		switch(direction)
		{
			case "LEFT": 
        if (xPos > 0)
          xPos = xPos-speed;
        left();
				break;
			case "RIGHT": 
        if (xPos < screenW - width - 10)
          xPos = xPos+speed;
        right();
				break;
		}
  }

  /**
   * Returns Ben's speed
   * 
   * @return Ben's speed
   */
  public int getSpeed()
  {
      return speed;
    }

    
  /**
   * Draws a Benji in a specified Graphics window
   * 
   * @param window the Graphics window
   */
  public void draw(Graphics window) {
      window.drawImage(image, xPos, yPos, width, height, null);
  }

  /**
   * Prints the name of the NPC (Atlas)
   * 
   * @return name of NPC
   */
  public String toString()
  {
      return "BEN";
    }



}