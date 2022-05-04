package CodingProblems.udemy_practice_problem.BinaryTree;

import java.util.ArrayList;

public class LinkedList_Nth_Element {

    public static void main(String[] args) {
        
    }

    static Node nthFromLast(Node head, int n) {

        if(head == null) return null;
        ArrayList<Node> list = new ArrayList<>();
        Node current = head;
        while(current != null) {
            list.add(current);
            current = current.child;
        }
        return list.get(list.size() - n);
    }
    
}



