/**
 * <Main class that creates instance of bullets, centipede, ship etc and displays them
 * on a graphical board>
 *
 * References: Daniel Polfer - Level and difficulty prompt
 *
 * @author <Andrew Kirkham>
 * @version <Created: 4/19/11, Modified: 4/30/11 - added level and difficulty prompt>
 */
package centipede;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Display extends JFrame implements KeyListener {

    private Ship player; //Create an instance of ship called player
    private Centipede centipede; //Create an instance of centipede called centipede
    private Mushroom mushroom; //Create an instance of mushroom called mushroom
    private Spider spider; //Create an instance of spider called spider
    private Image image; //defines the image from the image library
    private Graphics graphics; //defines teh graphics from the graphics library
    public boolean playerLeft = false; //defines the initial player to be move left to be false
    public boolean playerRight = false; //defines the initial player to be move right to be false
    public boolean playerUp = false; //defines the initial player to be mvoe up to be false
    public boolean playerDown = false; //defines the initial player to be move down to be false
    public int score = 0; //defines the initial score to be 0
    int startlevel = 1; //defines the initial level to be 1
    CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<Bullet>(); // creates the bullet array list

    /**
     * <creates a new instance of display>
     *
     */
    public Display(int level, final int difficulty) {
        setTitle("Centipede"); //titles the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends the program when it is exited out
        setSize(600, 450); //sets the pixel size of the JFrame
        setResizable(false); //does not allow resizing
        addKeyListener(this); //adds the KeyListener
        setVisible(true); //allows the user to see the JFrame
//        if (level == 0) { //sets infinite levels if level is set to 0
//            level = 1000;
//            while (level > startlevel) { //while loop to keep game running based on level count
//                player = new Ship(380, 375, 20, 20, 1, "images/player.gif"); //creates an instance of ship at the given coordinates with the given image
//                centipede = new Centipede(3, 25, 20, 20, difficulty, "images/centipede.gif"); //creates an instance of centipede at the given coordinates with the given image
//            }
//        } else { //if levels is not set to infinite then game will only run for as many levels as desired
//            while (level > startlevel) { //while loop
//        player = new Ship(380, 375, 20, 20, 1, "images/player.gif"); //creates an instance of ship at the given coordinates with the given image
//        centipede = new Centipede(3, 25, 20, 20, difficulty, "images/centipede.gif"); //creates an instance of centipede at the given coordinates with the given image

        player = new Ship(380, 375, 20, 20, 1, "images/player.gif"); //creates an instance of ship at the given coordinates with the given image
        centipede = new Centipede(3, 25, 20, 20, difficulty, "images/centipede.gif"); //creates an instance of centipede at the given coordinates with the given image
        //Centipede length[] = new Centipede[difficulty];
        //for (int i = 0; i < difficulty; i++) {
        //length[i] = new Centipede(3 + 20 * i, 25, 20, 20, difficulty, "images/centipede.gif"); //creates an instance of centipede at the given coordinates with the given image
        //}
        mushroom = new Mushroom(200, 200, 20, 20, 1, "images/mushroom.gif"); //creates an instance of mushroom at the given coordinates with the given image
        spider = new Spider(300, 250, 21, 21, 1, "images/spider.gif"); //creates an instance of spider at the given coordinates with the given image
    }

    /**
     * <repaints the graphics image and creates a second image for double buffering>
     *
     * @param <Graphics g>
     */
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight()); //creates new image for double buffer
        graphics = image.getGraphics();

        paintComponent(graphics);
        g.drawImage(image, 0, 0, null);
        repaint();
    }

    /**
     * <draws the player, centipede and the score/health/level strings
     * displays a win or loss message depending on health variables
     * draws bullets only as long as the player is alive>
     *
     * @param <Graphics g>
     */
    public void paintComponent(Graphics g) { //double buffering
        if (player.getHealth() > 0) { //as long as player is alive allow shooting
            for (Bullet bullet : bullets) { //for each loop
                bullet.draw(g); //draw bullets
                bullet.update(this, 0); //updates the bullets
            }
        } else if (player.getHealth() == 0) {
            g.drawString("Game Over", 300, 200); //display game over if player health is 0
        } else if (centipede.getHealth() == 0) {
            g.drawString("You win!", 300, 200);
            startlevel++;//display 'you win' or change level if centipede is dead
        }
        player.draw(g); //draw player
        player.update(this, 1); //update player and gives the player id 1
        centipede.draw(g); //draw centipede
        centipede.update(this, 2); //update centipede and gives the player id 2
        mushroom.draw(g); //draw mushroom
        mushroom.update(this, 3); //update mushroom and gives the player id 3
        spider.draw(g); //draw spider
        spider.update(this, 4); //update spider and gives the player id 4
        g.drawString("Score: " + score, 25, 425); //adds the score display
        g.drawString("Level: " + startlevel, 500, 425); //displays current user level

    }

    /**
     * <keyTyped method from keyListener - unused but required for keyListener>
     *
     * @param <KeyEvent e>
     */
    @Override
    public void keyTyped(KeyEvent e) {//unused but required for KeyListener
    }

    /**
     * <keyPressed method from keyListener - moves the player when keys are pressed>
     *
     * @param <KeyEvent e>
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) { //moves ship left
            playerLeft = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //moves ship right
            playerRight = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) { // moves ship up
            playerUp = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { //moves ship down
            playerDown = true;
        }
    }

    /**
     * <KeyReleased method from keyListener - stops moving player when keys are released
     * also creates an instance of bullet when the space bar is released>
     *
     * @param <KeyEvent e>
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) { //stops ship from moving ship left
            playerLeft = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //stops ship from moving ship right
            playerRight = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { //stops ship from moving down
            playerDown = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) { //stops ship from moving up
            playerUp = false;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) { //bullets
            Bullet shipBullet = new Bullet(player, centipede, -1, player.getXPos() + 10, player.getYPos() + 20, 4, 7, "images/bullet.gif"); //bullets image
            bullets.add(shipBullet); //creates a new instance of bullet when space bar is released
        }
    }

    /**
     * <main method - allows user to input difficulty and level and then creates a new
     * display based off these inputs>
     *
     * @param <String[] args>
     */
    public static void main(String[] args) {
        int level = Integer.parseInt(JOptionPane.showInputDialog("Number of levels (Enter 0 for infinite):")); //asks for user input for number of levels
        int difficulty = Integer.parseInt(JOptionPane.showInputDialog("Difficulty:")); //asks for user input for difficulty
        new Display(level, difficulty); //creates a new instance of display using the difficulty and level parameters

    }

    /**
     * <getter for centipede>
     *
     * @return <centipede>
     */
    public Centipede getCentipede() {
        return centipede;
    }

    /**
     * <setter for centipede>
     *
     * @return <centipede>
     */
    public void setCentipede(Centipede centipede) {
        this.centipede = centipede;
    }

    /**
     * <getter for player>
     *
     * @return <player>
     */
    public Ship getPlayer() {
        return player;
    }

    /**
     * <setter for player>
     *
     * @return <player>
     */
    public void setPlayer(Ship player) {
        this.player = player;
    }
}
