package gameFile;

import gameFile.lightBikes.AIPlayer;
import gameFile.lightBikes.HumanPlayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


// This didn't work. Fahgit about it. 

public class gamePanel extends JPanel implements KeyListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7204069417901470378L;
	HumanPlayer myBike;
	AIPlayer Comp1;
	AIPlayer Comp2;
	
	
	Graphics ng;
	
	public void initComponents(){
		this.setBackground(Color.black);
	}
	
	public gamePanel(){
		initComponents();
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.setSize(480,854);
		
		HumanPlayer myBike = new HumanPlayer(5,5,5,2);
		this.add(myBike);
		
		
		
			
	}
	
	public void setSize(int x, int y){
		
		//this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 1));
	}
	
	public void updateGUI(){
	}
	
	public void update(Graphics g) {
		
		myBike.paint(ng);
		
		//Comp1.paint(ng);
		
		
	}
	
	public void mouseClicked(MouseEvent e){
		System.out.println("click");
		//myBike.setDirection(e,this);
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
}
