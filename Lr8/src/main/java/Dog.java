public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Гав-гав!";
    }

    public void fetch() {
        System.out.println(getName() + " (порода: " + breed + ") приносит мячик");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", издает звук: " + makeSound() + " " + super.);
    }
}
