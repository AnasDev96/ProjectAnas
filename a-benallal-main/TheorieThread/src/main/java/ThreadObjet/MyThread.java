package ThreadObjet;

/**
 *
 * @author g53203
 */
public class MyThread extends Thread{

    ToujoursPair tp;

    public MyThread(ToujoursPair tp) {
        this.tp = tp;
    }

    @Override
    public synchronized void  run()  {
        while (true) {
            
            int val = tp.getI();
           
            if (val % 2 != 0) {
                
                System.out.println("myThread : " + val);
                System.exit(0);
            }
       
        }
    }
}
