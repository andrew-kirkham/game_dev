package coen2610.lineevasion;

public class Coordinate{

	private int xLocation;
	private int yLocation;
	
	/**
	 * Constructor for the Coordinate class. Creates a (x,y) coordinate pair.
	 * @param xCoordinate
	 * @param yCoordinate
	 */
	public Coordinate(int xCoordinate, int yCoordinate){
		this.xLocation = xCoordinate;
		this.yLocation = yCoordinate;
	}
	
	/**
	 * Checks to see if two coordinates are equal to each other. This is used to check for collisions.
	 */
	@Override
	public boolean equals(Object comparator) {
		if (!comparator.getClass().equals(Coordinate.class)){
			return false;
		}
		Coordinate coord = (Coordinate)comparator;
		if (coord.getXLocation() == getXLocation() && coord.getYLocation() == getYLocation()){
			return true;
		}
		else return false;
	}
	
	/**
	 * @return X value for this coordinate
	 */
	public int getXLocation(){
		return xLocation;
	}
	
	/**
	 * @return Y value for this coordinate
	 */
	public int getYLocation(){
		return yLocation;
	}
}


