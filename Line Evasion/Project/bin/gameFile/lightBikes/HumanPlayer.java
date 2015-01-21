package gameFile.lightBikes;

import gameFile.GraphicPage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class HumanPlayer extends LightBike{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9077584180403839976L;
	public ImageIcon i;
	public Image sprite;
	
	public HumanPlayer(int x, int y, int speed, int direction) {
		
		
		
		super(x, y, speed, direction);
		// TODO Auto-generated constructor stub
	}

	public void init(){
		/*
		i = new ImageIcon(this.getClass().getResource("gameFile/HumanPlayer1.png"));
		sprite = i.getImage();
		*/
	}
	public void setDirection(MouseEvent e, GraphicPage graphicPage){
		if (e.getX()< .5*graphicPage.WIDTH){
			moveLeft();
		}else
			moveRight();
	}
    public void setDirection(KeyEvent e){
    	int keyID = e.getKeyCode();
    	if(keyID == KeyEvent.VK_LEFT){
    		moveLeft();
    	}
    	if(keyID == KeyEvent.VK_RIGHT){
    		moveRight();
    	}
    }
    
	public void paint(Graphics g) {
		
		g.setColor(Color.CYAN);
		g.fillOval(getX(),getY() ,8,8);
		
		repaint();
		
	}
    
    
    		
}
