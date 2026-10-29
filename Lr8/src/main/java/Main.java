public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];

        animals[0] = new Dog("НДСыч", 5, 30.5, "Овчарка");
        animals[1] = new Dog("Пес патрон", 3, 12.0, "Джек-рассел");
        animals[2] = new Dog("Эксилион", 7, 25.3, "Лабрадор");
        animals[3] = new Cat("Премыч", 4, 4.2, "Невиданный");
        animals[4] = new Cat("Одинэсус", 2, 3.6, "Чорный");

        System.out.println("Все животные:");
        for (Animal animal : animals) {
            animal.displayInfo();
        }

        System.out.println();
        System.out.println("Демонстрация уникальных методов");
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                ((Dog) animal).fetch();
            } else if (animal instanceof Cat) {
                ((Cat) animal).purr();
            }
        }
    }
}
