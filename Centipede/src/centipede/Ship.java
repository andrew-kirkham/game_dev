/**
 * <Ship class - defines the ship and its movement variables>
 *
 * @author <Andrew Kirkham>
 * @version <Created: 4/19/11, Modified: 4/30/11 - added ability for ship to move up/down>
 */
package centipede;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Ship extends GameObject {

    /**
     * Create a ship
     * @param xPos  x position
     * @param yPos y position
     * @param height Height of player
     * @param width Width of player
     * @param health Health of player
     * @param img Image of player
     */
    public Ship(final int xPos, final int yPos, final int width, final int height, final int health, final String img) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.img = getImage(img);
        this.rect = new Rectangle(xPos, yPos, width, height);
        this.health = health;


    }

    /**
     * <Draws the instance of ship>
     *
     * @param <graphics g>
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, xPos, yPos, width, height, null);

    }

    /**
     * <updates the ship to move left, right, up, or down based on user input and constant updating
     * of the boundaries on the left and right as well as an invisible top and bottom boundary of the board>
     *
     * @param <Display and id>
     */
    @Override
    void update(final Display display, final int id) {
        if (id == 1) {
            if (display.playerLeft) { //moves player left as long as the left key is depressed and ship is not at the left boundary
                if (!(xPos < 5)) { //left boundary
                    xPos--; //move ship left
                    rect.x--; //moves collision rectangle with the ship
                }
            } else if (display.playerRight) { //moves player right as long as the right key is depressed and ship is not at the right boundary
                if (!(xPos > display.getWidth() - 25)) { //right boundary
                    xPos++; //move ship right
                    rect.x++; //moves collision rectangle with the ship
                }
            } else if (display.playerUp) { //moves player up with as long as the up key is depressed and ship is not at the up boundary
                if (!(yPos < 300)) { //up boundary
                    yPos--; //move ship up
                    rect.y--; //moves collision rectangle with the ship
                }
            } else if (display.playerDown) { //moves player down with as long as the down key is depressed and ship is not at the down boundary
                if (!(yPos > display.getHeight() - 60)) { //down boundary
                    yPos++; //move ship down
                    rect.y++; //moves collision rectangle with the ship
                }
            }
        }
    }

    /**
     * <gets the image for the ship>
     *
     * @param <String img>
     * @return <Toolkit.getDefaultToolkit().getImage(img)>
     */
    @Override
    Image getImage(String img) {
        return Toolkit.getDefaultToolkit().getImage(img);
    }
}
