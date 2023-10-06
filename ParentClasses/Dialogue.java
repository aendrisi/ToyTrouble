package ParentClasses;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.util.Queue;
import java.util.LinkedList;
import javax.swing.JTextArea;
import java.util.ArrayList;

/**
 * Represents both the textbox for dialogue and the glyph puzzle
 * of room 2 that can be drawn in a graphics window
*/
public class Dialogue
  {
    private Image image;
    private Image charImage;
    private Boolean isTalk;
    private Queue<String> dialogue;
    private String[] characters;
    private Image[] pfps;
    private String[] parts;
    private int check;

    private boolean zoom;
    private boolean glyphPuzzle;
    private boolean choice;
    private Image zoomImage;

    //glyph
    private ArrayList<String> answer1;
    private ArrayList<String> answer2;
    private ArrayList<String> answer3;
    private ArrayList<String> answer4;
    private ArrayList<String> answer5;
    private ArrayList<String> answer6;
    private ArrayList<String> attempt;
    private Image select;
    private Image icorrect;
    private Image instructScreen;
    private Image white;

    private boolean aS;
    private boolean bS;
    private boolean cS;
    private boolean dS;
    private boolean eS;

    private boolean correct;
    private boolean incorrect;
    private boolean drawGlyph;

    private boolean finished;

    private boolean instructions;
    
    /**
     * Constructs the textbox containing list of characters 
     * and their icons, as well as the solution for the glyph
     * puzzle 
     * 
     * @param im textbox image
     */
    public Dialogue(String im)
    {
      
      pfps = new Image[9];
      characters = new String[9];
      check = 1;
      try 
        {
          URL url = getClass().getResource(im);
          image = ImageIO.read(url);
          //ben
          url = getClass().getResource("/Sprites/benPFPsample.png");
          pfps[0] = ImageIO.read(url);
          characters[0] = "BEN";

          //haru
          url = getClass().getResource("/Sprites/haruPFPsample.png");
          pfps[1] = ImageIO.read(url);
          characters[1] = "HARUKI";

          //atlas
          url = getClass().getResource("/Sprites/atlaspfp.png");
          pfps[2] = ImageIO.read(url);
          characters[2] = "ATLAS";

          //howl
          url = getClass().getResource("/Sprites/howlpfp.png");
          pfps[3] = ImageIO.read(url);
          characters[3] = "HOWL";

          //ophelia
          url = getClass().getResource("/Sprites/opheliapfp.png");
          pfps[4] = ImageIO.read(url);
          characters[4] = "OPHELIA";

          //sadiya
          url = getClass().getResource("/Sprites/sadiyapfp.png");
          pfps[5] = ImageIO.read(url);
          characters[5] = "SADIYA";

          //aatka
          url = getClass().getResource("/Sprites/aatkapfp.png");
          pfps[6] = ImageIO.read(url);
          characters[6] = "AATKA";

          //mao
          url = getClass().getResource("/Sprites/maopfp.png");
          pfps[7] = ImageIO.read(url);
          characters[7] = "MAO";

          //growl
          url = getClass().getResource("/Sprites/growlpfp.png");
          pfps[8] = ImageIO.read(url);
          characters[8] = "'GROWL'";
          
        } catch (Exception e) {
        	System.out.println(e.getMessage() + " error in Dialogue");
        }
      isTalk = false;
      charImage = image;
      //glyph
      glyphPuzzle = false;
      answer1 = new ArrayList<String>();
      answer1.add("A");
      answer1.add("C");
      answer1.add("E");
      answer2 = new ArrayList<String>();
      answer2.add("A");
      answer2.add("E");
      answer2.add("C");
      answer3 = new ArrayList<String>();
      answer3.add("E");
      answer3.add("C");
      answer3.add("A");
      answer4 = new ArrayList<String>();
      answer4.add("C");
      answer4.add("A");
      answer4.add("E");
      answer5 = new ArrayList<String>();
      answer5.add("C");
      answer5.add("E");
      answer5.add("A");
      answer6 = new ArrayList<String>();
      answer6.add("E");
      answer6.add("A");
      answer6.add("C");
      attempt = new ArrayList<String>();
      aS = bS = cS = dS = eS = false;

      choice = false;
    }

    /**
     * Starts dialogue by setting flag to true and passing the 
     * the dialogue from the object to the textbox. Also zooms
     * in on an object.
     * 
     * @param text the dialogue
     * @param d true if it zooms in on an object
     */
    public void startDialogue(Queue<String> text, boolean d)
    {
      isTalk = true;
      dialogue = text;
      zoom = d;
    }

    /**
     * Returns if textbox should be displaying dialogue
     *
     * @return true when textbox should display dialogue
     */
    public Boolean isDialogueMode()
    {
      return isTalk;
    }


    //glyph puzzle stuff

    /** 
     * Returns whether glyph puzzle is active
     *
     * @return true if puzzle is active
     */
    public boolean isGlyphPuzzle()
    {
      return glyphPuzzle;
    }

    /** 
     * Starts the glyph puzzle and instantiates all necessary
     * images
     *
     * @return if glyph puzzle is completed
     */
    public boolean startGlyph()
    {
      if(!finished)
      {
        glyphPuzzle = true;
        instructions = false;
        
        try {
          URL url = getClass().getResource("/Sprites/glyph puzzle.png");
          zoomImage = ImageIO.read(url);
          
          url = getClass().getResource("/Sprites/selected.png");
          select = ImageIO.read(url);
  
          url = getClass().getResource("/Sprites/glyph puzzle fin.png");
          icorrect = ImageIO.read(url);
  
          url = getClass().getResource("/Sprites/glyph instructions.png");
          instructScreen = ImageIO.read(url);
  
          url = getClass().getResource("/Sprites/white.png");
          white = ImageIO.read(url);
        } catch (Exception e) {}
        
        return true;
      }
      else
        return false;

    }

    /** 
     * Returns whether the glyph puzzle is completed
     *
     * @return true if the glyph puzzle is completed
     */
    public boolean glyphState()
    {
      return finished;
    }

    /** 
     * Returns whether the glyph puzzle is displaying 
     * instructions
     *
     * @return true if puzzle is displaying instructions
     */
    public boolean isInstructions()
    {
      return instructions;
    }

    /** 
     * Puzzle displays instructions by setting flag to true
     */
    public void showInstructions()
    {
      instructions = true;
    }

    /** 
     * Puzzle hides instructions by setting flag to false
     */
    public void hideInstructions()
    {
      instructions = false;
    }


    /** 
     * Adds a glyph to player's attempt list 
     * @param add glyph to add
     */
    public void addGlyph(String add)
    {
      if(!attempt.contains(add))
      {
        attempt.add(add);
        switch (add)
        {
          case "A": aS = true;
            break;
          case "B": bS = true;
            break;
          case "C": cS = true;
            break;
          case "D": dS = true;
            break;
          case "E": eS = true;
            break;
        }
      }
      else
      {
        attempt.remove(add);
        switch (add)
        {
          case "A": aS = false;
            break;
          case "B": bS = false;
            break;
          case "C": cS = false;
            break;
          case "D": dS = false;
            break;
          case "E": eS = false;
            break;
        }
      }
      //System.out.println(attempt);
    }

    /** 
     * Checks whether player's attempt is correct
     *
     * @return whether player is correct or not
     */
    public boolean checkGlyph()
    {
      if(attempt.equals(answer1) || attempt.equals(answer2) || attempt.equals(answer3) || attempt.equals(answer4) || attempt.equals(answer5) || attempt.equals(answer6))
        return true;
      else
        return false;
    }


    /** 
     * Returns the player's attempt list
     * 
     * @return attempt list
     */
    public String attemptString()
    {
      return attempt.toString();
    }

    /** 
     * Resets the glyph
     * 
     */
    public void resetGlyph()
    {
      attempt.clear();

      aS = false;
      bS = false;
      cS = false;
      dS = false;
      eS = false;
      correct = false;
      incorrect = true;
    }

    /** 
     * Exits the glyph puzzle
     */
    public void escGlyphPuzzle()
    {
      glyphPuzzle = false;
    }

    /** 
     * Sets up to close glyph puzzle
     */
    public void correctGlyph()
    {
      finished = true;
      correct = true;
      incorrect = false;
    }

    /** 
     * Progress dialogue, exits dialogue, or exits zoom in
     */
    public void next()
    {
      if(zoom)
        isTalk = false;
      else if (dialogue.peek() != null)
      {
        dialogue.remove(); 
        pfp();
      }
      else
        isTalk = false;
    }

    /** 
     * Sets the image to be zoomed in on
     *
     * @param img the iamge to be zoomed in on
     */
    public void setZoomImage(String img)
    {
      try {
        URL url = getClass().getResource(img);
        zoomImage = ImageIO.read(url);
      } catch (Exception e) {}
      
    }

    /** 
     * Sets the icon of the character speaking on the textbox
     */
    public void pfp()
    {
      for (int i = 0; i < characters.length; i++)
          {
            if (characters[i].compareTo(parts[0]) == 0)
            {
              charImage = pfps[i];
              check = i;
              break;
            }
            else
              charImage = image;
          }
    }

    /** 
     * Checks whether puzzle has been drawn or not
     */
    public void drawGlyph()
    {
      drawGlyph = false;
    }



    /**
     * Draws the textbox, zoomed in image, or glyph puzzle
     * in a specified Graphics window
     * 
     * @param window the Graphics window
     */
    public void draw(Graphics window) {
      if(instructions)
        window.drawImage(instructScreen,0,0,800,600,null);
      else if(glyphPuzzle)
      {
        window.drawImage(zoomImage,0,0,800,600,null);
        if (aS)
          window.drawImage(select,230,280,87,87,null);
        if (bS)
          window.drawImage(select,420,280,87,87,null);
        if (cS)
          window.drawImage(select,420+190,265,87,87,null);
        if (dS)
          window.drawImage(select,230,480,87,87,null);
        if (eS)
          window.drawImage(select,420,480,87,87,null);
        if(correct)
        {
          window.drawImage(icorrect,0,0,800,600,null);
        }
      }
      else if (isTalk)
      {
        if (zoom)
          window.drawImage(zoomImage,50,50,700,500,null);
        else
        {
          window.drawImage(image, 160, 5, 800-10-155, 150, null);
  
          if (dialogue.peek() != null)
          {
            parts = (dialogue.peek()).split("--");
  
            pfp();
  
            window.drawImage(charImage, 5, 5, 150, 150, null);
            
            JTextArea ta = new JTextArea(parts[1]);
            ta.setLineWrap(true);
            ta.setWrapStyleWord(true);
            ta.setBounds(200, 60, 550, 50);
            ta.setForeground(Color.black);
            ta.setFont(new Font("Arial Black", Font.BOLD, 15));
            Graphics g2 = window.create(200, 60, 550, 50);
            ta.paint(g2);
            window.setFont(new Font("Arial Black", Font.BOLD, 20));
            window.drawString(parts[0], 190, 50);
          }          
        }
      }
    }
  }