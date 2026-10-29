import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            menu:
            while (true) {
                try {
                    System.out.print("Введите номер задания (1-5), 6 - выход: ");
                    int taskNumber = scan.nextInt();
                    scan.nextLine();
                    switch (taskNumber) {
                        case 1:
                            task1();
                            break;
                        case 2:
                            task2();
                            break;
                        case 3:
                            task3();
                            break;
                        case 4:
                            task4();
                            break;
                        case 5:
                            task5();
                            break;
                        case 6:
                            break menu;
                        default:
                            System.out.println("Пункта под таким номером нету!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Нужно ввести число!");
                    scan.nextLine();
                } catch (NoSuchFileException e) {
                    System.out.println("Файл не найден: " + e.getFile());
                } catch (IOException e) {
                    System.out.println("Ошибка ввода-вывода: " + e.getMessage());
                }
            }
        } finally {
            scan.close();
        }
    }

    static void task1() throws IOException {
        System.out.println("Задание 1:");
        Path file = Paths.get("city.txt");
        String info = """
                Город: Минск
                Страна: Беларусь
                Население: 2009786 человек
                Площадь: 348.8 км2
                Основан: 1067 год
                Река: Свислочь
                """;
        try {
            Files.writeString(file, info, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Не удалось записать файл: " + e.getMessage());
            return;
        }

        System.out.println("Имя файла: " + file.getFileName());
        System.out.println("Путь: " + file.toAbsolutePath());
        System.out.println("Размер: " + Files.size(file) + " байт");
        System.out.println("Существует: " + Files.exists(file));

        System.out.println("Содержимое файла:");
        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }

    static void task2() throws IOException {
        System.out.println("Задание 2:");
        Path file = Paths.get("f");
        try (var writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            System.out.println("Введите 10 целых чисел:");
            for (int i = 0; i < 10; i++) {
                while (true) {
                    try {
                        writer.write(String.valueOf(scan.nextInt()));
                        writer.newLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Нужно ввести целое число, повторите:");
                        scan.nextLine();
                    }
                }
            }
        }

        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        if (lines.isEmpty()) {
            System.out.println("Файл пуст, нет чисел для обработки.");
            return;
        }
        int max = Integer.MIN_VALUE;
        boolean hasValue = false;
        System.out.print("Числа из файла: ");
        for (String line : lines) {
            try {
                int value = Integer.parseInt(line.trim());
                System.out.print(value + " ");
                hasValue = true;
                if (value > max) {
                    max = value;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nПропущена некорректная строка: \"" + line + "\"");
            }
        }
        if (!hasValue) {
            System.out.println("\nНет корректных чисел для обработки.");
            return;
        }
        System.out.println("\nМаксимальное значение: " + max);
        System.out.println();
    }

    static void task3() throws IOException {
        System.out.println("Задание 3:");
        Random random = new Random();
        Path f = Paths.get("f");
        Path g = Paths.get("g");
        Path h = Paths.get("h");

        StringBuilder content = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            int value = random.nextInt(201) - 100;
            content.append(value).append(System.lineSeparator());
        }
        Files.writeString(f, content.toString(), StandardCharsets.UTF_8);

        StringBuilder positive = new StringBuilder();
        StringBuilder negative = new StringBuilder();
        for (String line : Files.readAllLines(f, StandardCharsets.UTF_8)) {
            try {
                int value = Integer.parseInt(line.trim());
                if (value > 0) {
                    positive.append(value).append(System.lineSeparator());
                } else if (value < 0) {
                    negative.append(value).append(System.lineSeparator());
                }
            } catch (NumberFormatException e) {
                System.out.println("Пропущена некорректная строка в f: \"" + line + "\"");
            }
        }
        Files.writeString(g, positive.toString(), StandardCharsets.UTF_8);
        Files.writeString(h, negative.toString(), StandardCharsets.UTF_8);

        System.out.println("f = " + f.toAbsolutePath());
        System.out.println("g (положительные) = " + g.toAbsolutePath());
        System.out.println("h (отрицательные) = " + h.toAbsolutePath());
        System.out.println("Содержимое f:\n" + Files.readString(f, StandardCharsets.UTF_8));
        System.out.println("Содержимое g:\n" + Files.readString(g, StandardCharsets.UTF_8));
        System.out.println("Содержимое h:\n" + Files.readString(h, StandardCharsets.UTF_8));
        System.out.println();
    }

    static void task4() throws IOException {
        System.out.println("Задание 4:");
        Path file = Paths.get("pressure");
        try (var writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            System.out.println("Введите 15 значений атмосферного давления:");
            for (int i = 0; i < 5; i++) {
                while (true) {
                    try {
                        double d = 0;
                        try {
                            d = scan.nextDouble();
                            if (d < 0)
                                throw new IllegalArgumentException("Давление не может быть меньше 0!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        writer.write(String.format(Locale.US, "%.2f", d));
                        writer.newLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Нужно ввести число, повторите:");
                        scan.nextLine();
                    }
                }
            }
        }

        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        if (lines.isEmpty()) {
            System.out.println("Файл пуст, нет значений для обработки.");
            return;
        }
        double sum = 0;
        int count = 0;
        System.out.println("Давления из файла:");
        for (String line : lines) {
            try {
                double value = Double.parseDouble(line.trim());
                System.out.println(line);
                sum += value;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Пропущена некорректная строка: \"" + line + "\"");
            }
        }
        if (count == 0) {
            System.out.println("Нет корректных значений для обработки.");
            return;
        }
        double average = sum / count;
        System.out.println("Среднее давление: " + String.format(Locale.US, "%.2f", average));
        System.out.println();
    }

    static void task5() throws IOException {
        System.out.println("Задание 5:");
        Path file = Paths.get("f");
        Random random = new Random();
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            content.append(random.nextInt(201) - 100).append(System.lineSeparator());
        }
        Files.writeString(file, content.toString(), StandardCharsets.UTF_8);

        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        if (lines.isEmpty()) {
            System.out.println("Файл пуст, нет чисел для обработки.");
            return;
        }
        int even = 0;
        boolean hasValue = false;
        System.out.print("Числа из файла: ");
        for (String line : lines) {
            try {
                int value = Integer.parseInt(line.trim());
                System.out.print(value + " ");
                hasValue = true;
                if (value % 2 == 0) {
                    even++;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nПропущена некорректная строка: \"" + line + "\"");
            }
        }
        if (!hasValue) {
            System.out.println("\nНет корректных чисел для обработки.");
            return;
        }
        System.out.println("\nКоличество чётных значений: " + even);
    }
}
