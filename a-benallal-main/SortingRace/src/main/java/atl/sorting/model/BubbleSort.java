package atl.sorting.model;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class BubbleSort implements Sorting {

    @Override
    public long sort(int[] tab, int length) {
        long cpt = 0;
        int tmp = 0;
        cpt++;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                cpt++;
                if (tab[j - 1] > tab[j]) {
                    tmp = tab[j - 1];
                    tab[j - 1] = tab[j];
                    tab[j] = tmp;
                    cpt += 3;
                }

            }
        }
        return cpt;
    }

}
