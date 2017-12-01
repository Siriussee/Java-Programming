package exercise2;

public class exer3 {
	public static void main(String[] args) {
		Circle2D c1  = new Circle2D(2, 2, 5.5);
		//Circle2D c2 = 
		System.out.println("is c1.contains(3, 3)?  " + c1.contains(3, 3));
		System.out.println("is c1.overlaps(new Circle2D(3, 5, 2.3))?  " + c1.overlaps(new Circle2D(3, 5, 2.3)));
		System.out.println("is c1.contains(new Circle2D(4, 5, 10.5))?  " + c1.contains(new Circle2D(4, 5, 10.5)));
	}
}
class Circle2D{
	double x;
	double y;
	double radius;
	
	Circle2D(){
		x = y = 0;
		radius = 1;
	}
	Circle2D(double ix, double iy, double r){
		x =ix;
		y = iy;
		radius =r;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getRadius() {
		return radius;
	}
	public double getArea() {
		return radius * radius *Math.PI;
	}
	public double getPrimeter() {
		return 2 * radius * Math.PI;
	}
	public boolean contains(double ix,double iy) {
		if(Math.sqrt(x*x + y*y) - Math.sqrt(ix*ix + iy*iy) < radius)
			return true;
		return false;
	}
	public boolean contains(Circle2D c) {
		if(Math.sqrt(x*x + y*y) - Math.sqrt(c.x*c.x + c.y*c.y) <= Math.abs(radius - c.radius))
			return true;
		return false;
	}
	public boolean overlaps(Circle2D c) {
		double d = Math.sqrt(x*x + y*y) - Math.sqrt(c.x*c.x + c.y*c.y) ;
		if( Math.abs(c.radius - radius) <= d && d <= c.radius + radius )
			return true;
		return false;
	}
	
}