package g53203.atl.view;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.StationsDto;
import g53203.atl.dto.StationsNLDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.model.Column;
import g53203.atl.model.ColumnFavoris;
import g53203.atl.model.StationsStops;
import g53203.atl.presenter.Presenter;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.SearchableComboBox;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class ViewController {

    @FXML
    private ImageView imageReseaux;

    @FXML
    private ImageView imageLogo;

    @FXML
    private SearchableComboBox origine;

    @FXML
    private SearchableComboBox destination;

    @FXML
    private Button addFavoris;

    @FXML
    private Button modifyFavoris;

    @FXML
    private Button removeFavoris;

    @FXML
    private Button searchButton;

    @FXML
    private TableView table;

    private Presenter presenter;

    @FXML
    private TableColumn<Column, String> columnStation;

    @FXML
    private TableColumn<Column, List<Integer>> columnLines;

    @FXML
    private Label textOrigin;

    @FXML
    private Label textDestination;

    @FXML
    private Label textFavoris;

    @FXML
    private TextField textAddFavoris;

    @FXML
    private TextField textModifyFavoris;

    @FXML
    private TableView tableFavoris;

    @FXML
    private TableColumn<ColumnFavoris, String> columnNom;

    @FXML
    private TableColumn<ColumnFavoris, String> columnOrigine;

    @FXML
    private TableColumn<ColumnFavoris, String> columnDestination;

    @FXML
    private Menu fileId;

    @FXML
    private Menu editId;

    private boolean pressed = false;
    private int count = 0;

    /**
     * Method for initialize stuff of fxml
     *
     * @throws RepositoryException
     * @throws IOException
     */
    public void initialize() throws RepositoryException, IOException {
        ConfigManager.getInstance().load();
        presenter = new Presenter(this);
        List<StationsDto> stationsList = presenter.getStations();
        for (StationsDto dto : stationsList) {
            origine.getItems().add(dto.getName());
            destination.getItems().add(dto.getName());
        }

        ObservableList<StationsStops> list = FXCollections.observableArrayList();
        columnStation.setCellValueFactory(new PropertyValueFactory<>("stations"));
        columnLines.setCellValueFactory(new PropertyValueFactory<>("lines"));
        table.setItems(list);

        ObservableList<ColumnFavoris> listFavoris = FXCollections.observableArrayList();
        columnNom.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnOrigine.setCellValueFactory(new PropertyValueFactory<>("origine"));
        columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tableFavoris.setItems(listFavoris);

        for (int i = 0; i < presenter.getFavoris().size(); i++) {
            tableFavoris.getItems().add(new ColumnFavoris(presenter.getFavoris().get(i).getName(),
                    presenter.getFavoris().get(i).getOrigine(), presenter.getFavoris().get(i).getDestination()));
        }

    }

    @FXML
    public void handleButtonAction(ActionEvent action) throws RepositoryException, IOException {
        //TODO a chaque fois que l'utilisateur click sur recherche fait pas appel a ledit 
        String origineString = origine.getValue().toString();
        String destinationString = destination.getValue().toString();
        presenter.handleDijkstra(origineString, destinationString, pressed);
    }

    @FXML
    public void handleButtonActionFileClose(ActionEvent action) throws RepositoryException, IOException {
        System.exit(0);
    }

    @FXML
    public void handleButtonActionEdit(ActionEvent action) throws RepositoryException, IOException {
        //TODO afficher les langues du scrollbar en ndls
        ConfigManager.getInstance().load();
        origine.getItems().clear();
        destination.getItems().clear();
        pressed = true;
        count++;
        if (pressed && count % 2 != 0) {
            List<StationsNLDto> stationsList = presenter.getStationsNL();
            for (StationsNLDto dto : stationsList) {
                origine.getItems().add(dto.getName());
                destination.getItems().add(dto.getName());
            }
        } else {
            List<StationsDto> stationsList = presenter.getStations();
            for (StationsDto dto : stationsList) {
                origine.getItems().add(dto.getName());
                destination.getItems().add(dto.getName());
            }
            pressed = false;
        }
    }

    @FXML
    public void handleButtonActionAddFavoris(ActionEvent action) throws RepositoryException, IOException {
        tableFavoris.getItems().clear();
        String origineString = origine.getValue().toString();
        String destinationString = destination.getValue().toString();
        presenter.setDBFavoris(presenter.getFavoris().size() + 1, textAddFavoris.getText(), origineString, destinationString);
        for (int i = 0; i < presenter.getFavoris().size(); i++) {
            tableFavoris.getItems().add(new ColumnFavoris(presenter.getFavoris().get(i).getName(),
                    presenter.getFavoris().get(i).getOrigine(), presenter.getFavoris().get(i).getDestination()));
        }
    }

    @FXML
    public void handleButtonActionModifyFavoris(ActionEvent action) throws RepositoryException, IOException {
        ColumnFavoris fav = (ColumnFavoris) tableFavoris.getSelectionModel().getSelectedItem();
        presenter.updateDBFavoris(textModifyFavoris.getText(), fav);
        tableFavoris.getItems().clear();
        for (int i = 0; i < presenter.getFavoris().size(); i++) {
            tableFavoris.getItems().add(new ColumnFavoris(presenter.getFavoris().get(i).getName(),
                    presenter.getFavoris().get(i).getOrigine(), presenter.getFavoris().get(i).getDestination()));
        }
    }

    @FXML
    public void handleButtonActionDeleteFavoris(ActionEvent action) throws RepositoryException, IOException {
        ColumnFavoris fav = (ColumnFavoris) tableFavoris.getSelectionModel().getSelectedItem();
        presenter.deleteFavoris(fav);
        tableFavoris.getItems().clear();
        for (int i = 0; i < presenter.getFavoris().size(); i++) {
            tableFavoris.getItems().add(new ColumnFavoris(presenter.getFavoris().get(i).getName(),
                    presenter.getFavoris().get(i).getOrigine(), presenter.getFavoris().get(i).getDestination()));
        }
    }
    /**
     * Method for get all stations and their lines
     * @param column list of Column
     */
    public void newDataUpdate(List<Column> column) {
        table.getItems().clear();
        for (int i = 0; i < column.size(); i++) {
            table.getItems().add(column.get(i));
        }
    }

}
