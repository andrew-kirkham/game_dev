package gameFile.lightBikes;



import java.awt.Color;
import java.awt.Graphics;

public class AIPlayer extends LightBike{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1366333139196261386L;

	public AIPlayer(int x, int y, int speed, int direction) {
		super(x, y, speed, direction);
		// TODO Auto-generated constructor stub
	}

	// Will pass in data from algorithm to set direction for AI player
	
	public void setDirection(){
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(getX(),getY() ,8,8);
	}
    
	public void AImove(int i){
		
	}
	
	
}
