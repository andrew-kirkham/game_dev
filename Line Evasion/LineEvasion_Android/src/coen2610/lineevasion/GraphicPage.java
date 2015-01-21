package coen2610.lineevasion;

import android.view.KeyEvent;
import coen2610.lineevasion.GamePlay.Action;

public class GraphicPage implements Runnable{

	final static int Width = 500; //these are not final and are set in the PlayGameView
	final static int Height = 400;
	private Thread thread;
	private GamePlay game;
	
	//TODO what are these?
	boolean leftKey = false;
	boolean rightKey = false;
	boolean upKey = false;
	boolean downKey = false;

	//TODO init and start need to be moved - maybe deleted - into the onCreate of the PlayGameView
	public void init() {
		Frame mainFrame = (Frame)this.getParent().getParent();
		mainFrame.setTitle("Line Evasion");
	}


	public void start() {
		thread = new Thread(this);
//		game = new GamePlay(Width,Height);
		backImage = createImage(Width,Height);
		graphics = backImage.getGraphics();
		
		thread.start();
	}

	public void stop() {
		thread = null;
	}

	//TODO i dont like this. make it into an update method that calls various updates based on what its updating
	public void run() {
		boolean movedLeft;
		boolean movedRight;
		while (game.gameStatus == game.RUNNING){
			
			movedLeft = false;
			movedRight = false;
			if (!movedLeft && leftKey){ 
				//TODO simplify me!
				game.setHumanAction(0, Action.GOLEFT); leftKey = false; movedLeft = true; 
			}
			if (!movedRight && rightKey){
				
				game.setHumanAction(0, Action.GORIGHT); rightKey = false; movedRight = true;
			}
			game.playTurn();
			
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e){}
		}
//			playAgain();
	}
	
	
	//TODO figure out how to make this in android
//	public void playAgain() {
//		int input = JOptionPane.showConfirmDialog(null, "Play Again?", "Play Again?", JOptionPane.YES_NO_OPTION);
//		if (input == JOptionPane.YES_OPTION){
//			start();
//			repaint();
//		} else {
//			stop();
//			System.exit(0);
//		}
//	}
	
	//TODO move into the PGV
	public void update(Graphics g) {
		paint(graphics);
		g.drawImage(backImage, 0, 0, null);
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0,Width, Height);
		
		game.drawGame(g);
	}

	//TODO move into the PGV and adapt for touch events
	public void mouseClicked(MouseEvent eventMouse) {
		game.players[0].moveBikeWithMouse(eventMouse);
	}
}

