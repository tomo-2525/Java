class RectanglePlus implements Relatable {
    private int width = 0;
    private int height = 0;
    private Point origin;

    // two constructors
    public RectanglePlus() {
        origin = new Point(0, 0);
    }

    public RectanglePlus(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.move(x, y);
    }

    // a method for computing the area of the rectangle
    public int getArea() {
        return width * height;
    }

    // a method to implement Relatable
    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect = (RectanglePlus) other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;
    }
}