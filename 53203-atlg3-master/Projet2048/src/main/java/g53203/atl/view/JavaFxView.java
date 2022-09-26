package g53203.atl.view;

import g53203.atl.model.JavaFxFacade;
import g53203.atl.model.JavaFxGame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Class JavaFxView, for display and start game of 2048
 *
 * @author Anas Benallal 53203
 */
public class JavaFxView extends Application {
    
    private final Button recommencer = new Button("Recommencer");
    private final JavaFxGame move = new JavaFxGame();
    private JavaFxGrid grid;
    private final VBox root = new VBox();
    private final HBox hbox = new HBox();
    private JavaFxFacade facade;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        facade = new JavaFxFacade(move);
        grid = new JavaFxGrid(facade);
        grid.displayBegin();
        
        primaryStage.setTitle("2048");
        primaryStage.setMinWidth(100);
        primaryStage.setMinHeight(550);
        
        hbox.getChildren().add(grid);
        hbox.getChildren().add(grid.getText());
        grid.displayText("Bienvenu au 2048 !");
        HBox.setMargin(grid.getText(), new Insets(0, 10, 0, 10));
        
        grid.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        recommencer.setPrefWidth(200);
        recommencer.setPrefHeight(50);
        recommencer.setFont(Font.font("Cambria", 25));
        recommencer.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        recommencer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.displayBegin();
                grid.displayText("Partie recommencée !");
                grid.setRepeat(true);
            }
        });
        root.getChildren().add(hbox);
        root.setAlignment(Pos.BOTTOM_LEFT);
        root.getChildren().add(recommencer);
        
        VBox.setMargin(recommencer, new Insets(20, 0, 20, 20));
        root.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(root);
        
        scene.setOnKeyReleased(e -> {
            facade.setData(grid.getGame().getBoardTab(), e.getCode());
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * Method main for launch
     *
     * @param args args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
