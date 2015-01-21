/**
 * <Spider class - defines the spider and its random variables>
 *
 * @author <Andrew Kirkham>
 * @version <Created: 4/30/11, Modified: >
 */
package centipede;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Spider extends GameObject {

    /**
     * Create a spider
     * @param xPos  x position
     * @param yPos y position
     * @param height Height of spider
     * @param width Width of spider
     * @param health Health of spider
     * @param img Image of spider
     */
    public Spider(final int xPos, final int yPos, final int width, final int height, final int health, final String img) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.img = getImage(img);
        this.rect = new Rectangle(xPos, yPos, width, height);
        this.health = health;


    }

    /**
     * <Draws the instance of spider>
     *
     * @param <graphics g>
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, xPos, yPos, width, height, null);

    }

    /**
     * <creates spiders randomly based on the math random class>
     *
     * @param <Display and id>
     */
    @Override
    void update(final Display display, final int id) {

    }

    /**
     * <gets the image for the spider>
     *
     * @param <String img>
     * @return <Toolkit.getDefaultToolkit().getImage(img)>
     */
    @Override
    Image getImage(String img) {
        return Toolkit.getDefaultToolkit().getImage(img);
    }
}
