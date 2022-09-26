package MyThread;

/**
 *
 * @author g53203
 */
public class MyThreadComposition {

    private Thread thread;

    public MyThreadComposition() {
        thread = new Thread(new MyRunnable("one"));
    }

    public void start() {
        thread.start();
    }
}
