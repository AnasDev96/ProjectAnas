package atl.sorting.model;

import java.time.LocalDateTime;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class TableViewApp {

    private String sortType;
    private int taille;
    private long operation;
    private long milisecond;
    private LocalDateTime debut;
    private LocalDateTime fin;
    
    /**
     * Simple constructor of TableViewApp
     * @param sortType the sort type 
     * @param taille the length of the array
     * @param operation the number of operation
     * @param milisecond the time
     * @param debut the begin
     * @param fin the end 
     */
    public TableViewApp(String sortType, int taille, long operation, long milisecond, LocalDateTime debut, LocalDateTime fin) {
        this.sortType = sortType;
        this.taille = taille;
        this.operation = operation;
        this.milisecond = milisecond;
        this.debut = debut;
        this.fin = fin;
    }

    /**
     * Simple getter
     * @return the sort type 
     */
    public String getSortType() {
        return sortType;
    }

    /**
     * Simple getter
     * @return the number of operation
     */
    public long getOperation() {
        return operation;
    }

    /**
     * Simple getter
     * @return the time 
     */
    public long getMilisecond() {
        return milisecond;
    }

    /**
     * Simple getter
     * @return the length of array
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Simple getter
     * @return the begin 
     */
    public LocalDateTime getDebut() {
        return debut;
    }

    /**
     * Simple getter
     * @return the end 
     */
    public LocalDateTime getFin() {
        return fin;
    }

}
