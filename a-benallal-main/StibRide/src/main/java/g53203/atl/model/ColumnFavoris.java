package g53203.atl.model;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class ColumnFavoris {

    private String name;
    private String origine;
    private String destination;

    /**
     * Simple constructor of ColumnFavoris
     * @param name of favoris 
     * @param origine favoris 
     * @param destination favoris
     */
    public ColumnFavoris(String name, String origine, String destination) {
        this.name = name;
        this.origine = origine;
        this.destination = destination;
    }

    /**
     * Simple getter 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * Simple setter
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Simple getter 
     * @return origin
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * Simple setter
     * @param origine to set
     */
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    /**
     * Simple getter 
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Simple setter 
     * @param destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

}
