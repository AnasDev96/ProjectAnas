package atl.sorting.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import atl.sorting.obs.Observable;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class SortingRun extends Observable implements Runnable {

    private ArrayList<int[]> arrayList;
    private Sorting sort;
  
    private String name;
    private int[] tab;
    private int taille;
    
    /**
     *  Simple constructor for SortingRun
     * @param arrayList the array
     * @param sort the method sort 
     * @param name  
     */
    public SortingRun(ArrayList<int[]> arrayList, Sorting sort, String name) {
        this.arrayList = arrayList;
        this.sort = sort;
        this.name = name;
    }

    /**
     * Method for get the array
     * @return the array
     */
    public int[] getElemTab() {
        int[] next = null;
        next = arrayList.isEmpty() ? null : arrayList.get(0);
        arrayList.remove(0);
        return next;
    }
    
    
    /**
     * method for give the length of array
     */
    private void movTab() {
        tab = !arrayList.isEmpty() ? getElemTab() : null;
        if(tab != null)
         taille = tab.length;
    }

    @Override
    public synchronized void run() { 
        movTab();
        while (tab != null) {
            LocalDateTime debut = LocalDateTime.now();
            long operation = sort.sort(tab, tab.length);
            LocalDateTime fin = LocalDateTime.now();
            long milis = Duration.between(debut, fin).toMillis();

            TableViewApp tableView = new TableViewApp(this.name, taille, operation, milis,debut,fin);
            //setChanged();
            notifyObservers(tableView);
            movTab();
        }
    }

}
