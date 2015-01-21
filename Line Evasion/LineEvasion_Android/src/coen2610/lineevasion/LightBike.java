package coen2610.lineevasion;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import coen2610.lineevasion.GameView.Direction;

public class LightBike {
    private final int SPEED = 6;
	
	private int playerId;
    private int xPosition;
    private int yPosition;
    public Direction direction;
    private boolean isAlive = true;
    private Coordinate position;
    private boolean loopPrevention = false;
    public enum LastTurn{ Left,Right,Straight,DoubleLeft,DoubleRight }
    private LastTurn lastTurn = LastTurn.Straight;
    private int doubleTurn = 0;
    private int straightMoves = 0;
    
   
    // Color integers used by the android OS
    int Magenta = 0xffff00ff;
    int Green 	= 0xff00ff00;
    int Cyan	= 0xff00ffff;
    int Orange	= 0xffffff00;
    int White	= 0xffffffff;
    int Blue	= 0xff0000ff;
    int Black	= 0xff000000;
    int	Red		= 0xffff0000;
    
    private int humanColor;
    private int aiBikeColor;
    private int aiBikeColor2;
    private int aiBikeColor3;
    
    /**
     * Constructor used for each of the main Light Bike players
     * @param id
     * @param coord
     * @param direction
     * @param graphics
     */
    public LightBike(int id, Coordinate coord, Direction direction, int graphics) {
		this.playerId = id;
		this.position = coord;
		this.xPosition = coord.getXLocation();
		this.yPosition = coord.getYLocation();
		this.direction = direction;
		setBikeColors(graphics);
	}
    
    /**
     * Constructor used for the testBikes used by the AI methods.
     * @param id
     * @param coord
     * @param direction
     */
    public LightBike(int id, Coordinate coord, Direction direction) {
		this.playerId = id;
		this.position = coord;
		this.xPosition = coord.getXLocation();
		this.yPosition = coord.getYLocation();
		this.direction = direction;
	}
    
    /**
     * @return The current Coordinate of the bike location
     */
	public Coordinate getPosition(){
    	position = new Coordinate(getXPosition(), getYPosition());
    	return position;
    }
    
	/**
	 * @return the current X location of the bike
	 */
    public int getXPosition(){
        return xPosition;
    }
    
	/**
	 * @return the current Y location of the bike
	 */
    public int getYPosition(){
        return yPosition;
    }
    
    /**
     * @return the current Direction of the bike
     */
    public GameView.Direction getDirection(){
    	return this.direction;
    }

    /**
     * Draws the bike on the screen.
     * @param paint
     * @param canvas
     */
    public void drawBike(Paint paint, Canvas canvas){
    	switch(playerId){
    		case 0:
    			drawBikeStyle(paint,canvas,humanColor);
    			break;
    		case 1:
    			drawBikeStyle(paint,canvas,aiBikeColor);
    			break;
    		case 2:
    			drawBikeStyle(paint,canvas,aiBikeColor2);  			
    			break;
    		case 3:
    			drawBikeStyle(paint,canvas,aiBikeColor3);   			
    			break;
    	}
    }
    
    /**
     * Draws the walls created by the bike on the screen
     * @param paint
     * @param canvas
     */
    public void drawWall(Paint paint, Canvas canvas){
    	switch(playerId){
    	case 0:
    		drawWallStyle(paint,canvas,humanColor);	
    		break;
    	case 1:
    		drawWallStyle(paint,canvas,aiBikeColor);
    		break;
    	case 2:
    		drawWallStyle(paint,canvas,aiBikeColor2);
    		break;
    	case 3:
    		drawWallStyle(paint,canvas,aiBikeColor3);
    		break;
    	}
    }
    
    /**
     * Draws the bike on the screen based on the direction of the bike.
     * @param paint
     * @param canvas
     * @param color
     */
    public void drawBikeStyle(Paint paint, Canvas canvas, int color){
    	if(this.direction == Direction.UP || this.direction == Direction.DOWN ){
			paint.setStrokeWidth(6);
    		paint.setColor(White); 		
    		canvas.drawRect(getXPosition()-1, getYPosition()+4, getXPosition()+1, getYPosition()-3, paint);
    		paint.setStrokeWidth(4);
			paint.setColor(color);
			paint.setStyle(Style.FILL_AND_STROKE);
			canvas.drawRect(getXPosition()-1, getYPosition()+4, getXPosition()+1, getYPosition()-3, paint);
		}if(this.direction == Direction.LEFT || this.direction == Direction.RIGHT ){
			paint.setStrokeWidth(6);
    		paint.setColor(White);		
    		canvas.drawRect(getXPosition()+4, getYPosition()-1, getXPosition()-3, getYPosition()+1, paint);
    		paint.setStrokeWidth(4);
			paint.setColor(color);
			paint.setStyle(Style.FILL_AND_STROKE);
			canvas.drawRect(getXPosition()+4, getYPosition()-1, getXPosition()-3, getYPosition()+1, paint);
		}
    } 
    
    /**
     * Draws the wall at the coordinate directly behind the bike.
     * @param paint
     * @param canvas
     * @param color
     */
    public void drawWallStyle(Paint paint, Canvas canvas, int color){
    	paint.setStrokeWidth(6);
		paint.setColor(White);
		canvas.drawPoint(getTrailingWall().getXLocation(), getTrailingWall().getYLocation(),paint);
		paint.setStrokeWidth(4);
		paint.setColor(color);
		canvas.drawPoint(getTrailingWall().getXLocation(), getTrailingWall().getYLocation(),paint);
    }
    
    /**
     * Moves the bike one increment forward based on the direction of the bike.
     */
    public void moveBike(){
    	straightMoves++;
    	if(doubleTurn>1){
    		loopPrevention=true;
    	}
    	switch(direction) {
    	case UP:
    		yPosition=yPosition-SPEED;
    		break;  
    	case LEFT:
    		xPosition=xPosition-SPEED;
    		break;
    	case DOWN:
    		yPosition=yPosition+SPEED;
    		break; 
    	case RIGHT:
    		xPosition=xPosition+SPEED;
    		break;    	   	  	
    	}
    }
    
    /**
     * Moves the bike one increment left based on the direction of the bike.
     */
	public void moveLeft(){
		straightMoves = 0; 
		if(lastTurn == LastTurn.Left){
			doubleTurn++;
		}else if(lastTurn == LastTurn.Right){
			doubleTurn=0;
			loopPrevention=false;
		}
		lastTurn = LastTurn.Left;
		
    	switch(direction) {
    	case UP:
    		direction = Direction.LEFT;
    		break;  
    	case LEFT:
    		direction = Direction.DOWN;
    		break;
    	case DOWN:
    		direction = Direction.RIGHT;
    		break; 
    	case RIGHT:
    		direction = Direction.UP;
    		break;    	   	  	
    	}
    }
    
	/**
     * Moves the bike one increment right based on the direction of the bike.
     */
    public void moveRight(){
    	straightMoves = 0;
    	if(lastTurn == LastTurn.Right){
			doubleTurn++;
		}else if(lastTurn == LastTurn.Left){
			doubleTurn=0;
			loopPrevention=false;
		}
    	lastTurn = LastTurn.Right;
    	switch(direction) {
    	case UP:
    		direction = Direction.RIGHT;
    		break;  
    	case LEFT:
    		direction = Direction.UP;
    		break;
    	case DOWN:
    		direction = Direction.LEFT;
    		break;
    	case RIGHT:
    		direction = Direction.DOWN;
    		break;
    	}
    }
    
    /**
     * Changes the color of the bikes on the gameboard based on the toggle button in the options screen
     * @param graphics
     */
    public void setBikeColors(int graphics){
    	switch(graphics){
    	case 0:
    		humanColor = Magenta;
    		aiBikeColor = Green;
    		aiBikeColor2 = Cyan;
    		aiBikeColor3 = Orange;
    		break;
    	case 1:
    		humanColor = Magenta;
    		aiBikeColor = Blue;
    		aiBikeColor2 = Blue;
    		aiBikeColor3 = Blue;
    		break;
    	case 2:
    		humanColor = Magenta;
    		aiBikeColor = Magenta;
    		aiBikeColor2 = Magenta;
    		aiBikeColor3 = Magenta;
    		break;
    	}
    }
    
    /**
     * Gets the coordinate used to create the wall behind the player.
     * @return the Coordinate of the player
     */
    public Coordinate getTrailingWall() {
    	Coordinate temp = new Coordinate(xPosition, yPosition);
    	return temp;
    }
    
    /**
     * @return the ID of the player
     */
    public int getId(){
    	return playerId;
    }
    
    /**
     * Causes the player to die and removes the instance of the lightbike.
     * @throws Throwable
     */
    public void playerDeath() throws Throwable {
    	isAlive = false;
    	this.finalize();
    }
    
    /**
     * Checks to see if the player is alive
     * @return player status
     */
	public boolean isAlive() {
		return isAlive;
	}
	
	/**
	 * @return the last turn made by the player
	 */
	public LastTurn getLastTurn(){
		return lastTurn;
	}
	
	/**
	 * @return the number of times the player has moved straight in a row.
	 */
	public int getStraightMoves(){
		return straightMoves;
	}
	
	/**
	 * Returns whether or not the player is about to enter a continuous movement loop.
	 * @return whether or not loop prevention is enabled
	 */
	public boolean getLoopPrevention(){
		return loopPrevention;
	}
}


