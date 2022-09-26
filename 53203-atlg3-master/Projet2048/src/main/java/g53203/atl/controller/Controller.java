package g53203.atl.controller;

import g53203.atl.model.Game;
import g53203.atl.model.Model;
import g53203.atl.view.InterfaceView;
import g53203.atl.view.View;

/**
 * Class Controller for run the game
 * @author g53203 - Anas Ben Allal
 */
public class Controller {

    Model game;
    InterfaceView view;

    /**
     * Constructor of controller
     * @param game Game
     * @param view View
     */
    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * For run the game
     */
    public void startGame() {
        view.displayTouch();
        game.giveNumber();
        boolean except = false;
        int direction;
        try {
            while (!game.finish()) {
                view.displayBoard(game.getBoardTab());
                direction = view.askMove();
                if (game.moveStop(direction)) {
                    game.moveNumber(direction);
                    game.giveNumber();
                }
            }
        } catch (Exception e) {
            view.displayError("Mauvaise commande entrer, veuillez réessayer");
            except = true;
        }
        if (!except) {
            view.displayWinnerOrLoser(game.tabWin(game.getBoardTab()));

        }
    }

}
