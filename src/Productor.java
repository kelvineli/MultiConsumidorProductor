public class Productor extends Thread{

    private final Buffer buffer;
    private final int cantidad;

    public Productor(Buffer buffer, int cantidad, String nombre){
        super(nombre);
        this.buffer= buffer;
        this.cantidad= cantidad;
    }

    @Override
    public void run (){
        try {
            for (int i=1; i<= cantidad; i++){
                buffer.put(i);
                Thread.sleep(100); // Simula tiempo de producción
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
