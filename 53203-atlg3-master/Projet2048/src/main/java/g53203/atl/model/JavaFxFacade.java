package g53203.atl.model;

import g53203.atl.util.Subject;
import javafx.scene.input.KeyCode;

/**
 * Class JavaFxFacad for set different data
 *
 * @author Anas Benallal 53203
 */
public class JavaFxFacade extends Subject {

    private JavaFxGame game;

    /**
     *
     * Constructor for JavaFxGame init game
     *
     * @param game game
     */
    public JavaFxFacade(JavaFxGame game) {
        this.game = game;
    }

    /**
     * Simple setter for different data javafxgame
     *
     * @param tab board of 2048
     * @param keycode code of direction
     */
    public void setData(int[][] tab, KeyCode keycode) {
        game.setKeycode(keycode);
        game.setTab(tab);
        notifiyObserver();
    }

    /**
     * Simple getter for game
     *
     * @return game
     */
    public JavaFxGame getGame() {
        return game;
    }

}
