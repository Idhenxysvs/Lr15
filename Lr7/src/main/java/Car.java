public class Car {
    private String model;
    private int year;
    private int horsePower;

    private static int totalCars = 0;
    private static int totalHorsePower = 0;

    public Car(String model, int year, int horsePower) {
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
        totalCars++;
        totalHorsePower += horsePower;
    }

    public void setModel(String model) { this.model = model; }
    public String getModel() {
        return model;
    }

    public void setYear(int year) { this.year = year; }
    public int getYear() {
        return year;
    }

    public void setHorsePower(int horsePower) { this.horsePower = horsePower; }

    public int getHorsePower() {
        return horsePower;
    }

    public static int getTotalCars() {
        return totalCars;
    }

    public static int getTotalHorsePower() {
        return totalHorsePower;
    }

    public static double getAveragePower() {
        if (totalCars == 0) {
            return 0;
        }
        return (double) totalHorsePower / totalCars;
    }

    @Override
    public String toString() {
        return "Модель: " + model + "; год: " + year + "; мощность: " + horsePower;
    }
}
