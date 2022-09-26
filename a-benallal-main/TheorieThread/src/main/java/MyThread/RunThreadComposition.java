
package MyThread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author g53203
 */
public class RunThreadComposition {
     public final static DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    /**
     * Entry points to the <code> Main </code>.
     *
     * @param args no arguments needed.
     */
    public static void main(String[] args) {
        print("Début du Main ");

        MyThreadComposition myThread = new MyThreadComposition();
        myThread.start();

        for (int index = 0; index < 5; index++) {
            print("\tBoucle du Main " + "\t" + index);
        }

        print("Fin du Main ");

    }

    private static void print(String text) {
        LocalDateTime time;
        time = LocalDateTime.now();
        System.out.println("|Main|\t" + text + "\t" + FORMATTER_TIME.format(time));
    }

}
