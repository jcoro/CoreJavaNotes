package sandbox;

/**
 * A Class to run calculations
 */

public class SimpleCalc {
    public static void main (String args[]) {
        int num = (1 / 10); // Returns 0
        num = (1 % 10);     // Returns 1
        System.out.println(Integer.toString(num));

        int i = 0;
        String str ="abcdefghij";
        System.out.println(str.charAt(i++)); // Returns a
        i = 0;
        System.out.println(str.charAt(++i)); // Returns b

    }
}
