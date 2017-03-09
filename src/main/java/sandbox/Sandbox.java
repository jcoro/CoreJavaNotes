package sandbox;

import java.util.ArrayList;

/**
 * A Sandbox to test some details and idiocyncracies of Java.
 */

public class Sandbox {

    public static void main(String[] args){

        // In the following code segment, how many times will an even number be sent to standard out?
        // Answer: 1
        // note that continue causes control to immediately jump to the update statement x++
        // odd numbers increment after the else block.
        for (int x = 0; x < 10 ; x++){
            if (x % 2 == 0) {
                System.out.println("x: " + x + " - Even");
                continue;
            }
            else {
                System.out.println("x: " + x + " - Odd");
            }
            x++;
        }

        // These compile - note ways of declaring Array
        Object [ ] obj1 = new Object [7];
        Object obj2 [ ] = new Object [7];
        Object obj3 [ ] = {new Object(), new Object()};
        Object obj4 [ ] = {new Object [1], new Object [2]};

        // These don't compile
        // Object [ ] obj = new Object (); Incompatible Types
        // Object obj [ ] = new Object() ;
        // Object [ ] obj = new Object [ ]; Array initializer (size) expected
        // Object obj [ ] = new Object[ ];
        // Object [ ] obj = new Object [3](); Expression expected () not correct syntax
        // Object [8] obj = new Object [ ]; Size is not assigned when declared
        // Object [7] obj = new Object [7]; Size is not assigned when declared
        // Object [3] obj = new Object [3]() ; Size is not assigned when declared & () not correct
        // Object obj [] = new {new Object(), new Object()}; first new not needed

        ArrayList<Integer> sampleArrayList = new ArrayList<>();
        int i = 63;
        sampleArrayList.add(i);
    }
}
