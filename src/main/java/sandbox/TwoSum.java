package sandbox;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 * EXAMPLE
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */



public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for( int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++){
                if( i != j && nums[i] + nums[j] == target ) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }


}
