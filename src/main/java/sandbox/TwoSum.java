package sandbox;


import java.util.Arrays;

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

/**
 * The code below uses the java break statement to break out of the NESTED loop
 * This ensures that once a match is found the answer array is returned.
 */



public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        read_data:
        for( int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++){
                if( i != j && nums[i] + nums[j] == target ) {
                    ans[0] = i;
                    ans[1] = j;
                    System.out.println(Arrays.toString(ans));
                    break read_data;
                }
            }
        if (ans[0] + ans[1] == target) break;
        }
    return ans;
    }

    public static void main(String[] args){
        twoSum(new int[] {2, 7, 11, 15}, 9);
    }
}
