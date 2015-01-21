package coen2610.lineevasion;

import java.util.ArrayList;
import java.util.Random;

public class GamePlay {

    public enum Action { GOSTRAIGHT, GOLEFT, GORIGHT }
	public enum Direction {	UP, LEFT, DOWN, RIGHT }	
	
	//TODO me wanty this format but having trouble adapting. I believe it would resolve the two enums above
	//might be easier to resolve upon merging this and the playgameview
	public int currentDirection = UP;
	public int nextDirection = UP;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	
	public int Difficulty = EASY;
	public static final int EASY = 1;
	public static final int MEDIUM = 2;
	public static final int HARD = 3;
	
	public Random rand = new Random();
	public ArrayList<Coordinate> walls;
    public LightBike players[];
    public int Width, Height;
    
    public int gameStatus = RUNNING;
    public static final int READY = 1;
    public static final int RUNNING = 2;
    public static final int PAUSED = 3;
    public static final int LOSS = 4;
        
    public GamePlay(int Width, int Height, int Difficulty) {
    	walls = new ArrayList<Coordinate>();
    	this.Width = Width;
    	this.Height = Height;
    	rand.setSeed(System.currentTimeMillis());
    	
    	//if i remember right java applets draw with height starting at the top and going down so Height/4 is
    	//higher up than 3*Height/4. Not sure about android and this is something easily switched.
    	Coordinate upperLeft = new Coordinate(Width/4, Height/4);
    	Coordinate lowerLeft = new Coordinate(Width/4, 3*Height/4);
    	Coordinate upperRight = new Coordinate(3*Width/4, Height/4);
    	Coordinate lowerRight = new Coordinate(3*Width/4, 3*Height/4);
    	
    	players[0] = new LightBike(0, upperLeft, Direction.DOWN);        
    	players[1] = new LightBike(1, lowerLeft, Direction.RIGHT);    		
		players[2] = new LightBike(2, upperRight, Direction.UP);    		
		players[3] = new LightBike(3, lowerRight, Direction.LEFT); 
		    
		this.Difficulty = Difficulty;

    }
    
    public void setHumanAction(int ID, Action action) {
    	for(LightBike lb:players) {
			if(lb.getID() == ID) lb.setAction(action);
		}
    }
    
    public void setAIAction(int ID) {
    	switch(Difficulty) {    	
    	case EASY:
    		switch(rand.nextInt(180)) {
	    		case 0:
	    			players[ID].setAction(Action.GOLEFT);	
	    			break;
	    		case 1:
	    			players[ID].setAction(Action.GORIGHT);	
	    			break;
    		}
    	case MEDIUM:
    		break;
    	}
    }

	public boolean detectCollision(LightBike player) {
		Coordinate position = player.getPosition();
		return (walls.contains(position)) ? true : false;		
	}
	
	public void playTurn() {
		Coordinate nextWall;
		int playersRemaining = 0;

		for(LightBike pl: players){
			if(pl.isAlive()){
				
				if(pl.getID() > 0){
					setAIAction(pl.getID());
				}
				nextWall = pl.playTurn();
				
				playersRemaining++;
				
				//TODO is this check necessary? will nextWall ever return null?
				if(nextWall != null) {
					walls.add(nextWall);
				}
				
				if(detectCollision(pl)) {
					pl.playerDeath();
					nextWall = pl.getTrailingWall();
					walls.add(nextWall);
				}						
			}
		}
		if(!players[0].isAlive() || playersRemaining == 1){
			gameStatus = LOSS;
		}
	}
	
	//TODO move me!
	public void drawGame(Graphics g){
		for (Coordinate w : walls){
			w.drawWall(g);
		}
		for(LightBike lb: players) {
			lb.drawBike(g);
			lb.drawWall(g);
		}
	}
	
	public int pulseRadar(Coordinate coords, Direction dir) {
		int dist = 0;
		//too lazy to fix to work with coords, will fix later
		return dist;
	}
}