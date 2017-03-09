package sandbox;


/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */



public class AddTwoNumbersAlt {

    public static void main (String args[]) {
     addTwoNumbers(new ListNode(2), new ListNode(5));
    }


    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode answer = new ListNode(0);
        ListNode pointer1 = l1, pointer2 = l2, currentNum = answer;
        int carryover = 0;
        int x;
        int y;
        while (pointer1 != null || pointer2 != null) {
            x = (pointer1 != null) ? pointer1.val : 0;
            y = (pointer2 != null) ? pointer2.val : 0;
            int sum = carryover + x + y;
            carryover = sum / 10;
            currentNum.next = new ListNode(sum % 10);
            currentNum = currentNum.next;
            if (pointer1 != null) pointer1 = pointer1.next;
            if (pointer2 != null) pointer2 = pointer2.next;
        }
        if (carryover > 0) {
            currentNum.next = new ListNode(carryover);
        }
        System.out.println(Integer.toString(answer.next.val));
        return answer.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
