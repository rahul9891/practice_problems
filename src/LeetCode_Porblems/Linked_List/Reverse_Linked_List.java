package LeetCode_Porblems.Linked_List;

import java.util.Stack;

public class Reverse_Linked_List {

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);

//        Node result = reverseList(n);
        ListNode result = reverseList_withPosition(n, 2, 4);
        n.printList(result);
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
/**
 *
 * input -> 1 -> 2-> 3-> 4-> 5-> null    left = 2, right = 4
 *
 * output -> 1-> 4-> 3-> 2-> 5-> null
 *
 * */
    static ListNode reverseList_withPosition(ListNode head, int left, int right) {
        int currPos = 1;
        if(left == right)  return head;
        ListNode start = null;
        ListNode curr = head;

        while(currPos < left) {
            start = curr;
            curr = curr.next;
            currPos++;
        }

        ListNode tail = start;
        ListNode newHead = curr;

        while(currPos >= left && currPos <= right) {
            ListNode temp = curr.next;
            curr.next = start;
            start = curr;
            curr = temp;
            currPos++;

        }

        if(tail == null) {
            head = start;
        } else {
            tail.next = start;
        }
        newHead.next = curr;

        return head;
    }

}
