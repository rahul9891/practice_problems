package Hacker_Rank.LinkedList_Problems;

public class LinkedList_Problems {
	
	public static void main(String[] args) {
		
	}
	
	
	public static SingleLinkedList mergeLists(SingleLinkedList head1, SingleLinkedList head2) {
		
		if(head1 == null) return head2;
		
		if(head2 == null) return head1;
		
		if(head1.data <= head2.data) {
			SingleLinkedList sortedHead = mergeLists(head1.next, head2);
			head1.next =  sortedHead;
			return head1;
		} else {
			SingleLinkedList sortedHead = mergeLists(head1, head2.next);
			head2.next = sortedHead;
			return head2;
		}
	}

}
