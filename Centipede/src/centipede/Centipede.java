/**
 * <Centipede class - defines teh variables for centipede>
 *
 * @author <Andrew Kirkham>
 * @version <Created: 4/19/11, Modified: date - description>
 */
package centipede;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Centipede extends GameObject {

    private Ship ship;
    private int currentDir = 0; //initial direction of centipede
    private int steps = 580; //steps that the centipede takes on the board
    private int row = 0; //defines the row number for the centipede to know when to reverse movement

    /**
     * Creates a Centipede
     * @param xPos X position
     * @param yPos Y position
     * @param height Height of Centipede
     * @param width Width of Centipede
     * @param health Health of Centipede
     * @param img Image of Centipede
     */
    public Centipede(final int xPos, final int yPos, final int width, final int height, final int health, final String img) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.img = getImage(img);
        this.rect = new Rectangle(xPos, yPos, width, height);
        this.health = health;


    }

    /**
     * <Draws the instance of centipede>
     *
     * @param <graphics g>
     */
    @Override
    void draw(Graphics g) {
        g.drawImage(img, xPos, yPos, width, height, null); //draws the centipede
    }

    /**
     * <updates the centipede to move according to the boundaries - when one boundary is hit
     * the centipede will move down and then move in the opposite direction>
     *
     * @param <Display and id>
     */
    @Override
    void update(final Display display, final int id) {

        if (currentDir == 0) {
            xPos += 1; // moves centipede right
            rect.x += 1;
        } else if (currentDir == 1) {
            yPos += 10; //moves centipede down
            rect.y += 10;
        } else if (currentDir == 2) {
            xPos -= 1; // moves centipede left
            rect.x -= 1;
        } else if (currentDir == 3) {
            yPos += 10; // moves centipede down
            rect.y += 10;
        }

        steps--; //increments steps negatively until the loop is called on

        if (steps < 0) { //
            currentDir += 1; //adds 1 to the direction counter
            if (currentDir == 0) { //moves right if direction is 0
                steps = 580;
            } else if (currentDir == 1) { //moves down if direction is 1
                steps = 1;
            } else if (currentDir == 2) { //moves left if direction is 2
                steps = 580;
            } else if (currentDir == 3) { //moves down if direction is 3
                steps = 1;
            } else if (currentDir == 4) { //resets the loop if direction reaches 4
                currentDir = 0; //resets the loop
                steps = 580;
            }
        }

//        if (rect.intersects(ship.rect)) { //ship is destroyed if centipede touches ship
//            ship.setHealth(0);
        //   }
    }

    /**
     * <gets the image for the centipede>
     *
     * @param <String img>
     * @return <Toolkit.getDefaultToolkit().getImage(img)>
     */
    @Override
    Image getImage(String img) {
        return Toolkit.getDefaultToolkit().getImage(img);
    }
}
