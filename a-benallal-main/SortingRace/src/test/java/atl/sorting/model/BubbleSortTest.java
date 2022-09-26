
package atl.sorting.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g53203
 */
public class BubbleSortTest {
    
 

    /**
     * Test of sort method, of class BubbleSort.
     */
    @Test
    public void testBubbleSortArrayNoSorted() {
        System.out.println("BubbleSortArrayNoSorted");
        int[] expected = {1,2,3,4,5,6,7,8,9,10};
        int[] sorted = {2,10,6,8,7,4,3,9,1,5};
        BubbleSort instance = new BubbleSort();
        instance.sort(sorted, sorted.length);
        assertArrayEquals(expected, sorted);
    }
    /**
     * Test of sort method, of class BubbleSort.
     */
    @Test
    public void testBubbleSortArraySorted() {
        System.out.println("BubbleSortArraySorted");
        int[] expected = {1,2,3,4,5,6,7,8,9,10};
        int[] sorted = {1,2,3,4,5,6,7,8,9,10};
        BubbleSort instance = new BubbleSort();
        instance.sort(sorted, sorted.length);
        assertArrayEquals(expected, sorted);
    }
    
}
