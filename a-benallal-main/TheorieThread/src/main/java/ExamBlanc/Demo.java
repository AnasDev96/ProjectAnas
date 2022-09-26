
package ExamBlanc;

/**
 *
 * @author anasbenallal
 */
public class Demo  implements Runnable {
    
    private int balance;
    
    @Override
    public synchronized void run() {
        for (int i = 0; i < 500000; i++) {
            // System.out.println("Balance is " + balance);
            increment();
            System.out.println("Balance is " + balance);
        }
      // System.out.println("Balance is jhjh" + balance);
    }
    public void increment(){
    int i = balance;
    balance = i + 1;
    }
    
    public static void main(String[] args) {
        Demo job = new Demo();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
    }
}
