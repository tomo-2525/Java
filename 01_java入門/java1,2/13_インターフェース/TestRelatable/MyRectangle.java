public class MyRectangle implements Relatable{

    private int width = 0;
    private int height = 0;
    private Point origin;

    // two constructors
    public MyRectangle() {
	origin = new Point(0, 0);
    }

    public MyRectangle(int w, int h) {
	origin = new Point(0, 0);
	width = w;
	height = h;
    }


    // a method for moving the rectangle
    public void move(int x, int y) {
	origin.move(x,y);
    }

    // a method for computing the area of the rectangle
    public int getArea() {
	return width * height;
    }

    //a method for computing the length of the rectangle
    public int getLength(){
	return 2*width+2*height;
    }

    
    // a method to implement Relatable
    public int isLargerThan(Relatable other) {
    	RectanglePlus otherRect = (RectanglePlus)other;
    	if (this.getLength() < otherRect.getLength())
	    return -1;
    	else if (this.getLength() > otherRect.getLength())
	    return 1;
    	else
	    return 0;    		
    }
}
