public class Consumidor extends Thread{

    private final Buffer buffer;
    private final int cantidad;

    public Consumidor(Buffer buffer, int cantidad, String nombre){
        super(nombre);
        this.buffer= buffer;
        this.cantidad= cantidad;
    }

    @Override
    public void run (){
        try{
            for (int i=1; i<= cantidad; i++){
                buffer.get();
                Thread.sleep(150); // Simula tiempo de consumo
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
