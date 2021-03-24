// class Shape{

//     private  String name;

//     public Shape(String name){
// 	this.name = name;
//     }

//     public Shape(){
// 	name = "no name";
//     }

//     public String getName(){
// 	return name;
//     }

//     public String toString(){
// 	return getClass().getName() + " " + name;
//     }

// }//end of the Shape

class Circle extends Shape {// en

    double radius;
    String name;

    Circle(String name, double a) {
        super(name);
        this.name = name;
        radius = a;
    }

    public String toString() {
        System.out.println("radius is " + this.radius);
        return getClass().getName() + " " + this.name;

    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public double getLength() {
        return 2 * radius * Math.PI;
    }

    public double getVolume() {
        return radius * radius * Math.PI;
    }

}// end of the circle class

class Rectangle extends Shape {// tyouhoukei

    double side1, side2;
    String name;

    Rectangle(String name, double a, double b) {
        super(name);
        this.name = name;
        side1 = a;
        side2 = b;
    }

    public String toString() {
        System.out.println("side1 is " + side1 + "side2 is " + side2);
        return getClass().getName() + " " + name;

    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public double getLength() {
        return 2 * (this.side1 + this.side2);
    }

    public double getVolume() {
        return this.side1 * this.side2;
    }

}// end of the Rectangle class

class Square extends Rectangle {// seihoukei

    String name;

    Square(String name, double a) {
        super(name, a, a);
        this.name = name;
        side1 = a;
    }

    public String toString() {
        System.out.println("side1 is " + this.side1);
        return getClass().getName() + " " + name;

    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public double getLength() {
        return 4 * this.side1;
    }

    public double getVolume() {
        return this.side1 * this.side1;
    }

}// end of the Sqare class

class Parallelogram extends Rectangle {// heikousihennkei

    double diagonal;
    String name;

    Parallelogram(String name, double a, double b, double c) {
        super(name, a, a);
        this.name = name;
        side1 = a;
        side2 = b;
        diagonal = c;
    }

    public String toString() {
        System.out.println("side1 is " + this.side1 + "side2 is " + side2 + "diagonal is " + diagonal);
        return getClass().getName() + " " + name;

    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public double getLength() {
        return 2 * (side1 + side2);
    }

    public double getVolume() {
        double s = (side1 + side2 + diagonal) / 2;
        double t = s * (s - side1) * (s - side2) * (s - diagonal);
        return Math.sqrt(t) * 2;
    }

}// end of the Parallelogram

class Rhombus extends Parallelogram {// hisigata //hennka

    double diagonal1, diagonal2;
    String name;

    Rhombus(String name, double a, double b, double c) {
        super(name, a, a, a);
        this.name = name;
        diagonal1 = a;
        diagonal2 = b;
        side1 = c;
    }

    public String toString() {
        System.out.println("diagonal1 is " + diagonal1 + "diagonal2 is" + diagonal2 + "side1 is" + side1);
        return getClass().getName() + " " + name;

    }

    public boolean equals(Object obj, double a, double b) {
        if (a == b) {

            System.out.println("Rhombus volume equals parallellogram");
            return true;
        }
        return false;
    }

    public double getLength() {
        return 4 * side1;
    }

    public double getVolume() {
        return (diagonal1 * diagonal2) / 2;
    }

}// end of the Rhombus

public class TestFigures {
    public static void main(String[] args) {

        Circle circle1 = new Circle("en", 4.5);
        // Circle circle2 = circle1;
        Rectangle rectangle1 = new Rectangle("tyouhoukei", 4.5, 5.7);
        Square square1 = new Square("seihoukei", 3.8);
        Parallelogram parallelogram1 = new Parallelogram("heikoushihennkei", 4.0, 4.0, 4.0);
        Rhombus rhombus1 = new Rhombus("hishigata", 4.0, 4.0, 4.0);

        // if( circle2.equals(circle1) )System.out.println("same obj");

        if ((rhombus1.equals(rhombus1, rhombus1.getVolume(), parallelogram1.getVolume()))) {

            System.out.println(" equal");

        }

        System.out.println(
                circle1.toString() + " length is " + circle1.getLength() + "\nvolume is " + circle1.getVolume() + "\n");
        System.out.println(rectangle1.toString() + " length is " + rectangle1.getLength() + "\nvolume is "
                + rectangle1.getVolume() + "\n");
        System.out.println(
                square1.toString() + " length is " + square1.getLength() + "\nvolume is " + square1.getVolume() + "\n");
        System.out.println(parallelogram1.toString() + " length is " + parallelogram1.getLength() + "\nvolume is "
                + parallelogram1.getVolume() + "\n");
        System.out.println(rhombus1.toString() + " length is " + rhombus1.getLength() + "\nvolume is "
                + rhombus1.getVolume() + "\n");

    }
}
