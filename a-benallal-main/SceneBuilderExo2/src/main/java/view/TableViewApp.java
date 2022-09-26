package view;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Anas Benallal 53203
 */
public class TableViewApp implements Initializable {

    @FXML
    private TableView<Etudiant> tableview;
    @FXML
    private TableColumn<Etudiant, String> prenomColumn;
    @FXML
    private TableColumn<Etudiant, String> nomColumn;
    @FXML
    private TableColumn<Etudiant, String> numerosColumn;
    @FXML
    private TextField matriculeField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;

    private ObservableList<Etudiant> etudiant 
            = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        numerosColumn.setCellValueFactory(new PropertyValueFactory<>("num"));
        tableview.setItems(etudiant);
    }

    @FXML
    public void handleButtonAction(ActionEvent event) {
        etudiant.add(new Etudiant(Integer.parseInt(matriculeField.getText()), prenomField.getText()  ,nomField.getText()));
    }
}

