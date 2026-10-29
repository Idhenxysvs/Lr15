public class Circle extends Shape {
    private double radius;

    public Circle(String color, int x, int y, double radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Рисую круг цветом " + color + " радиусом " + radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String info() {
        return "Circle{color=" + color + ", x=" + x + ", y=" + y + ", radius=" + radius + "}";
    }

    public void draw(int size, boolean filled) {
        System.out.println("Рисую круг размером " + size + (filled ? " с заливкой" : " без заливки"));
    }

    public double calculateDiameter() {
        return 2 * radius;
    }

    public double getRadius() {
        return radius;
    }
}
