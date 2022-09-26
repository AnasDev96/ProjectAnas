package ThreadObjetSynchro2;

import java.util.Random;

/**
 *
 * @author 53203
 */
public class MyObject {

    private Random rnd;

    public MyObject() {
        rnd = new Random();
    }

    public void fct() {
        String nom = Thread.currentThread().getName();
        System.out.println("MyObject: " + nom + " in fct");
        // -------------- BLOC 1 -------------
       // synchronized (this) {
            synchronized("verrou") {
            System.out.println("MyObject: " + nom + " in bloc 1");
            try {
                Thread.sleep(rnd.nextInt(1000));
            } catch (InterruptedException e) {
            }
            System.out.println("MyObject: " + nom + " out bloc 1");
        }
        // -------------- BLOC 1 -------------
        
        System.out.println("MyObject: " + nom + " between bloc 1 and bloc 2");
        try {
            Thread.sleep(rnd.nextInt(1000));
        } catch (InterruptedException e) {
        }

        //synchronized (this) {
             synchronized ("verrou") {
            System.out.println("MyObject: " + nom + " in bloc 2");
            try {
                Thread.sleep(rnd.nextInt(1000));
            } catch (InterruptedException e) {
            }
            System.out.println("MyObject: " + nom + " out bloc 2");
        }

        System.out.println("MyObject: " + nom + " out fct");
    }
}
