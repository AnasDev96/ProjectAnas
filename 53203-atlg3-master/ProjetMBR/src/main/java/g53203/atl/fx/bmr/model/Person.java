package g53203.atl.fx.bmr.model;

/**
 * Class Person, diferent data for one person
 *
 * @author Anas Benallal - 53203
 */
public class Person {

    private double taille;
    private double poids;
    private double age;
    private VieStyle viestyle;
    private boolean genre;

    /**
     * Simple constructor of Person
     *
     * @param taille double taille
     * @param poids double poids
     * @param age double age
     * @param viestyle VieStyle viestyle
     * @param genre boolean genre
     */
    public Person(double taille, double poids, double age, VieStyle viestyle, boolean genre) {
        this.taille = taille;
        this.poids = poids;
        this.age = age;
        this.viestyle = viestyle;
        this.genre = genre;
    }

    /**
     * Default constructor
     */
    Person() {
    }

    /**
     * Simple getter for genre
     *
     * @return genre
     */
    public boolean isGenre() {
        return genre;
    }

    /**
     * Simple getter for taille
     *
     * @return taille
     */
    public double getTaille() {
        return taille;
    }

    /**
     * Simple getter for poids
     *
     * @return
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Simple getter for Age
     *
     * @return age
     */
    public double getAge() {
        return age;
    }

    /**
     * Simple getter for VieStyle
     *
     * @return vieStyle
     */
    public VieStyle getViestyle() {
        return viestyle;
    }

    /**
     * Simple Setter for genre
     *
     * @param genre boolean genre
     */
    public void setGenre(boolean genre) {
        this.genre = genre;
    }

    /**
     * Simple setter for taille
     *
     * @param taille double taille
     */
    public void setTaille(double taille) {
        this.taille = taille;
    }

    /**
     * Simple setter for poids
     *
     * @param poids double poids
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }

    /**
     * Simple setter for Age
     *
     * @param age double age
     */
    public void setAge(double age) {
        this.age = age;
    }

    /**
     * Simple setter viestyle
     *
     * @param viestyle VieStyle viestyle
     */
    public void setViestyle(VieStyle viestyle) {
        this.viestyle = viestyle;
    }

}
