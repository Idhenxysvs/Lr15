public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, int year, int speed, boolean hasSidecar) {
        super(brand, year, speed);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void move() {
        System.out.println("Мотоцикл едет");
    }

    @Override
    public double fuelConsumption() {
        return 4;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Мотоцикл] " + getBrand() + ", " + getYear() + " г., "
                + getSpeed() + " км/ч, коляска: " + (hasSidecar ? "есть" : "нет"));
    }
}
