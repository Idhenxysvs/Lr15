import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);

    void main() {
        menu: while (true) {
            System.out.print("Введите номер задания (1-3), 4 - выход: ");
            int taskNumber = scan.nextInt();
            switch (taskNumber) {
                case 1:
                    this.task1();
                    break;
                case 2:
                    this.task2();
                    break;
                case 3:
                    this.task3();
                    break;
                case 4:
                    scan.close();
                    break menu;
                default:
                    System.out.print("Пункта под таким номером нету!");
            }
        }
    }

    void task1() {
        Book[] books = {
                new Book("Война и мир", "Толстой Л.Н.", 1869),
                new Book("Мастер и Маргарита", "Булгаков М.А.", 1966),
                new Book("Тихий ден", "", 2010)
        };

        for (Book book : books) {
            if (book.isOld()) {
                System.out.println(book);
            }
        }
    }

    void task2() {
        Student[] students = {
                new Student("Иванов Алексей", 7.5, "А1"),
                new Student("Петрова Мария", 6.8, "А1"),
                new Student("Сидоров Дмитрий", 3.9, "А1"),
                new Student("Козлова Анна", 4.2, "А2"),
                new Student("Новиков Сергей", 6.0, "А2"),
                new Student("Морозова Елена", 3.5, "А2"),
                new Student("Волков Артём", 8.7, "А2")
        };

        Student best = students[0];
        double sum = 0;

        for (Student s : students) {
            if (s.getGrade() > best.getGrade()) {
                best = s;
            }
            sum += s.getGrade();
        }

        double average = sum / students.length;

        System.out.println("Студент с максимальной оценкой: " + best);
        System.out.println("Средняя оценка: " + average);
    }

    void task3() {
        for (DayOfWeek day : DayOfWeek.values())
            System.out.println(day + ": " + day.isWeekend());
    }
}
