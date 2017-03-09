import org.junit.Test;

import sandbox.AddTwoNumbers;

import static org.junit.Assert.assertEquals;

/**
 * This Class Tests AddTwo Numbers
 */

public class AddTwoNumbersTest {
    @Test
    public void testAddTwoNumbers(){
        assertEquals(
                AddTwoNumbers.createLinkedList(new int[]{7, 0, 8, 5, 4, 9}),
                AddTwoNumbers.addTwoNumbers(
                        AddTwoNumbers.createLinkedList(new int[]{2, 4, 3, 8}),
                        AddTwoNumbers.createLinkedList(new int[]{5, 6, 4, 7, 3, 9})
                )
        );
    }
}

