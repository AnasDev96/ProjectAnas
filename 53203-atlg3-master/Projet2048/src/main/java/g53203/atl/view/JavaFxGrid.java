package g53203.atl.view;

import g53203.atl.model.Game;
import g53203.atl.model.JavaFxFacade;
import g53203.atl.util.Observable;
import java.time.format.DateTimeFormatter;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Class of JavaFxGrid for display the board of 2048
 *
 * @author Anas Benallal 53203
 */
public class JavaFxGrid extends GridPane implements Observable {

    private boolean repeat = true;
    private Game game = new Game();
    private final TextArea text = new TextArea();
    private final JavaFxFacade facade;
    private Label[][] label = new Label[game.getBoardTab().length][game.getBoardTab()[0].length];

    /**
     * Constructor of JavaFxGrid
     *
     * @param facade my facade
     */
    public JavaFxGrid(JavaFxFacade facade) {
        this.facade = facade;
        this.setAlignment(Pos.CENTER);
        text.setPrefWidth(200);
        text.setPrefHeight(400);
        text.setEditable(false);
        facade.register(this);
    }

    /**
     * Simple getter for text
     *
     * @return text
     */
    public TextArea getText() {
        return text;
    }

    /**
     * Simple getter for game
     *
     * @return game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Simple setter for repeat
     *
     * @param repeat repeat ,true or false
     */
    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    /**
     * Method for display a board of 2048 at the beginning
     */
    public void displayBegin() {
        game = new Game();
        label = new Label[game.getBoardTab().length][game.getBoardTab()[0].length];
        game.giveNumber();
        for (int x = 0; x < game.getBoardTab().length; x++) {
            for (int y = 0; y < game.getBoardTab()[x].length; y++) {
                label[x][y] = new Label(String.valueOf(game.getBoardTab()[x][y]));
                label[x][y].setMinHeight(100);
                label[x][y].setMinWidth(100);
                label[x][y].setAlignment(Pos.CENTER);
                label[x][y].setFont(Font.font("Cambria", 32));
                if (game.getBoardTab()[x][y] == 0 || game.getBoardTab()[x][y] == 2) {
                    label[x][y].setStyle("-fx-background-color:rgb(235, 227, 219)");
                }
                if (game.getBoardTab()[x][y] == 4) {
                    label[x][y].setStyle("-fx-background-color:rgb(235, 227, 202)");
                }
                this.add(label[x][y], y, x);
            }
        }
    }

    /**
     * Method for display text
     *
     * @param string text
     */
    public void displayText(String string) {
        text.appendText(java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")) + " - " + string);
        text.appendText("\n");
    }

    @Override
    public void upDate() {
        if (!game.finish()) {
            if (facade.getGame().moveStop()) {
                facade.getGame().moveNumber();
                game.giveNumber();
            } else {
                displayText("Mouvement impossible !");
            }
            for (int x = 0; x < game.getBoardTab().length; x++) {
                for (int y = 0; y < game.getBoardTab()[x].length; y++) {
                    label[x][y] = new Label(String.valueOf(facade.getGame().getTab()[x][y]));
                    label[x][y].setMinHeight(100);
                    label[x][y].setMinWidth(100);
                    label[x][y].setFont(Font.font("Cambria", 32));
                    label[x][y].setAlignment(Pos.CENTER);
                    if (game.getBoardTab()[x][y] == 0 || game.getBoardTab()[x][y] == 2) {
                        label[x][y].setStyle("-fx-background-color:rgb(235, 227, 219)");
                    } else if (game.getBoardTab()[x][y] == 4) {
                        label[x][y].setStyle("-fx-background-color:rgb(235, 227, 202)");
                    } else if (game.getBoardTab()[x][y] == 8) {
                        label[x][y].setStyle("-fx-background-color:rgb(244, 180, 124)");
                    } else if (game.getBoardTab()[x][y] == 16) {
                        label[x][y].setStyle("-fx-background-color:rgb(244, 148, 100)");
                    } else if (game.getBoardTab()[x][y] == 32) {
                        label[x][y].setStyle("-fx-background-color:rgb(244, 124, 92)");
                    } else if (game.getBoardTab()[x][y] == 64) {
                        label[x][y].setStyle("-fx-background-color:rgb(244, 92, 60)");
                    } else if (game.getBoardTab()[x][y] == 2048) {
                        label[x][y].setStyle("-fx-background-color:rgb(255,255,0)");
                    } else {
                        label[x][y].setStyle("-fx-background-color:rgb(244, 92, 60)");
                    }
                    this.add(label[x][y], y, x);
                }
            }
        } else {
            if (repeat) {
                displayText("Partie terminée. !");
            }
            if (game.tabWin(game.getBoardTab()) && repeat) {
                displayText("Vous avez gagné !");
                repeat = false;
            } else if (repeat) {
                displayText("Vous avez perdu.  :( ");
                repeat = false;
            }
        }
    }
}
