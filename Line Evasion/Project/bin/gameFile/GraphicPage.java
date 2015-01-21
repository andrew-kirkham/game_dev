package gameFile;


import gameFile.lightBikes.AIPlayer;
import gameFile.lightBikes.HumanPlayer;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GraphicPage extends Applet implements Runnable, KeyListener, MouseListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6508619096233898907L;
	public int WIDTH;
	public int HEIGHT;
	
	// this is used for the value in the hash table. i know no other way of doing this so fuck it.
	public int number=0;
	public int playerScore = 0;
	Thread t;
	
	
	Image backImage;
	Graphics ng;
	Score score = new Score();

	HumanPlayer myBike;
	AIPlayer Comp1;
	AIPlayer Comp2;
    
	public void init() {
		LayoutManager Layout = new GridLayout (1,2);
		this.setLayout(Layout);
		this.setSize();
		this.resize(WIDTH, HEIGHT);
		this.setBackground(Color.BLACK);
		this.setMaximumSize(getMaximumSize());
		this.addKeyListener(this);
		this.addMouseListener(this);

		myBike = new HumanPlayer(50,50,5,3);
		Comp1 = new AIPlayer(50,300,5,0);
		
		
	}
	
	// This should automatically check for maximum screen resolution and dynamically select that. 
	public void setSize(){	
		HEIGHT = 480;
		WIDTH = 854;
	}
	
	public void start() {
		
		backImage = createImage(WIDTH,HEIGHT);
		ng = backImage.getGraphics();		
		t = new Thread(this);
			t.start();
	}

	public void stop() {
		t = null;
	}


	public void run() {
		while (true) {	
			score.setScore(playerScore = playerScore++);
			
			myBike.moveBike();
			Comp1.moveBike();
            
            
			repaint();
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e){}
		}
	}
	
	public void update(Graphics g) {
		paint(ng);
		g.drawImage(backImage, 0, 0, null);
		myBike.paint(ng);
		Comp1.paint(ng);
		
		//Comp1.paint(ng);
		
		
	}
	public void mouseClicked(MouseEvent e){
		System.out.println("click");
		myBike.setDirection(e,this);
	}
	
	public void keyPressed(KeyEvent e){
		//Passes key event to LightBike class
		myBike.setDirection(e);
		
	}
	
	public void keyReleased(KeyEvent e){
		//nothing needs to go here
	}
	
	public void keyTyped(KeyEvent e){
		//nothing needs to go here
	}
	


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public Dimension getMaximumSize(){
		Dimension maxSize = new Dimension(WIDTH,HEIGHT);
		return maxSize;
	}
	public int getHeight(){
		return this.HEIGHT;
	}
	public int getWidth(){
		return this.WIDTH;
	}

	
	    
}