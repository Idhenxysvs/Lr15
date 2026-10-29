public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public boolean isOld() {
        return 2026 - year > 50;
    }

    public String toString() {
        return title + " — " + author + ", " + year;
    }
}
