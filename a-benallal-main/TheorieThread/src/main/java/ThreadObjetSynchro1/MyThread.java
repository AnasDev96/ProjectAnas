package ThreadObjetSynchro1;

/**
 *
 * @author Anas Ben Allal 53203
 */
public class MyThread extends Thread {

    private MyObject myObject;

    public MyThread(String name, MyObject myObject) {
        super(name);
        this.myObject = myObject;
    }

    @Override
    public void run() {
        
        String nom = Thread.currentThread().getName();
        System.out.println("My thread: thread " + nom + " in run");
        
        myObject.show();
        
        System.out.println("My thread: thread " + nom + " out run");
    }
}
