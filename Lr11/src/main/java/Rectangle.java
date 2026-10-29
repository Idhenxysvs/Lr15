public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, int x, int y, double width, double height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String info() {
        return "Rectangle{color=" + color + ", x=" + x + ", y=" + y
                + ", width=" + width + ", height=" + height + "}";
    }

    public void draw(double width, double height) {
        System.out.println("Рисую прямоугольник шириной " + width + " и высотой " + height);
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }
}
