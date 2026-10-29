public class Motorcycle extends Vehicle {
    private final boolean hasSidecar;

    public Motorcycle(String name, String id, int speed, boolean hasSidecar) {
        super(name, id, speed);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    @Override
    protected String typeName() {
        return "Мотоцикл";
    }

    @Override
    protected StringBuilder info() {
        return super.info().append(", боковой прицеп: ").append(hasSidecar ? "да" : "нет");
    }
}
