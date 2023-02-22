package tempconversionclient;

public class Main {

    public static void main(String[] args) {
        try {
        MyThread myThread1 = new MyThread();
        myThread1.start();
        myThread1.join();
        }
        catch(InterruptedException e) {
            System.out.println(e);
        }
    }
    
}
