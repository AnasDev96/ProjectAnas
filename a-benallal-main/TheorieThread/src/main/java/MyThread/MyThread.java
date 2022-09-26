package MyThread;

/**
 *
 * @author g53203
 */
public class MyThread extends Thread {

    private String name;

    public MyThread(String s) {
        this.name = s;
    }

    @Override
    public void run() {
        
        for (int i = 0; i < 10; ++i) {
            
            for (int j = 0; j < 50000; ++j) ;
            System.out.println("MyThread: " + name + " : " + i);
        }
    
    }

}
