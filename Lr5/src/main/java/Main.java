import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Введите название товара: ");
        String name = scan.next();
        System.out.print("Введите цену за штуку: ");
        double price = scan.nextDouble();
        System.out.print("Введите количество: ");
        int quantity = scan.nextInt();
        Product product = new Product(name, price, quantity);
        System.out.println("Общая стоимость: " + product.totalCost());
    }
}
