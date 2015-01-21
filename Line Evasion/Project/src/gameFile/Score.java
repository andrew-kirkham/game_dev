package gameFile;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;


public class Score extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -854309035367662346L;

	// Setting Font
	Font font = new Font("Helvetica", Font.BOLD, 30);
	
	//Initiating String
	String Score = new String("Score: "+ getScore());
	//Creating new textfield
	
	
	//score variable
	private int playerScore;
	
	public void init(){
		
	}
	
	public Score(){
		playerScore=0;
		this.setText(Score);
		this.setFont(font);
		//this.setAlignment(Label.LEFT);
		this.setForeground(Color.WHITE);
		//this.setBackground(new Color(0,0,0,0));
		
		
		
	}
	
	public void getStringSize(){
		
	}
	
	public int getScore(){
		
		return playerScore;
	}
	
	public void setScore(int k){
		playerScore = k;
		this.setText(Score = "Score: " + getScore());
		
		
	}
}
