package LeetCode_Porblems.Linked_List;

public class ListNode {

    int data;
    ListNode next;

    public ListNode(int value) {
        this.data = value;
        next = null;
    }


    public void printList(ListNode root) {

        while(root!= null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
    }

}