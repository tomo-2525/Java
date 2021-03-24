public class TestShape {

	public static void main(String[] argv) {
		int i;

		Object[] object = new Object[12];
		// {new Point[3],new Circle[4],new Rectangle[5]};

		object[0] = new Point(4.3, 5.6);
		object[1] = new Point(4.3, 5.6);
		object[2] = new Point(4.3, 5.6);

		object[3] = new Circle(4.3, 5.6, 4.6);
		object[4] = new Circle(4.3, 5.6, 7.4);
		object[5] = new Circle(4.3, 5.6, 2.6);
		object[6] = new Circle(4.3, 5.6, 4.7);

		object[7] = new Rectangle(4.3, 5.6, 5.7, 3.7);
		object[8] = new Rectangle(4.3, 5.6, 5.7, 3.7);
		object[9] = new Rectangle(4.3, 5.6, 5.7, 3.7);
		object[10] = new Rectangle(4.3, 5.6, 5.7, 3.7);
		object[11] = new Rectangle(4.3, 5.6, 5.7, 3.7);

		for (i = 0; i < object.length; i++) {
			// System.out.println(i);
			System.out.println("this area is " + ((Shape) object[i]).getArea());
		}
	}
}
