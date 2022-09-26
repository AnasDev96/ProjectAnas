package g53203.atl.fx.bmr.view;

import g53203.atl.fx.bmr.model.VieStyle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 * Class BMRroot, Gridpane for BMR
 * @author Anas Benallal - 53203
 */
public class BMRroot extends GridPane {

  
    private final Label lblcalorie = new Label("Calories");
    private final Label lblbmr = new Label("BMR");
    private final Label lblresultat = new Label("Resultat");
    private final Label lblStyle = new Label("Style de vie");
    private final Label lblage = new Label("Age (années)");
    private final Label lblpoids = new Label("Poids (kg)");
    private final Label lbltaille = new Label("Taille (cm)");
    private final Label lbldonnée = new Label("Données");

    private final TextField tfdtaille = new TextField();
    private final TextField tfdage = new TextField();
    private final TextField tfdpoids = new TextField();

    private final RadioButton homme = new RadioButton(); //homme
    private final RadioButton femme = new RadioButton(); //femme
    private final ChoiceBox style = new ChoiceBox();
    private final TextField tfdcalorie = new TextField();
    private final TextField tfdbmr = new TextField();
    private final ToggleGroup bouttonSex = new ToggleGroup();
   
    /**
     * Simple Constructor for BMRroot
     */
    public BMRroot() {

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(5));
        this.setHgap(30);
        this.setVgap(35);

        lbldonnée.setUnderline(true);
        this.add(lbldonnée, 0, 0);
        GridPane.setMargin(lbldonnée, new Insets(0, 0, -30, 0));

        this.add(lbltaille, 0, 1);
        GridPane.setMargin(lbltaille, new Insets(0, 5, -30, 0));

        tfdtaille.setPromptText("Taille en cm");
        tfdtaille.setPrefColumnCount(10);
        this.add(tfdtaille, 1, 1);
        GridPane.setMargin(tfdtaille, new Insets(0, 10, -30, -30));

        this.add(lblpoids, 0, 2);

        tfdpoids.setPromptText("Poids en kg");
        tfdpoids.setPrefColumnCount(10);
        this.add(tfdpoids, 1, 2);
        GridPane.setMargin(tfdpoids, new Insets(0, 10, 0, -30));

        this.add(lblage, 0, 3);
        GridPane.setMargin(lblage, new Insets(-30, 5, 0, 0));

        tfdage.setPromptText("Age en années");
        tfdage.setPrefColumnCount(10);
        this.add(tfdage, 1, 3);
        GridPane.setMargin(tfdage, new Insets(-30, 10, 0, -30));

        femme.setText("Femme");
        this.add(femme, 1, 4);

        homme.setText("Homme");
        this.add(homme, 2, 4);
        GridPane.setMargin(femme, new Insets(-50, 10, 0, -30));
        GridPane.setMargin(homme, new Insets(-50, 10, 0, -100));

        this.add(lblStyle, 0, 4);

        style.getItems().add(VieStyle.ACTIF);
        style.getItems().add(VieStyle.EXTREMEMENT_ACTIF);
        style.getItems().add(VieStyle.PEU_ACTIF);
        style.getItems().add(VieStyle.SEDENTAIRE);
        style.getItems().add(VieStyle.FORT_ACTIF);
        this.add(style, 1, 4);
        GridPane.setMargin(style, new Insets(0, 0, 0, -30));

        lblresultat.setUnderline(true);
        this.add(lblresultat, 3, 0);
        GridPane.setMargin(lblresultat, new Insets(0, 0, -30, 0));

        this.add(lblbmr, 3, 1);
        GridPane.setMargin(lblbmr, new Insets(0, 5, -30, -60));

        tfdbmr.setPromptText("Resultat du BMR");
        tfdbmr.setPrefColumnCount(10);
        this.add(tfdbmr, 4, 1);
        GridPane.setMargin(tfdbmr, new Insets(0, 10, -30, -100));

        this.add(lblcalorie, 4, 2);
        GridPane.setMargin(lblcalorie, new Insets(0, -150, 0, -140));

        tfdcalorie.setPromptText("Dépense en calories");
        tfdcalorie.setPrefColumnCount(9);
        this.add(tfdcalorie, 5, 2);
        GridPane.setMargin(tfdcalorie, new Insets(0, 10, 0, -160));
        homme.setToggleGroup(bouttonSex);
        femme.setToggleGroup(bouttonSex);

    }
    /**
     * Simple getter for homme
     * @return homme
     */
    public RadioButton getHomme() {
        return homme;
    }
    /**
     * Simple getter for femme
     * @return 
     */
    public RadioButton getFemme() {
        return femme;
    }
    /**
     * Simple getter for Style
     * @return style
     */
    public Object Style() {
        return style.getValue();
    }
    /**
     * Simple getter for taille
     * @return taille
     */
    double getTfdtailleData() {
        return Double.parseDouble(tfdtaille.getText());
    }
    /**
     * Simple getter for age
     * @return age
     */
    double getTfdageData() {
        return Double.parseDouble(tfdage.getText());
    }
    /**
     * Simple getter for poids
     * @return poids
     */
    double getTfdpoidsData() {
        return Double.parseDouble(tfdpoids.getText());
    }
    /**
     * Simple getter for taille
     * @return taille
     */
    public TextField getTfdtaille() {
        return tfdtaille;
    }
    /**
     * Simple getter for age
     * @return poids
     */
    public TextField getTfdage() {
        return tfdage;
    }
    /**
     * Simple getter for poids
     * @return poids
     */
    public TextField getTfdpoids() {
        return tfdpoids;
    }
    /**
     * Simple getter for calorie
     * @return calorie
     */
    public TextField getTfdcalorie() {
        return tfdcalorie;
    }
    /**
     * Simple getter for bmr
     * @return bmr
     */
    public TextField getTfdbmr() {
        return tfdbmr;
    }
    /**
     * Simple setter for BMR
     * @param value double for set
     */
    void setBMR(double value) {
        tfdbmr.setText(String.valueOf(value));
    }
    /**
     *  Simple setter for Calorie
     * @param value double for set
     */
    void setCalorie(double value) {
        tfdcalorie.setText(String.valueOf(value));
    }
    /**
     * Mehtode for set error message
     * @param message String message
     */
    void setError(String message) {
        tfdtaille.setPromptText(message);
        tfdpoids.setPromptText(message);
        tfdage.setPromptText(message);
        tfdbmr.setPromptText("Fail!");
        tfdcalorie.setPromptText("Fail!");
        tfdcalorie.setStyle("-fx-prompt-text-fill: red");
        tfdbmr.setStyle("-fx-prompt-text-fill: red");

        tfdtaille.setStyle("-fx-prompt-text-fill: red");
        tfdage.setStyle("-fx-prompt-text-fill: red");
        tfdpoids.setStyle("-fx-prompt-text-fill: red");
    }


}
