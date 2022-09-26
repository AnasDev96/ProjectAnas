package MyThread;

/**
 *
 * @author g53203
 */
public class TestMyTimer {

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer(4000);
        myTimer.start();
       
        try {
            Thread.sleep(7011); // Le pere est mis en pause pour laisser le temp au fils de s executer 
        } catch (InterruptedException e) {
            System.out.println("TestMyTimer: exception " + e);
        }
       
        myTimer.shouldRun = false;
        System.gc();
        System.out.println("MyTimer: gc called");
        System.out.println("MyTimer: end");
    }
}
