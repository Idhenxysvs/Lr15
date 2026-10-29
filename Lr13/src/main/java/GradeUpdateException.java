public class GradeUpdateException extends Exception {
    private final int oldGrade;
    private final int newGrade;

    public GradeUpdateException(int oldGrade, int newGrade) {
        super("Не удалось обновить оценку: " + oldGrade + " -> " + newGrade);
        this.oldGrade = oldGrade;
        this.newGrade = newGrade;
    }

    public int getOldGrade() {
        return oldGrade;
    }

    public int getNewGrade() {
        return newGrade;
    }
}
