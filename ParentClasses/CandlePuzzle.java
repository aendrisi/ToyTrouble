package ParentClasses;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.*;

/**
 * The candle puzzle handler for Room 3.
 */
public class CandlePuzzle 
{
  private ArrayList<Integer> candleOrder;
  private ArrayList<Integer> key;
  private Boolean puzzleActive;

  /**
   * Constructs a candle puzzle with an answer key.
   *
   * @param candleOrderKey the puzzle's solution
   */
  public CandlePuzzle(ArrayList<Integer> candleOrderKey)
  {
    candleOrder = new ArrayList<Integer>();
    key = candleOrderKey;
    puzzleActive = false;
  }

  /**
   * Adds candle to player's attempt list
   *
   * @param num the candle's assigned number
   */
  public void addCandle(int num)
  {
    candleOrder.add(num);
  }

  /**
   * Checks to see if player's attempt list matches the key
   *
   * @return true if the attempt matches the key
   */
  public Boolean isSolved()
  {
    return candleOrder.equals(key);
  }

  /**
   * Clears the player's attempt list
   */
  public void clear()
  {
    candleOrder.clear();
  }

  /** 
   * Checks if the puzzle is active
   *
   * @return true when puzzle is active
   */
  public Boolean isPuzzleActive()
  {
    return puzzleActive;
  }

  /**
   * Starts the puzzle by changing its flag to true
   */
  public void startPuzzle()
  {
    puzzleActive = true;
  }

  /**
   * Ends puzzle by changing its flag to false.
   */
  public void finishPuzzle()
  {
    puzzleActive = false;
  }

  
}