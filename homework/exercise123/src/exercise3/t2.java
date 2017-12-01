package exercise3;

public class t2 {
	public static void main(String[] args) {
		ShapeA s1 = new CircleA(5.5, "RED", false);  // Upcast Circle to Shape 
		System.out.println(s1);                    // which version? circle.toString()
		System.out.println(s1.getArea());          // which version? circle.getArea()
		System.out.println(s1.getPerimeter());     // which version? circle.getPerimrter()
		System.out.println(s1.getColor()); 
		System.out.println(s1.isFilled()); 
		//System.out.println(s1.getRadius());  	//shape has no getRadius()
		CircleA c1 = (CircleA)s1;                   // Downcast back to Circle 
		System.out.println(c1); 
		System.out.println(c1.getArea()); 
		System.out.println(c1.getPerimeter()); 
		System.out.println(c1.getColor()); 
		System.out.println(c1.isFilled()); 
		System.out.println(c1.getRadius());     
		//ShapeA s2 = new ShapeA();     			//cannot instance abstract class
		ShapeA s3 = new RectangleA(1.0, 2.0, "RED", false);   // Upcast 
		System.out.println(s3); System.out.println(s3.getArea());
		System.out.println(s3.getPerimeter()); 
		System.out.println(s3.getColor()); 
		//System.out.println(s3.getLength());    //shape has no getLength()
		RectangleA r1 = (RectangleA)s3;   // downcast 
		System.out.println(r1); 
		System.out.println(r1.getArea());
		System.out.println(r1.getColor()); 
		System.out.println(r1.getLength());     
		ShapeA s4 = new SquareA(6.6);     // Upcast 
		System.out.println(s4); 
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		//System.out.println(s4.getSide());    //shape has no getSize()
		// Take note that we downcast Shape s4 to Rectangle,  
		//  which is a superclass of Square, instead of Square 
		RectangleA r2 = (RectangleA)s4; 
		System.out.println(r2); 
		System.out.println(r2.getArea()); 
		System.out.println(r2.getColor()); 
		//System.out.println(r2.getSide()); 	//reg has no getSide()
		System.out.println(r2.getLength());     
		// Downcast Rectangle r2 to Square 
		SquareA sq1 = (SquareA)r2; 
		System.out.println(sq1); 
		System.out.println(sq1.getArea()); 
		System.out.println(sq1.getColor()); 
		System.out.println(sq1.getSide()); 
		System.out.println(sq1.getLength()); 
	}
}
abstract class ShapeA{
	protected String color;
	protected boolean filled;
	protected ShapeA() {
		color = "red";
		filled = true;
	}
	protected ShapeA(String c , boolean f) {
		color = c;
		filled =f;
	}
	public String getColor() {return color;}
	public boolean isFilled() {return filled;}
	public void setColor(String c) {color = c;}
	public void setfilled(boolean f) {filled = f;}
	public abstract double getArea();
	public abstract double getPerimeter();
	//public abstract double getSize();
	public String toString(){
		return "A shape with " + getColor() + "and it is " + isFilled() + "ly filled." ;
	}
}

class CircleA extends ShapeA{
	double radius;
	public CircleA(double r) {
		radius = r;
	}
	public CircleA(double r, String c, boolean f) {
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
class RectangleA extends ShapeA{
	double width;
	double length;
	public RectangleA() {
		width = 1.0;
		length = 1.0;
	}
	public RectangleA( double w, double l, String c, boolean f) {
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
class SquareA extends RectangleA{
	public SquareA() {}
	public SquareA(double a) {width = length = a;}
	public SquareA(double a, String c, boolean f) {
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
