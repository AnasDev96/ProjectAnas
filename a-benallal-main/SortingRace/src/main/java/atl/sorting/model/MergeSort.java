package atl.sorting.model;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class MergeSort implements Sorting {

    /**
     * Method for merge the array 
     * @param a
     * @param l
     * @param r
     * @param left
     * @param right
     * @return the number of operation
     */
    public static long merge(int[] a, int[] l, int[] r, int left, int right) {
        long cpt = 0;
        int i = 0, j = 0, k = 0;
        cpt++;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
                cpt++;
            } else {
                a[k++] = r[j++];
                cpt++;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
            cpt++;
        }
        while (j < right) {
            a[k++] = r[j++];
            cpt++;
        }
        return cpt;
    }


    @Override
    public long sort(int[] a, int n) {
        int cpt = 0;
        cpt++;
        if (n < 2) {
            return 0;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        cpt += 3;

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
            cpt++;
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
            cpt++;
        }
        cpt += sort(l, mid);
        cpt += sort(r, n - mid);

        cpt += merge(a, l, r, mid, n - mid);
        return cpt;
    }
}
