public class Main {
    void main() {
        Vehicle[] vehicles = {
                new Car("Toyota Camry", 2022, 210, 4),
                new Car("BMW X5", 2023, 250, 5),
                new Car("Lada Granta", 2021, 170, 4),
                new Motorcycle("Honda CBR", 2023, 260, false),
                new Motorcycle("Ural MT", 2020, 120, true)
        };

        System.out.println("Весь транспорт:");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            v.move();
            System.out.println("Расход топлива: " + v.fuelConsumption() + " л/100 км");
            System.out.println();
        }

        System.out.println("Расход топлива всех транспортных средств:");
        for (Vehicle v : vehicles) {
            System.out.println(v.getBrand() + " — " + v.fuelConsumption() + " л/100 км");
        }
    }
}
