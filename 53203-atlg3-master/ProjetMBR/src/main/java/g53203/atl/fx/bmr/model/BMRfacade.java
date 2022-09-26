package g53203.atl.fx.bmr.model;

import g53203.atl.fx.bmr.util.Subject;

/**
 * Class BMRfacade, facade for model
 *
 * @author Anas Benallal - 53203
 */
public class BMRfacade extends Subject {

    private Person person;
    private boolean genre;

    /**
     * Simple Constructor BMRfacade
     */
    public BMRfacade() {
        this.person = new Person();
    }

    /**
     * Simple setter
     *
     * @param taille double taille
     * @param age double age
     * @param poids double poids
     * @param viestyle VieStyle viestyle
     * @param genre boolean genre
     */
    public void setData(double taille, double age, double poids, VieStyle viestyle, boolean genre) {
        person.setAge(age);
        person.setPoids(poids);
        person.setTaille(taille);
        person.setViestyle(viestyle);
        person.setGenre(genre);
        notifiyObserver();
    }

    /**
     * Simple getter for BMRhomme
     *
     * @return BMR homme
     */
    public double getBMRHomme() {
        double taille = person.getTaille();
        double age = person.getAge();
        double poids = person.getPoids();

        double value = 13.7 * poids + 5 * taille - 6.8 * age + 66;

        return value;
    }

    /**
     * Simple getter for person
     *
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Simple getter for BMR femme
     *
     * @return BMR femme
     */
    public double getBMRFemme() {
        double taille = person.getTaille();
        double age = person.getAge();
        double poids = person.getPoids();
        double value = 9.6 * poids + 1.8 * taille - 4.7 * age + 655;
        return value;
    }

    /**
     * Simple getter for Calorie Femme
     *
     * @return Calorie for femme
     */
    public double getCalorieFemme() {
        VieStyle viestyle = person.getViestyle();
        return getBMRFemme() * viestyle.getNiveau();
    }

    /**
     * Simple getter for homme
     *
     * @return Calorie Homme
     */
    public double getCalorieHomme() {
        VieStyle viestyle = person.getViestyle();
        return getBMRHomme() * viestyle.getNiveau();
    }
}
