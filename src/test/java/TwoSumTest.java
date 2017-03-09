import org.junit.Test;

import sandbox.TwoSum;

import static org.junit.Assert.*;

/**
 * This class tests TwoSum
 */

public class TwoSumTest {

    @Test
    public void testTwoSum1(){
        assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {2, 7, 11, 15}, 9));
    }

    @Test
    public void testTwoSum2(){
        assertArrayEquals(new int[] {2, 3}, TwoSum.twoSum(new int[] {11, 15, 2, 7}, 9));
    }


}
