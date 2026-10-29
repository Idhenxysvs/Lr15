package transport;

public interface Test {
     int a = 100;
     int c = 12;

     void print();

     static int sum (int b) {return a + b;}
    static int sum (int d, int b) {return a + b;}
}
