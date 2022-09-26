package view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Anas Benallal 53203
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/TableView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
