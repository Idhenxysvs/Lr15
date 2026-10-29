package transport;

public class Test1 implements Test {
    @Override
    public void print() {
        System.out.println("класс, реализующий интерфес, c = " + Test.c);
    }

    public void print(String str) {
        System.out.println(str);
    }
}
