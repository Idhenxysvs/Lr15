public class Car extends Vehicle {
    private final int doors;

    public Car(String name, String id, int speed, int doors) {
        super(name, id, speed);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    @Override
    protected String typeName() {
        return "Легковой автомобиль";
    }

    @Override
    protected StringBuilder info() {
        return super.info().append(", дверей: ").append(doors);
    }
}
