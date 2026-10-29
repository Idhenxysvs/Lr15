public class Vehicle {
    private final String name;
    private final String id;
    private final int speed;

    public Vehicle(String name, String id, int speed) {
        this.name = name;
        this.id = id;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    protected String typeName() {
        return "Транспортное средство";
    }

    protected StringBuilder info() {
        return new StringBuilder()
                .append("название:").append(name)
                .append(", id: ").append(id)
                .append(", скорость: ").append(speed);
    }

    @Override
    public String toString() {
        return typeName() + ": " + info();
    }
}
