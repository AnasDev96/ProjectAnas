package view;

import javafx.beans.property.*;

/**
 *
 * @author Anas Benallal 53203
 */
public class Etudiant {

    /*
         L'objet pour un edutiant le type Simple permet l affichage dans 
         le tableview 
     */
    private SimpleIntegerProperty num;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;

    /**
     * Constructeur , convertie les differents objet pour le scenebuilder
     *
     * @param num
     * @param nom
     * @param prenom
     */
    public Etudiant(Integer num, String nom, String prenom) {
        this.num = new SimpleIntegerProperty(num);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
    }

    /**
     * getter pour le numbero de l etudiant
     *
     * @return
     */
    public int getNum() {
        return num.get();
    }

    /**
     * getter pour le nom de l etudiant
     *
     * @return
     */
    public String getNom() {
        return nom.get();
    }

    /**
     * getter pour le prenom de l etudiant
     *
     * @return
     */
    public String getPrenom() {
        return prenom.get();
    }

}
