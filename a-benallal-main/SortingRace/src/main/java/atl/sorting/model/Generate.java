package atl.sorting.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;
import atl.sorting.obs.Observable;
import atl.sorting.obs.Observer;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class Generate extends Observable implements Observer {

    private int nbThread;
    private String typeTri;
    private String configuration;
    private ArrayList<int[]> array;

    /**
     * Simple constructor of Generate
     *
     * @param nbThread number of thread
     * @param typeTri the type of the sort
     * @param configuration the configuration for the sort
     */
    public Generate(int nbThread, String typeTri, String configuration) {
        this.nbThread = nbThread;
        this.typeTri = typeTri;
        this.configuration = configuration;
        array = generateArrays(choiceConfiguration(configuration));
    }

    /**
     * Simple setter
     *
     * @param array the array
     */
    public void setArray(ArrayList<int[]> array) {
        this.array = array;
    }

    /**
     * Simple getter
     *
     * @return array list
     */
    public ArrayList<int[]> getArray() {
        return array;
    }

    /**
     * Method for give the number for the choice configuration
     *
     * @param configuration the choice
     * @return the number
     */
    public int choiceConfiguration(String configuration) {
        switch (configuration) {
            case "Very easy : 0 - 100 - 10":
                return 100;
            case "Easy : 0 - 1000 - 100":
                return 1000;
            case "Moderate : 0 - 10 000 - 1 000":
                return 10000;
            case "Hard : 0 - 100 000 - 10 000":
                return 100000;
        }
        return -1;
    }

    /**
     * Method for generate a ArrayList with a limit of lenght
     *
     * @param limit the limit of the array
     * @return the ArrayList with all element
     */
    private ArrayList<int[]> generateArrays(int limit) {
        ArrayList<int[]> arrays = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            int[] arr = IntStream.generate(()
                    -> new Random().nextInt(100)).limit(i * (limit / 10)).toArray();
            arrays.add(arr);
        }
        return arrays;
    }

    /**
     * Method for start the sort
     */
    public void StartRace() {
        for (int i = 0; i < this.nbThread; i++) {
            switch (typeTri) {
                case "Tri Fusion":
                    MergeSort mergeSort = new MergeSort();
                    SortingRun fusionRun = new SortingRun(array, mergeSort, "MERGE");

                    fusionRun.addObserver(this);

                    Thread fusionThread = new Thread(fusionRun);
                    fusionThread.start();
                    break;
                case "Tri Bulle":
                    BubbleSort tirBule = new BubbleSort();
                    SortingRun buleRun = new SortingRun(array, tirBule,"BUBBLE");
                    buleRun.addObserver(this);
                    Thread buleThread = new Thread(buleRun);
                    buleThread.start();
                    break;
                default:
                    throw new IllegalArgumentException("Configuration de tri non trouvé");
            }
        }
    }

    @Override
    public void update(Observable observable, Object arg) {
        TableViewApp tableView = (TableViewApp) arg;
        //setChanged();
        notifyObservers(tableView);
    }
}
