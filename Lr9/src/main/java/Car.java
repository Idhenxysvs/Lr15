public class Car extends Vehicle {
    private int doors;

    public Car(String brand, int year, int speed, int doors) {
        super(brand, year, speed);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) { this.doors = doors; }

    @Override
    public void move() {
        System.out.println("Машина едет");
    }

    @Override
    public double fuelConsumption() {
        return 8;
    }

    @Override
    public void displayInfo() {
        System.out.println("[Автомобиль] " + getBrand() + ", " + getYear() + " г., "
                + getSpeed() + " км/ч, дверей: " + doors);
    }
}
