package ThreadObjet;

import ThreadObjet.ToujoursPair;
import ThreadObjet.MyThread;

/**
 *
 * @author g53203
 */
public class Test  {

    public static void main(String[] args) {
       
        ToujoursPair tp = new ToujoursPair();
        MyThread t = new MyThread(tp);
        t.start();
      // boolean w = true;
        while (true) {
            tp.nextI();
            if (tp.getI() % 2 == 0) {
                System.out.println(tp.getI());
                //w = false;
                 //System.exit(0);
            }
        }
    
    }

}
