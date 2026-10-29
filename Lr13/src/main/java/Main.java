import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Выбор действия: ");
            switch (choice) {
                case 1:
                    inputStudent(students);
                    break;
                case 2:
                    System.out.println("Список студентов:");
                    printStudents(students);
                    break;
                case 3:
                    updateStudentGrade(students);
                    break;
                case 4:
                    promoteStudent(students);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Неизвестный пункт меню: " + choice);
            }
        }
        System.out.println("Работа завершена.");
    }

    static void printMenu() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("  1. Добавить студента");
        System.out.println("  2. Показать список");
        System.out.println("  3. Обновить оценку");
        System.out.println("  4. Перевести на следующий курс");
        System.out.println("  5. Выход");
    }

    static void inputStudent(List<Student> students) {
        System.out.println("Добавление студента (отмена - пустое имя):");
        String name = readLine("  Имя: ");
        if (name.isBlank()) {
            System.out.println("  Добавление отменено.");
            return;
        }
        int age = readInt("  Возраст (15-60): ");
        int grade = readInt("  Оценка (1-10): ");
        String group = readLine("  Группа (например Т-2): ");
        addStudent(students, name, age, grade, group);
    }

    static void updateStudentGrade(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println(" Список пуст.");
            return;
        }
        int index = readInt("  Индекс студента (0-" + (students.size() - 1) + "): ");
        try {
            Student student = studentAt(students, index);
            int newGrade = readInt("  Новая оценка (1-10): ");
            int oldGrade = student.getGrade();
            student.updateGrade(newGrade);
            System.out.println("  " + student.getName() + ": " + oldGrade + " -> " + student.getGrade());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Ошибка: " + e.getMessage());
        } catch (GradeUpdateException e) {
            System.err.println("  Ошибка: " + e.getMessage());
            System.out.println("  Старая оценка сохранена: " + e.getOldGrade());
        }
    }

    static void promoteStudent(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println(" Список пуст.");
            return;
        }
        int index = readInt(" Индекс студента (0-" + (students.size() - 1) + "): ");
        try {
            Student student = studentAt(students, index);
            String oldGroup = student.getGroup();
            student.promote();
            System.out.println("  " + student.getName() + ": " + oldGroup + " -> " + student.getGroup());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(" Ошибка: " + e.getMessage());
        } catch (InvalidStudentDataException e) {
            System.out.println(" Ошибка: " + e.getMessage());
        }
    }

    static String readLine(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            throw new IllegalStateException("Ввод закончился");
        }
        return scanner.nextLine().trim();
    }

    static int readInt(String prompt) {
        while (true) {
            String line = readLine(prompt);
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println(" Ошибка: '" + line + "' не является целым числом, попробуйте снова");
            }
        }
    }

    static void addStudent(List<Student> students, String name, int age, int grade, String group) {
        try {
            Student student = new Student(name, age, grade, group);
            students.add(student);
            System.out.println(" Добавлен: " + student);
        } catch (InvalidStudentDataException e) {
            System.out.println(" Не удалось создать студента '" + name + "': " + e.getMessage());
        }
    }

    static Student studentAt(List<Student> students, int index) {
        if (index < 0 || index >= students.size()) {
            throw new IndexOutOfBoundsException(
                    "Индекс " + index + " вне диапазона 0-" + (students.size() - 1));
        }
        return students.get(index);
    }

    static void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println(" Список пуст");
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            System.out.println("  [" + i + "] " + students.get(i));
        }
    }
}
