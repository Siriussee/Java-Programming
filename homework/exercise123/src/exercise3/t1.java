package exercise3;

public class t1 {	

	public static void main(String[] args) {
		Shape shape1 = new Shape("black",true);
		System.out.println(shape1.toString());
		Circle circle1 = new Circle(20);
		System.out.println(circle1.toString());
		Rectangle r1 = new Rectangle(10,15,"white",true);
		System.out.println(r1.toString());
		Square s1 = new Square(3);
		System.out.println(s1.toString());
	}
}
class Shape{
	private String color;
	private boolean filled;
	public Shape() {
		color = "red";
		filled = true;
	}
	public Shape(String c , boolean f) {
		color = c;
		filled =f;
	}
	public String getColor() {return color;}
	public boolean isFilled() {return filled;}
	public void setColor(String c) {color = c;}
	public void setfilled(boolean f) {filled = f;}
	public String toString(){
		return "A shape with " + getColor() + "and it is " + isFilled() + "ly filled." ;
	}
}

class Circle extends Shape{
	double radius;
	public Circle(double r) {
		radius = r;
	}
	public Circle(double r, String c, boolean f) {
		super(c,f);
		radius = r;
		
	}
	public double getRadius() {return radius;}
	public void setRadius(double r) {radius = r;}
	public double getArea() {return Math.PI * radius * radius;}
	public double getPerimeter() {return 2*Math.PI*radius;}
	public String toString() {
		return "A circle with " + getRadius() + " radius and is a subclass of shape." ;
	}
}
class Rectangle extends Shape{
	double width;
	double length;
	public Rectangle() {
		width = 1.0;
		length = 1.0;
	}
	public Rectangle( double w, double l, String c, boolean f) {
		super(c,f);
		width = w;
		length = l;
		
	}
	public double getWidth() {return width;}
	public double getLength() {return length;}
	public void setWidth(double w) {width = w;}
	public void setLength(double l) {length = l;}
	public double getArea() {return width * length;}
	public double getPerimeter() {return 2 * (length + width);}
	public String toString() {
		return "A rectangle with " + getLength() + "*" + getWidth() + " and is a subclass of shape.";
	}
}
class Square extends Rectangle{
	public Square() {}
	public Square(double a) {width = length = a;}
	public Square(double a, String c, boolean f) {
		super(a,a,c,f);
	}
	public double getSide() {return width;}
	public void setSide(double a) {width = length = a;}
	public void setWidth(double a) {width = length = a;}
	public void setLength(double a) {width = length = a;}
	public String toString() {
		return "A square with " + getLength() + " size and " + getArea()+" area and is a subclass of rectangle.";
	}
	
}
