package sandbox;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring
 * Given a string, find the length of the longest substring without repeating characters.
 */

public class LongestSubstring {

    public static void main(String args[]){
        int num = lengthOfLongestSubstring("pqxwwkew");
        System.out.println("Length: " + num);
    }
    private static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                System.out.println("SET: " + set.toString());
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
                System.out.println("SET: " + set.toString());
            }
        }

        return max;
    }
}
