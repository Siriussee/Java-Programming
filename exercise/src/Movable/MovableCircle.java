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
		
		center.y += center.ySpeed;
		
	}
	@Override
	public void moveRight() {
		center.x -= center.ySpeed;
		
	}
	@Override
	public void moveLeft() {
		center.x += center.ySpeed;
		
	}
	public String toString() {
		return "The "+radius+" radius circle in (" + center.x + "," +center.y+ ") and will move in speed (" 
	+ center.xSpeed + "," + center.ySpeed +").";
	}
}
