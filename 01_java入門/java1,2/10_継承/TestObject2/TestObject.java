class Rectangle {

	private double Height, Length;

	Rectangle(double a, double b) {
		this.Height = a;
		this.Length = b;
	}

	double GetPerimeter() {
		return 2 * (this.Height + this.Length);
	}

	double getHeight() {
		return this.Height;
	}

	double getLength() {
		return this.Length;
	}

}

class Box extends Rectangle {

	private double Width;

	Box(double a, double b, double c) {
		super(a, b);
		// this.Height = a;
		// this.Length = b;
		this.Width = c;
	}

	double GetPerimeter() {
		return 4 * (getHeight() + this.Width + getLength());
	}

	/*
	 * double getHeight(){ return this.Height; }
	 */
	/*
	 * double getLength(){ return this.Length; }
	 */

	double getWidth() {
		return this.Width;
	}

}

public class TestObject {

	public static void main(String[] args) {

		Rectangle rectangle1 = new Rectangle(2, 5);
		Box box1 = new Box(3, 5, 6);

		System.out.println("Height,length, are " + rectangle1.getHeight() + " " + rectangle1.getLength());
		System.out.println("length is " + rectangle1.GetPerimeter());

		System.out.println(
				"Height,length,Width are " + box1.getHeight() + " " + box1.getLength() + " " + box1.getWidth());
		System.out.println("length is " + box1.GetPerimeter());
	}
}
