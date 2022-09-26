package g53203.atl.fx.bmr.view;

import g53203.atl.fx.bmr.model.BMRfacade;
import g53203.atl.fx.bmr.model.VieStyle;
import g53203.atl.fx.bmr.util.Observer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * Class CalculBMR, for calcul BMR
 *
 * @author Anas Benallal - 53203
 */
public class CalculBmr extends Application implements Observer {

    /**
     * Method for lancn BMR
     *
     * @param args String arg
     */
    public static void main(String[] args) {
        launch(args);
    }
    private BMRfacade bmrfacade;
    private final Button clear = new Button("Clear");
    private final Button calcul = new Button("Calcule du BMR");
    private double value;
    private double calorie;
    BMRroot root = new BMRroot();
    ChartBMRWeight LineChartBMR;
    ChartBMRCalorie LineChartCalorie;
    ChartBMRHeight LineChartHeight;

    @Override
    public void start(Stage primaryStage) throws Exception {
        bmrfacade = new BMRfacade();

        LineChartBMR = new ChartBMRWeight(bmrfacade);
        LineChartCalorie = new ChartBMRCalorie(bmrfacade);
        LineChartHeight = new ChartBMRHeight(bmrfacade);

        primaryStage.setTitle("Calcul BMR");
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(450);

        TabPane tabpane = new TabPane();

        Tab Weightbmr = new Tab("Weight(kg) Vs BMR");
        tabpane.getTabs().add(Weightbmr);
        Weightbmr.setContent(LineChartBMR);

        Tab Weightcalorie = new Tab("Weight(kg) Vs Calorie");
        tabpane.getTabs().add(Weightcalorie);
        Weightcalorie.setContent(LineChartCalorie);

        Tab Height = new Tab("Height(cm) Vs BMR X");
        tabpane.getTabs().add(Height);
        Height.setContent(LineChartHeight);

        VBox Vboxroot = new VBox();
        MenuBar menu = new MenuBar();
        Menu file = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });

        file.getItems().addAll(exit);
        menu.getMenus().addAll(file);

        Vboxroot.getChildren().add(menu);
        HBox racine = new HBox();

        VBox VboxChart = new VBox();

        HBox hbox = new HBox();
        HBox Hboxroot = new HBox();
        Hboxroot.getChildren().add(root);

        VboxChart.getChildren().add(Hboxroot);
        VboxChart.getChildren().addAll(calcul, clear);
        VBox.setMargin(clear, new Insets(10, 0, 0, 100));
        VBox.setMargin(calcul, new Insets(0, 0, 0, 100));
        calcul.setPrefWidth(400);
        clear.setPrefWidth(400);
        VboxChart.setAlignment(Pos.CENTER_LEFT);

        hbox.getChildren().add(LineChartBMR);
        hbox.setAlignment(Pos.CENTER_RIGHT);

        racine.getChildren().add(VboxChart);
        racine.getChildren().add(tabpane);
        Vboxroot.getChildren().add(racine);

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alert");
        alert.setContentText("Erreur de donnée entrez");

        calcul.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                root.Style();
                root.getTfdbmr().setEditable(false);
                root.getTfdcalorie().setEditable(false);

                try {

                    double taille = root.getTfdtailleData();
                    double age = root.getTfdageData();
                    double poids = root.getTfdpoidsData();
                    if (taille == 0 || age == 0 || poids == 0) {
                        alert.show();
                    }
                    if (root.Style().equals(VieStyle.ACTIF)) {
                        bmrfacade.setData(taille, age, poids, VieStyle.ACTIF, root.getFemme().isSelected());
                        if (root.getFemme().isSelected()) {

                            calorie = bmrfacade.getCalorieFemme();
                            value = bmrfacade.getBMRFemme();
                        } else {
                            value = bmrfacade.getBMRHomme();
                            calorie = bmrfacade.getCalorieHomme();
                        }
                        root.setCalorie(calorie);
                        root.setBMR(value);
                    }
                    if (root.Style().equals(VieStyle.EXTREMEMENT_ACTIF)) {
                        bmrfacade.setData(taille, age, poids, VieStyle.EXTREMEMENT_ACTIF, root.getFemme().isSelected());
                        if (root.getFemme().isSelected()) {
                            calorie = bmrfacade.getCalorieFemme();
                            value = bmrfacade.getBMRFemme();
                        } else {
                            value = bmrfacade.getBMRHomme();
                            calorie = bmrfacade.getCalorieHomme();
                        }
                        root.setCalorie(calorie);
                        root.setBMR(value);
                    }
                    if (root.Style().equals(VieStyle.FORT_ACTIF)) {
                        bmrfacade.setData(taille, age, poids, VieStyle.FORT_ACTIF, root.getFemme().isSelected());
                        if (root.getFemme().isSelected()) {
                            calorie = bmrfacade.getCalorieFemme();
                            value = bmrfacade.getBMRFemme();
                        } else {
                            value = bmrfacade.getBMRHomme();
                            calorie = bmrfacade.getCalorieHomme();
                        }
                        root.setCalorie(calorie);
                        root.setBMR(value);
                    }
                    if (root.Style().equals(VieStyle.PEU_ACTIF)) {
                        bmrfacade.setData(taille, age, poids, VieStyle.PEU_ACTIF, root.getFemme().isSelected());
                        if (root.getFemme().isSelected()) {
                            calorie = bmrfacade.getCalorieFemme();
                            value = bmrfacade.getBMRFemme();
                        } else {
                            value = bmrfacade.getBMRHomme();
                            calorie = bmrfacade.getCalorieHomme();
                        }
                        root.setCalorie(calorie);
                        root.setBMR(value);
                    }
                    if (root.Style().equals(VieStyle.SEDENTAIRE)) {
                        bmrfacade.setData(taille, age, poids, VieStyle.SEDENTAIRE, root.getFemme().isSelected());
                        if (root.getFemme().isSelected()) {
                            calorie = bmrfacade.getCalorieFemme();
                            value = bmrfacade.getBMRFemme();
                        } else {
                            value = bmrfacade.getBMRHomme();
                            calorie = bmrfacade.getCalorieHomme();
                        }
                        root.setCalorie(calorie);
                        root.setBMR(value);
                    }

                } catch (Exception e) {
                    root.setError("Erreur de donnee");
                }
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getTfdage().clear();
                root.getTfdbmr().clear();
                root.getTfdcalorie().clear();
                root.getTfdtaille().clear();
                root.getTfdpoids().clear();
            }
        });
        EventHandler<KeyEvent> numberOnlyHandler = keyEvent -> {
            if (!keyEvent.getCharacter().matches("[0-9]*")) {
                keyEvent.consume();
            }
        };
        root.getTfdtaille().addEventHandler(KeyEvent.KEY_TYPED, numberOnlyHandler);
        root.getTfdage().addEventHandler(KeyEvent.KEY_TYPED, numberOnlyHandler);
        root.getTfdpoids().addEventHandler(KeyEvent.KEY_TYPED, numberOnlyHandler);
        root.getTfdbmr().addEventHandler(KeyEvent.KEY_TYPED, numberOnlyHandler);
        root.getTfdcalorie().addEventHandler(KeyEvent.KEY_TYPED, numberOnlyHandler);

        Scene scene = new Scene(Vboxroot);
        primaryStage.setScene(scene);
        primaryStage.show();
        bmrfacade.register(this);
    }

    @Override
    public void upDate() {
        root.setCalorie(calorie);
        root.setBMR(value);

    }

}
