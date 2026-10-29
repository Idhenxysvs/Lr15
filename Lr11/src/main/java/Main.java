public class Main {
    void main() {
        Shape shape = new Shape("белый", 0, 0);
        Circle circle = new Circle("красный", 10, 20, 5);
        Rectangle rectangle = new Rectangle("синий", 30, 40, 4, 6);

        System.out.println("Перегрузка методов:");

        shape.draw();
        shape.draw("зеленый");
        shape.draw(100);

        circle.draw();
        circle.draw("оранжевый");
        circle.draw(7);
        circle.draw(7, true);

        rectangle.draw();
        rectangle.draw("желтый");
        rectangle.draw(15);
        rectangle.draw(8.0, 3.0);

        System.out.println();
        System.out.println("Переопределение:");
        System.out.println("calculateArea() у Shape: " + shape.calculateArea());
        System.out.println("calculateArea() у Circle: " + circle.calculateArea());
        System.out.println("calculateArea() у Rectangle: " + rectangle.calculateArea());
    }
}
