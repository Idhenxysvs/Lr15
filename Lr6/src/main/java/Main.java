public class Main {
    public static void main(String[] args) {
        Product product = new Product("Ноутбук", 55990.0, 3);
        System.out.println("Товар: " + product.getName());
        System.out.println("Общая стоимость: " + product.totalCost());
    }
}
