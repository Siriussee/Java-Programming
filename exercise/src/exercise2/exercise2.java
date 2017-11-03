package exercise2;

public class exercise2 {
	public static void main(String[] agrs) {
		fan fan1 = new fan();
		//System.out.println(fan1.toString());
		fan1.setColor("yellow");
		fan1.setOn(true);
		fan1.setRadius(10);
		fan1.setSpeed(3);
		System.out.println(fan1.toString());
		fan fan2 = new fan();
		fan2.setOn(true);
		fan2.setSpeed(2);
		System.out.println(fan2.toString());
	}
}
class fan{
	int speed;
	double radius;
	boolean on;
	String color;
	
	fan(){
		speed = 1;
		radius = 5;
		on = false;
		color = "blue";
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int s) {
		speed = s;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double r) {
		radius = r;
	}
	public boolean getOn() {
		return on;
	}
	public void setOn(boolean o) {
		on = o;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		color = c;
	}
	public String toString() {
		if(on)
		{
			return("This fan is " + color + " and " + radius +
					" inch(es) in size and running in " + speed + " speed." );
		}
		else {
			return("This fan is " + color + "and " + radius +
					" inch(es) in size and it is off." );
		}
	}
}