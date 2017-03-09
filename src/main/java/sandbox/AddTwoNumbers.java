package sandbox;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */



public class AddTwoNumbers {

    public static LinkedList<Integer> createLinkedList(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int n : nums) {
            list.add(n);
        }
        return list;
    }


    public static List<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        List<Integer> answer = new LinkedList<>();
        Integer num1;
        Integer num2;
        Integer sum;
        Iterator iter1 = l1.iterator();
        Iterator iter2 = l2.iterator();
        int carryover = 0;
        while (iter1.hasNext() || iter2.hasNext()){
            num1 = ( iter1.hasNext() ) ? (Integer)iter1.next() : 0;
            num2 = ( iter2.hasNext() ) ? (Integer)iter2.next() : 0;
            sum = num1 + num2;
            // sum is greater than ten
            if(sum / 10 > 0 ){
                answer.add((sum % 10) + carryover);
                carryover = 1;
            // sum is less than 10
            } else {
                answer.add(sum + carryover);
                carryover = 0;
            }

        }
        return answer;
    }


    public static void main (String args[]) {
        LinkedList<Integer> list1 = createLinkedList(new int[]{2, 4, 3, 8});
        LinkedList<Integer> list2 = createLinkedList(new int[]{5, 6, 4, 7, 3, 9});

    }
}
