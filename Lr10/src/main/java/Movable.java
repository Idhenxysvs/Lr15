public interface Movable {
    void move();

    void stop();

    int getSpeed();

    static String status(Movable object) {
        return object.getClass().getSimpleName() + ": speed=" + object.getSpeed();
    }
}
