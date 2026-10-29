public class Bicycle implements Movable, Refuelable {
    private String brand;
    private int speed;
    private int gearCount;

    public Bicycle(String brand, int speed, int gearCount) {
        this.brand = brand;
        this.speed = speed;
        this.gearCount = gearCount;
    }

    public String getBrand() {
        return brand;
    }

    public int getGearCount() {
        return gearCount;
    }

    @Override
    public void move() {
        if (speed == 0) {
            speed = 15;
        }
        System.out.println(brand + ": едет со скоростью " + speed + " км/ч, передача " + gearCount);
    }

    @Override
    public void stop() {
        speed = 0;
        System.out.println(brand + ": остановился");
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void refuel(double amount) {
        System.out.println(brand + ": велосипеду топливо не требуется");
    }

    @Override
    public double getFuelLevel() {
        return 0;
    }

    @Override
    public String toString() {
        return "Bicycle{brand='" + brand + "', speed=" + speed + ", gearCount=" + gearCount + "}";
    }
}
