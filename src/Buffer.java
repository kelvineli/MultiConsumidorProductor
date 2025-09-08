public class Buffer {

    private final int [] buffer;
    private int count;
    private int in;
    private int out;

    public Buffer (int size){
        this.buffer= new int [size];
        count=in=out=0;
    }

    public synchronized void put (int value) throws InterruptedException{
        while (count==buffer.length){
            wait();
        }
        buffer[in]= value;
        in= (in+1)%buffer.length;
        count++;
        System.out.println(Thread.currentThread().getName()+" produjo: "+value);
        notifyAll();
    }

    public synchronized int get() throws InterruptedException{
        while (count== 0){
            wait ();
        }

        int value= buffer[out];
        out=(out +1) % buffer.length;
        count--;
        System.out.println(Thread.currentThread().getName()+" consumió: "+value);
        notifyAll();
        return value;
    }
}
