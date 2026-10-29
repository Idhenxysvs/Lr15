public class StudentNotFoundException extends Exception {
    private final int id;

    public StudentNotFoundException(int id) {
        super("Студент не найден, id=" + id);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
