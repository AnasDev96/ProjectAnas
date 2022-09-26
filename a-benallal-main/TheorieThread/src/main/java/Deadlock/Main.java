package Deadlock;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The <code> Main </code> .
 */
public class Main {

    public final static DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    /**
     * Entry points to the <code> Main </code>.
     *
     * @param args no arguments needed.
     */
    public static void main(String[] args) {
        print("Début du Main ");

        Ressource ressource1 = new Ressource("ressource 1");
        Ressource ressource2 = new Ressource("ressource 2");

        DeadThread thread1 = new DeadThread(ressource1, ressource2, "Premier Thread", "\u001B[32m");
        DeadThread thread2 = new DeadThread(ressource2, ressource1, "Second Thread", "\u001B[34m");

        thread1.start();
        thread2.start();

        print("Fin du Main ");

    }

    private static void print(String text) {
        LocalDateTime time;
        time = LocalDateTime.now();
        System.out.println("|Main|\t" + text + "\t" + FORMATTER_TIME.format(time));
    }

}
