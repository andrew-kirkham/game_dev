package gameFile;

public class Wall<E> implements Comparable<E>{

	private int xPosition;
	private int yPosition;
	
	public Wall(int x, int y){
		
		xPosition = x;
		yPosition = y;
		
	}

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString(){
		
		return "x pos " + xPosition + " y pos " + yPosition ;
	}
	
	public int getX(){
		return xPosition;
	}
	
	public int getY(){
		return yPosition;
	}
	
}
