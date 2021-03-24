public class Circle extends Point implements Shape{
    double r;

    public Circle(double a, double b, double c){
	super(a,b);
	this.r = c;
    }
    
    public double getArea(){
	return this.r * this.r * Math.PI;
    }
}
