
package atl.sorting.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g53203
 */
public class FusionSortTest {
    
 

     /**
     * Test of sort method, of class MergeSort.
     */
    @Test
    public void testSortFusionArray() {
        int[] expected = {1,2,3,4,5,6,7,8,9,10};
        int[] sorted = {2,10,6,8,7,4,3,9,1,5};
        MergeSort instance = new MergeSort();
        instance.sort(sorted, sorted.length);
        assertArrayEquals(expected, sorted);
    }
    
    /**
     * Test of sort method, of class MergeSort.
     */
    @Test
    public void testSortFusionArrayWithSorted() {
        int[] expected = {1,2,3,4,5,6,7,8,9,10};
        int[] sorted = {1,2,3,4,5,6,7,8,9,10};
        MergeSort instance = new MergeSort();
        instance.sort(sorted, sorted.length);
        assertArrayEquals(expected, sorted);
    }
    
}
