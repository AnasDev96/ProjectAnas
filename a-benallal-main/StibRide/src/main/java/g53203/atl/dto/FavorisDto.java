package g53203.atl.dto;

import java.util.Objects;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class FavorisDto {

    private int id;
    private String name;
    private String origine;
    private String destination;

    /**
     * Simple constructor for FavorisDto
     * @param id id 
     * @param name name 
     * @param origine origin 
     * @param destination destination
     */
    public FavorisDto(int id, String name, String origine, String destination) {
        this.id = id;
        this.name = name;
        this.origine = origine;
        this.destination = destination;
    }

    /**
     * Simple getter
     * @return id 
     */
    public int getId() {
        return id;
    }

    /**
     * Simple setter
     * @param id id to change
     */
    public void setId(int id) {
        this.id = id;
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
     * @param name name to change
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Simple getter
     * @return
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * Simple setter
     * @param origine to change
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
     *  Simple setter 
     * @param destination to change
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.origine);
        hash = 67 * hash + Objects.hashCode(this.destination);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FavorisDto other = (FavorisDto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.origine, other.origine)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FavorisDto{" + "id=" + id + ", name=" + name + ", origine=" + origine + ", destination=" + destination + '}';
    }

}
