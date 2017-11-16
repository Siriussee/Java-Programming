package Movable;

public class MovableCircle implements Movable { // saved as "MovableCircle.java" 
	// instance variables 
	private MovablePoint center; // can use center.x, center.y directly 
								// because they are package accessible
	private int radius; 
	// Constructor 
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) { 
		// Call the MovablePoint's constructor to allocate the center instance. 
		center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}
	// Implement abstract methods declared in the interface Movable 
	@Override 
	public void moveUp() { 
			center.y -= center.ySpeed;
	}
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}
}