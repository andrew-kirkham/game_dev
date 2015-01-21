/**
 * <Bullet class - defines the bullets and its movement variables. also defines bullets to
 * increment score and to take away life points>
 *
 * @author <Andrew Kirkham>
 * @version <Created: 4/19/11, Modified: date - description>
 */
package centipede;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Bullet extends GameObject {

    private Ship ship; //calls the instance of ship
    private Centipede centipede; //calls the instance of centipede
    private int deltaY; //defines deltaY - the variable to be used in bullet travel

    /**
     * Constructs a bullet
     * @param ship
     * @param deltaY
     * @param xPos
     * @param yPos
     * @param width
     * @param height
     * @param img
     */
    public Bullet(final Ship ship, final Centipede centipede, final int deltaY, final int xPos, final int yPos, final int width, final int height, final String img) {
        this.ship = ship;
        this.centipede = centipede;
        this.deltaY = deltaY;
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.rect = new Rectangle(xPos, yPos, width, height);
        this.img = getImage(img);


    }

    /**
     * <Draws the instances of bullets>
     *
     * @param <graphics g>
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, xPos, yPos, width, height, null);
    }

    /**
     * <updates the bullet array to remove instance upon collision or exit of screen
     * also increments score and level
     * if no collision detected bullet continues as normal>
     *
     * @param <Display and id>
     */
    @Override
    void update(final Display display, final int id) {
        if (rect.intersects(centipede.rect)) { //change to centipede.rect in order to get to collide with bullets
            centipede.setHealth(0);
            display.score++; //adds score when centipede is hit by bullet
            display.bullets.remove(this); //removes that instance of Bullet when it collides with something
        } else if (yPos < 0) {
            display.bullets.remove(this); //removes instance of bullet if it goes off screen
        } else {
            yPos += deltaY; //moves image up if no collision is detected
            rect.y -= deltaY; //moves collision rectangle up if no collision detected
        }
    }

    /**
     * <gets the image for the bullet>
     *
     * @param <String img>
     * @return <Toolkit.getDefaultToolkit().getImage(img)>
     */
    @Override
    Image getImage(String img) {
        return Toolkit.getDefaultToolkit().getImage(img);
    }

    /**
     * <getter for deltaY>
     *
     * @return <deltaY>
     */
    public int getDeltaY() {
        return deltaY;
    }

    /**
     * <setter for deltaY>
     *
     * @return <deltaY>
     */
    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    /**
     * <getter for ship>
     *
     * @return <ship>
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * <setter for ship>
     *
     * @return <ship>
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
