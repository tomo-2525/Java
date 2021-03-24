public class Rectangle extends Point implements Shape{

    double w;
    double h;

    public Rectangle(double a, double b, double c, double d){
	super(a,b);
	this.w = c;
	this.h = d;
    }
    
    public double getArea(){
	return this.h * this.w;
    }


}
