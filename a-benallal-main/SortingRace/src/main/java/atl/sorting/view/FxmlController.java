package atl.sorting.view;

import atl.sorting.model.Generate;
import atl.sorting.model.TableViewApp;
import java.time.format.DateTimeFormatter;
import atl.sorting.obs.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import atl.sorting.obs.Observer;
import javafx.application.Platform;
import javafx.scene.chart.XYChart;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class FxmlController implements Observer {

    @FXML
    private TableView table;
    @FXML
    private LineChart<Number, Number> chart;
    @FXML
    private Spinner<Integer> threadSpinner;
    @FXML
    private ChoiceBox sortChoice, configurationChoice;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button start;
    @FXML
    private Label rightStatus, leftStatus;
    @FXML
    private TableColumn nameCol, sizeCol, swapCol, durationCol;
    @FXML
    private MenuItem quititem, aboutitem;

    private XYChart.Series bubble;
    private XYChart.Series merge;

    /**
     * initialize 
     */
    public void initialize() {
        sortChoice.getItems().add("Tri Fusion");
        sortChoice.getItems().add("Tri Bulle");
        sortChoice.setValue(sortChoice.getItems().get(0));
        configurationChoice.getItems().add("Very easy : 0 - 100 - 10");
        configurationChoice.getItems().add("Easy : 0 - 1000 - 100");
        configurationChoice.getItems().add("Moderate : 0 - 10 000 - 1 000");
        configurationChoice.getItems().add("Hard : 0 - 100 000 - 10 000");
        configurationChoice.setValue(configurationChoice.getItems().get(0));


        ObservableList<TableViewApp> tableList
                = FXCollections.observableArrayList();

        nameCol.setCellValueFactory(new PropertyValueFactory<>("sortType"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("taille"));
        swapCol.setCellValueFactory(new PropertyValueFactory<>("operation"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("milisecond"));
        table.setItems(tableList);


        SpinnerValueFactory<Integer> spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        threadSpinner.setValueFactory(spinner);


        bubble = new XYChart.Series();
        merge = new XYChart.Series();
        merge.setName("Tri Fusion");
        bubble.setName("Tri à Bulle");

        chart.getData().addAll(bubble, merge);

        leftStatus.setText("Thread actif :" + String.valueOf(Thread.activeCount()));
        progressBar.setProgress(0.0);

    }

    @FXML
    public void handleButtonAction(ActionEvent even) {

        int thread = threadSpinner.getValue();
        String typeSort = (String) sortChoice.getValue();
        String config = (String) configurationChoice.getValue();
        Generate generate = new Generate(thread, typeSort, config);
        generate.addObserver(this);
        generate.StartRace();
    }
    
    @FXML
    public void handleButtonClose(ActionEvent even){System.exit(0);}
    
    
    
    @Override
    public void update(Observable observable, Object arg) {

        Platform.runLater(() -> {

            leftStatus.setText("Thread actif :" + String.valueOf(Thread.activeCount()));
            TableViewApp tableViewApp = (TableViewApp) arg;
            progressBar.setProgress(progressBar.getProgress() + 0.1);
            switch (tableViewApp.getSortType()) {
                case "BUBBLE":
                    table.getItems().add(tableViewApp);
                    bubble.getData().add(new XYChart.Data(tableViewApp.getOperation(), tableViewApp.getTaille()));
                    break;
                case "MERGE":
                    table.getItems().add(tableViewApp);
                    merge.getData().add(new XYChart.Data(tableViewApp.getOperation(), tableViewApp.getTaille()));
                    break;
                default:
                    throw new IllegalArgumentException("Selection Tri non-trouvé");
            }
            rightStatus.setText("Derniére exécution | Début: " + tableViewApp.getDebut().format(DateTimeFormatter.ISO_LOCAL_TIME)
                    + " Fin : " + tableViewApp.getFin().format(DateTimeFormatter.ISO_LOCAL_TIME)
                    + " Durée : " + tableViewApp.getMilisecond() + " ms");
        });
    }   
}
