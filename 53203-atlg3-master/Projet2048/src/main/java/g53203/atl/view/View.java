package g53203.atl.view;

import static java.lang.System.in;
import java.util.Scanner;

/**
 * Class View for display the game
 *
 * @author Anas Ben Allal 53203
 */
public class View implements InterfaceView {

    @Override
    public int askMove() {
        Scanner clavier = new Scanner(in);
        int keyboard = clavier.nextInt();
        if (keyboard == 0 || keyboard != 5 && keyboard != 2
                && keyboard != 3 && keyboard != 1) {
            throw new IllegalArgumentException("");
        }
        return keyboard;
    }

    @Override
    public void displayBoard(int[][] tab) {
        for (int i = 0; i < tab.length * 4; i++) {
            if (i % 4 == 0) {
                System.out.println("----------------------------");
                i++;
            }
            for (int j = 0; j < tab.length; j++) {
                if (i % 2 != 0 && i % 4 != 0) {
                    System.out.print("|     |");
                } else if (tab[i / 4][j] == 0) {
                    System.out.print("|     |");
                } else if (i % 2 == 0 && i % 4 != 0) {
                    if (tab[i / 4][j] < 10) {
                        System.out.print("|  " + tab[i / 4][j] + "  |");
                    } else if (tab[i / 4][j] > 10 && tab[i / 4][j] < 100) {
                        System.out.print("|  " + tab[i / 4][j] + " |");
                    } else if (tab[i / 4][j] > 100 && tab[i / 4][j] < 1000) {
                        System.out.print("| " + tab[i / 4][j] + " |");
                    } else {
                        System.out.print("| " + tab[i / 4][j] + "|");
                    }
                }
            }
            System.out.println("");
        }
        System.out.println("----------------------------");
    }

    @Override
    public void displayTouch() {
        System.out.println("Bienvenu sur le jeux 2048 !");
        System.out.println("Pour gerer les deplacements c'est ceci:");
        System.out.println("  5");
        System.out.println("1 2 3");
        System.out.println("");
    }

    @Override
    public void displayError(String message) {
        System.out.println(message);
    }

    @Override
    public void displayWinnerOrLoser(boolean player) {
        if (player) {
            System.out.println("Felicitation!");
        } else {
            System.out.println("Pedu!");
        }
    }
}
