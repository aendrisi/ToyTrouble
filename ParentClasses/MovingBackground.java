package ParentClasses;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * Moving Background that can be drawn in a graphics
 * window
 */
public class MovingBackground
  {
    private Image image;
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private int screenWidth;

    /**
     * Constructs moving background with dimensions
     * 
     * @param bgImage background image
     * @param screenW width of screen
     * @param w width of background image
     * @param h height of bg image
     */
    public MovingBackground(String bgImage, int screenW, int w, int h)
      {
        try {
          URL url = getClass().getResource(bgImage);
          image = ImageIO.read(url);
        } catch (Exception e) {}
        screenWidth = screenW;
        xPos = 0;
        yPos = 0;
        width = w;
        height = h;
      }

    /**
     * Moves the background based on Ben's movement
     * 
     * @param direction direction to move
     * @param speed speed to move
     * 
     * @return whether ben can move (screen boundaries)
     */
    public Boolean move(String direction, int speed) {
  		switch(direction)
  		{
  			case "LEFT": 
          if (xPos + width > screenWidth)
          {
            xPos = xPos-speed;
            return true;
          }
  				break;
  			case "RIGHT": 
          if(xPos < 0)
          {
            xPos = xPos+speed;
            return true;
          }
  				break;
  		}
      return false;
    }

    /**
     * Moves camera to other side of room
     *
     * @return new position
     */
    public int moveCameraToEnd()
    {
      xPos -= width-screenWidth;
      return width-screenWidth;
    }

    /**
     * Draws the object in a specified window
     * @param window the graphics window
     */
    public void draw(Graphics window) {
      window.drawImage(image, xPos, yPos, width, height, null);
    }
    
  }