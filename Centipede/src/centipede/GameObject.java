/**
 * <Basic objects used by most classes>
 *
 * @author <Andrew Kirkham>
 * @version <Created: 4/19/11, Modified: date - description>
 */
package centipede;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {

    protected Rectangle rect; //rectangle used for collision factors
    protected int xPos; //x coordinate to be used by multiple classes
    protected int yPos; //y coordinate to be used by multiple classes
    protected int height; //pixel height of the class defined
    protected int width; //pixel width of the class defined
    protected Image img; //image to be used by the class
    protected int health;//health of the defined class

    abstract void draw(Graphics g); //allows draw to be abstract

    abstract void update(final Display display, final int id); //allows update to be abstract varialbe

    abstract Image getImage(String img); //allows getimage to be abstract

    /**
     * <getter for img>
     *
     * @return <img>
     */
    public Image getImg() {
        return img;
    }

    /**
     * <setter for img>
     *
     * @return <img>
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * <getter for xPos>
     *
     * @return <xPos>
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * <setter for xPos>
     *
     * @return <xPos>
     */
    public void setXPos(int pos) {
        this.xPos = pos;
    }

    /**
     * <getter for yPos>
     *
     * @return <yPos>
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * <setter for yPos>
     *
     * @return <yPos>
     */
    public void setYPos(int pos) {
        this.yPos = pos;
    }

    /**
     * <getter for height>
     *
     * @return <height>
     */
    public int getHEIGHT() {
        return height;
    }

    /**
     * <setter for height>
     *
     * @return <height>
     */
    public void setHEIGHT(int height) {
        this.height = height;
    }

    /**
     * <getter for width>
     *
     * @return <width>
     */
    public int getWIDTH() {
        return width;
    }

    /**
     * <setter for width>
     *
     * @return <width>
     */
    public void setWIDTH(int width) {
        this.width = width;
    }

    /**
     * <getter for health>
     *
     * @return <health>
     */
    public int getHealth() {
        return health;
    }

    /**
     * <setter for health>
     *
     * @return <health>
     */
    public void setHealth(int Health) {
        this.health = Health;
    }
}
