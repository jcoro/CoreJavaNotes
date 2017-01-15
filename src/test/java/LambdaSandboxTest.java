import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import sandbox.LambdaSandbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class tests the LambdaSandbox.
 */

@RunWith(Enclosed.class)
public class LambdaSandboxTest {


    public static class BiFunctionTest {
        @Test
        public void testBiFunctionStringLength(){
            assertEquals(-1, LambdaSandbox.biFunctionStringLength("the first", "the second"));
        }

        @Test
        public void testBiFunctionCalculatorReturns15() {
            assertEquals(15, LambdaSandbox.biFunctionCalculator((a, b) -> (a * b), 3,  5));
        }

        @Test
        public void testCheckEqualityFromPredicate(){
            assertTrue(LambdaSandbox.checkEqualityFromPredicate((s) ->
                    s.equals(LambdaSandbox.PRED_TEST_STRING), "predicate test string"));
        }
    }




}
