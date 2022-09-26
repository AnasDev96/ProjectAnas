package Deadlock;

import static Deadlock.Main.FORMATTER_TIME;
import java.time.LocalDateTime;

public class DeadThread extends Thread {

    private final Ressource first;
    private final Ressource second;
    private final String color;

    public DeadThread(Ressource first, Ressource second, String name, String color) {
        super(name);
        this.first = first;
        this.second = second;
        this.color = color;
    }

    @Override
    public void run() {
        print("Début du Thread ");

        print("\tAttend " + "\t" + first + "\t" + first.getStatus());

        synchronized (first) {
            first.lock();
            print("\tBloque " + "\t" + first);

            print("\tAttend " + "\t" + second + "\t" + second.getStatus());

            synchronized (second) {
                second.lock();
                print("\tBloque " + "\t" + second);

                print("\tTraitement en cours ");
            }

            second.unlock();
            print("\tLibère " + "\t" + second);

        }
        first.unlock();
        print("\tLibère " + "\t" + first);

        print("Fin du Thread ");
    }

    private void print(String text) {
        LocalDateTime time;
        time = LocalDateTime.now();
        System.out.println(color + "------|" + getName() + "|\t\t" + text + "\t" + FORMATTER_TIME.format(time) + "\u001B[30m");
    }
}
