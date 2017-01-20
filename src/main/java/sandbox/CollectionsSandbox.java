package sandbox;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

/**
 * A class used to experiment with Collections
 *
 */

public class CollectionsSandbox {

    public static void main(String[] args){
        //studyLinkedList();
        studyLinkedList2();
        //studySets();
        //studySets2("some some strings to be used to test test the method");
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

    /*
    Instead of a loop, this method uses Iterator.forEachRemaining() method which takes a Lambda Expression
    that consumes an element Iterator.forEachRemaining(Consumer<? super E> action)
     */
    public static void studyLinkedList2(){
        List<String> team = new LinkedList<>();
                team.add("Larry Bird");
                team.add("Danny Ainge");
                team.add("Rober Parish");
                team.add("Dennis Johnson");
                team.add("Kevin McHale");
        Iterator<String> teamIterator = team.iterator();
        //teamIterator.forEachRemaining(e -> System.out.println(e)); is the same as the method ref:
        teamIterator.forEachRemaining(System.out::println);

    }
        /*
        HashSets implements Set interface, backed by a hash table (actually a HashMap instance).
        Lookup is faster than LinkedLists and Arrays
        Elements cannot be repeated.
        Elements can be stored in any order.
         */

        public static String studySets() {

            Set<String> words = new HashSet<>(); // HashSet implements Set
            long totalTime = 0;

            System.out.println("Enter Words and Press CMD + D when done");
            try (Scanner in = new Scanner(System.in))
            {
                while (in.hasNext()) {
                    String word = in.next();
                    System.out.println("word entered:" + word);
                    long callTime = System.currentTimeMillis();
                    words.add(word);
                    callTime = System.currentTimeMillis() - callTime;
                    totalTime += callTime;
                }
            }

            Iterator<String> iter = words.iterator();
            for (int i = 1; i <= 20 && iter.hasNext(); i++)
                System.out.println(iter.next());
            System.out.println(". . .");
            String returnValue = words.size() + " distinct words." + totalTime + " milliseconds ";
            System.out.println(returnValue);
            return returnValue;

        }
    /*
    This method prints each
     */
    public static int studySets2(String input) {

        Set<String> words = new HashSet<>(); // HashSet implements Set
        long totalTime = 0;

        String[] inputArray = input.split(" ");

        words.addAll(Arrays.asList(inputArray));

        Iterator<String> iter = words.iterator();
        for (String w : words)
            System.out.println(w);
        System.out.println(". . .");
        System.out.println(words.size() + " unique words");
        return words.size();

    }
}
