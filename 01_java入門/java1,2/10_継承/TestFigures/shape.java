
class Shape {

    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public Shape() {
        name = "no name";
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getclass().getName() + " " + name;
    }

}// end of the Shape

class Circle extends Shape {

    double radis; // hannkei

    Circle() {
        radius = 3.0;
    }

    public double getLength() {
        return 2 * radius * Math.PI;
    }

    public double getVolume() {
        return radius * radius * Math.PI;
    }

}// end of the circle class

class Rectangle extends Shape {

    double side1, side2;

    Rectangle() {
        side1 = 5.0;
        side2 = 3.0;
    }

}// end of the Rectangle class

class Suquare extends Rectancgle {

    double side1;

    Suquare() {
        side = 4.0;
    }

}// end of the Square class

class Parallelogram extends Rectancgle {

    double diagonal;

    Parallelogram() {
        diagonal = 5.0;
    }

}// end of the Parallelogram

class Rhombus extends Square {

    double diagonal;

    Rhombus() {
        diagonal = 3.8;
        side = 5.0;
    }

}// end of the Rhombus

class TestFigures {
    public static void main(String[] args) {

        Circle circle1 = new Circle();
        Rectancgle rectangle1 = new Rectangle();
        Suquare square1 = new Suquare();
        Parallelogram parallelogram1 = new Parallelogram();

    }
}
