/**
 * <Mushroom class - defines the mushroom and its random variables>
 *
 * @author <Andrew Kirkham>
 * @version <Created: 4/30/11, Modified: >
 */
package centipede;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Mushroom extends GameObject {

    /**
     * Create a mushroom
     * @param xPos  x position
     * @param yPos y position
     * @param height Height of mushroom
     * @param width Width of mushroom
     * @param health Health of mushroom
     * @param img Image of mushroom
     */
    public Mushroom(final int xPos, final int yPos, final int width, final int height, final int health, final String img) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.img = getImage(img);
        this.rect = new Rectangle(xPos, yPos, width, height);
        this.health = health;


    }

    /**
     * <Draws the instance of mushroom>
     *
     * @param <graphics g>
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, xPos, yPos, width, height, null);

    }

    /**
     * <creates mushrooms randomly based on the math random class>
     *
     * @param <Display and id>
     */
    @Override
    void update(final Display display, final int id) {

    }

    /**
     * <gets the image for the mushroom>
     *
     * @param <String img>
     * @return <Toolkit.getDefaultToolkit().getImage(img)>
     */
    @Override
    Image getImage(String img) {
        return Toolkit.getDefaultToolkit().getImage(img);
    }
}
