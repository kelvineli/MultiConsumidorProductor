public class Main {
    public static void main(String[] args) {
        Buffer buffer= new Buffer(5);

        Productor p1= new Productor(buffer, 50, "Productor 1");
        Productor p2= new Productor(buffer, 50, "Productor 2");

        Consumidor c1= new Consumidor(buffer, 34, "Consumidor 1");
        Consumidor c2= new Consumidor(buffer, 33, "Consumidor 2");
        Consumidor c3= new Consumidor(buffer, 33, "Consumidor 3");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
