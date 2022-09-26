package atl.sorting.controller;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class Controller extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = FXMLLoader.load(getClass().getResource("/fxml/sort.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     *  Method main for launch the application
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
}
