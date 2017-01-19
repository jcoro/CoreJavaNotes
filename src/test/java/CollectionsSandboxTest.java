import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import sandbox.CollectionsSandbox;

import static org.junit.Assert.assertEquals;

/**
 * This class tests CollectionsSandbox
 */

@RunWith(Enclosed.class)
public class CollectionsSandboxTest {

    public static class LinkedListTest {
        static List<String> mList;

        @Before
        public void initialize(){
            // to construct a LinkedList takes a Collection.
            // Note the use of the Arrays class - contains various methods for manipulating Arrays.
            mList = new LinkedList<String>(Arrays.asList("Amy", "Bob", "Carl", "Doug", "Erica", "Frances", "Gloria"));
        }

        @Test
        public void testStudyLinkedList(){
            assertEquals(mList, CollectionsSandbox.studyLinkedList());
        }

    }

}
