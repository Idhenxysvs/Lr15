public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota Camry", 2020, 197);
        Car car2 = new Car("BMW M5", 2022, 600);
        Car car3 = new Car("VW Golf", 2018, 150);
        Car car4 = new Car("Audi A6", 2021, 249);
        Car car5 = new Car("Lada Granta", 2019, 87);

        System.out.println("Автомобили:");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
        System.out.println(car5);

        System.out.println();
        System.out.println("Всего автомобилей: " + Car.getTotalCars());
        System.out.println("Общая мощность: " + Car.getTotalHorsePower() + " л.с.");
        System.out.println("Средняя мощность: " + Car.getAveragePower() + " л.с.");
    }
}