import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private static final int minAge = 15;
    private static final int maxAge = 60;
    private static final int minGrade = 1;
    private static final int maxGrade = 10;
    private static final int maxCourse = 4;
    private static final Pattern groupPattern = Pattern.compile("^(.+)-(\\d{1,2})$");
    private static int nextId = 1;

    private final int id;
    private String name;
    private int age;
    private int grade;
    private String group;

    public Student(String name, int age, int grade, String group) throws InvalidStudentDataException {
        setName(name);
        setAge(age);
        setGrade(grade);
        setGroup(group);
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public String getGroup() {
        return group;
    }

    public void setName(String name) throws InvalidStudentDataException {
        if (name == null || name.isBlank()) {
            throw new InvalidStudentDataException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setAge(int age) throws InvalidStudentDataException {
        if (age < minAge || age > maxAge) {
            throw new InvalidStudentDataException("Возраст должен быть в диапазоне " + minAge + "-" + maxAge + ": " + age);
        }
        this.age = age;
    }

    public void setGrade(int newGrade) throws InvalidStudentDataException {
        if (newGrade < minGrade || newGrade > maxGrade) {
            throw new InvalidStudentDataException("Оценка должна быть в диапазоне " + minGrade + "-" + maxGrade + ": " + newGrade);
        }
        this.grade = newGrade;
    }

    public void setGroup(String group) throws InvalidStudentDataException {
        if (group == null || !groupPattern.matcher(group).matches()) {
            throw new InvalidStudentDataException("Некорректная группа: " + group);
        }
        int course = courseOf(group);
        if (course < 1 || course > maxCourse) {
            throw new InvalidStudentDataException("Курс должен быть в диапазоне 1-" + maxCourse + ": " + course);
        }
        this.group = group;
    }

    public void updateGrade(int newGrade) throws GradeUpdateException {
        try {
            setGrade(newGrade);
        } catch (InvalidStudentDataException e) {
            throw new GradeUpdateException(grade, newGrade);
        }
    }

    public void promote() throws InvalidStudentDataException {
        int course = courseOf(group);
        if (course >= maxCourse) {
            throw new InvalidStudentDataException("Студент уже учится на последнем курсе: " + group);
        }
        Matcher matcher = groupPattern.matcher(group);
        matcher.matches();
        setGroup(matcher.group(1) + "-" + (course + 1));
    }

    private static int courseOf(String group) throws InvalidStudentDataException {
        Matcher matcher = groupPattern.matcher(group);
        if (!matcher.matches()) {
            throw new InvalidStudentDataException("Некорректная группа: " + group);
        }
        return Integer.parseInt(matcher.group(2));
    }

    @Override
    public String toString() {
        return "Студент" + id + ": имя: " + name + ", возраст: " + age + ", оценка: " + grade + ", группа: " + group;
    }
}
