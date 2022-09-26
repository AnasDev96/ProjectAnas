package g53203.atl.fx.bmr.model;

/**
 * Enum VieStyle
 *
 * @author Anas Benallal - 53203
 */
public enum VieStyle {

    SEDENTAIRE("Sédentaire", 1.2),
    PEU_ACTIF("Peu Actif", 1.375),
    ACTIF("Actif", 1.55),
    FORT_ACTIF("Fort Actif", 1.725),
    EXTREMEMENT_ACTIF("Extrêmement Actif", 1.9);

    private final String viestyle;
    private final double niveau;

    /**
     * Simple constructor VieStyle
     *
     * @param viestyle String viestyle
     * @param niveau double niveau
     */
    VieStyle(String viestyle, double niveau) {
        this.niveau = niveau;
        this.viestyle = viestyle;
    }

    /**
     * Simple getter for niveau
     *
     * @return niveau
     */
    public double getNiveau() {
        return niveau;
    }

    /**
     * Simple getter for viestyle
     *
     * @return
     */
    public String getViestyle() {
        return viestyle;
    }

    @Override
    public String toString() {
        return viestyle;
    }
}
