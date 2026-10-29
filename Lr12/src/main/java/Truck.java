public class Truck extends Vehicle {
    private final double capacity;

    public Truck(String name, String id, int speed, double capacity) {
        super(name, id, speed);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    protected String typeName() {
        return "Грузовик";
    }

    @Override
    protected StringBuilder info() {
        return super.info().append(", грузоподъёмность: ").append(capacity).append(" т");
    }
}
