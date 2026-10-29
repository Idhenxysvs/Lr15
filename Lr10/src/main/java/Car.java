public class Car implements Movable, Refuelable {
    private static final double maxFuel = 60.0;

    private String brand;
    private int speed;
    private double fuelLevel;

    public Car(String brand, int speed, double fuelLevel) {
        this.brand = brand;
        this.speed = speed;
        this.fuelLevel = fuelLevel;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public double getFuelLevel() { return fuelLevel; }

    @Override
    public void move() {
        if (fuelLevel <= 0) {
            System.out.println(brand + ": бак пуст, движение невозможно");
            speed = 0;
            return;
        }
        System.out.println(brand + ": едет со скоростью " + speed + " км/ч");
        fuelLevel = Math.max(0, fuelLevel - 1.5);
    }

    @Override
    public void stop() {
        speed = 0;
        System.out.println(brand + ": остановился");
    }

    @Override
    public void refuel(double amount) {
        if (amount <= 0) {
            System.out.println(brand + ": неверное количество топлива");
            return;
        }
        fuelLevel = Math.min(maxFuel, fuelLevel + amount);
        System.out.printf("%s: заправлено на %.1f л, уровень топлива %.1f л%n", brand, amount, fuelLevel);
    }

    @Override
    public String toString() {
        return "Car{brand='" + brand + "', speed=" + speed + ", fuelLevel=" + fuelLevel + "}";
    }
}
