package sandbox;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * A class used to experiment with Collections
 *
 */

public class CollectionsSandbox {

    public static void main(String[] args){
        studyLinkedList();
    }

    /**
     * A LinkedList is an ordered collection - position of object matters
     * WHEN TO USE:
     * To minimize the cost of insertion and removal in the middle of the list.
     * Removing/inserting an element from the middle of a LinkedList is inexpensive
     * relative to Arrays and ArrayLists.
     * Iterators describe positions in collections.
     * Duplicates are allowed.
     * Because iterators are slow, don't use LinkedLists in situations where elements need to be
     * accessed by integer index.
     */

    public static List<String> studyLinkedList() {
        // Notice the variable is declared as the interface type. This is a good practice.
        // It adds flexibility because we can make the variable any type that implements List<E>.
        // e.g., a = new ArrayList<String>() works if a is declared as type List<String>.
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // ListIterator<String> is a sub interface of Iterator<E>, it contains add() method;
        // use if needed, otherwise use Iterator<E>
        ListIterator<String> alter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (alter.hasNext()) alter.next();
            alter.add(bIter.next());
            System.out.println(a);
        }
        return a;
            // [Amy, Bob, Carl, Erica]
            // [Amy, Bob, Carl, Doug, Erica]
            // [Amy, Bob, Carl, Doug, Erica, Frances]
            // [Amy, Bob, Carl, Doug, Erica, Frances, Gloria]

    }
}
