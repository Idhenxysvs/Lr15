public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 120, 30);
        Car car2 = new Car("BMW", 180, 45);
        Car car3 = new Car("Lada", 90, 10);
        Bicycle bike1 = new Bicycle("Stels", 20, 6);
        Bicycle bike2 = new Bicycle("Trek", 25, 18);

        Movable[] transports = {car1, car2, car3, bike1, bike2};

        System.out.println("Движение:");
        for (Movable m : transports) {
            m.move();
        }

        System.out.println();
        System.out.println("Остановка:");
        for (Movable m : transports) {
            m.stop();
        }

        System.out.println();
        System.out.println("Заправка:");
        for (Movable m : transports) {
            if (m instanceof Refuelable) {
                ((Refuelable) m).refuel(20);
            }
        }

        System.out.println();
        System.out.println("Состояние:");
        for (Movable m : transports) {
            System.out.println(Movable.status(m));
            if (m instanceof Refuelable) {
                System.out.printf("  топливо: %.1f л%n", ((Refuelable) m).getFuelLevel());
            }
        }
    }
}