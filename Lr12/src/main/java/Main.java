import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    void main() {
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put("Audi A4", new Car("Audi A4", "A-001", 240, 4));
        vehicles.put("BMW X5", new Car("BMW X5", "A-002", 250, 5));
        vehicles.put("Toyota Camry", new Car("Toyota Camry", "A-003", 210, 4));

        vehicles.put("Kamaz-5490", new Truck("Kamaz-5490", "T-001", 110, 20));
        vehicles.put("Volvo FH16", new Truck("Volvo FH16", "T-002", 120, 40));
        vehicles.put("MAN TGX", new Truck("MAN TGX", "T-003", 115, 25));

        vehicles.put("Honda Gold Wing", new Motorcycle("Honda Gold Wing", "M-001", 220, true));
        vehicles.put("Kawasaki Ninja", new Motorcycle("Kawasaki Ninja", "M-002", 300, false));

        System.out.println("\nСписок транспорта:");
        for (Map.Entry<String, Vehicle> entry : vehicles.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
