package udemy_practice_problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        // The mapping we're going to use for constructing a tree.
        // For example, {0: [1, 2]} means that 0's left child is 1, and its right
        // child is 2.
        HashMap<Integer, int[]> mapping1 = new HashMap<Integer, int[]>();
        int[] childrenA = {1, 2};
        int[] childrenB = {3, 4};
        int[] childrenC = {5, 6};
        mapping1.put(0, childrenA);
        mapping1.put(1, childrenB);
        mapping1.put(2, childrenC);

        TreeNode head1 = createTree(mapping1, 0);
        // This tree is:
        // head1 = 0
        //        / \
        //       1   2
        //      /\   /\
        //     3  4 5  6


        HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
        int[] childrenD = {1, 4};
        int[] childrenE = {0, 2};
        int[] childrenF = {5, 6};
        mapping2.put(3, childrenD);
        mapping2.put(1, childrenE);
        mapping2.put(4, childrenF);

        TreeNode head2 = createTree(mapping2, 3);
        // This tree is:
        //  head2 = 3
        //        /   \
        //       1     4
        //      /\    / \
        //     0  2  5   6


        HashMap<Integer, int[]> mapping3 = new HashMap<Integer, int[]>();
        int[] childrenG = {1, 5};
        int[] childrenH = {0, 2};
        int[] childrenI = {4, 6};
        mapping3.put(3, childrenG);
        mapping3.put(1, childrenH);
        mapping3.put(5, childrenI);

        TreeNode head3 = createTree(mapping3, 3);
        // This tree is:
        //  head3 = 3
        //        /   \
        //       1     5
        //      /\    / \
        //     0  2  4   6



        HashMap<Integer, int[]> mapping4 = new HashMap<Integer, int[]>();
        int[] childrenJ = {1, 5};
        int[] childrenK = {0, 4};
        mapping4.put(3, childrenJ);
        mapping4.put(1, childrenK);

        TreeNode head4 = createTree(mapping4, 3);
        // This tree is:
        //  head4 = 3
        //        /   \
        //       1     5
        //      /\
        //     0  4


       Boolean result =  is_binary_search_tree(head4); //should return false
       System.out.println(result);
        // isBST(head2) should return false
        // isBST(head3) should return true
        // isBST(head4) should return false
    }


    static Boolean is_binary_search_tree(TreeNode head) {

        Queue<TreeNode> queue = new LinkedList<>();

        if(head == null) return false;

        queue.add(head);

        while(!queue.isEmpty()) {

            TreeNode current = queue.remove();

            if(current.left != null) {
                if(current.left.value < current.value) {
                    queue.add(current.left);
                }else return false;                
            }
            if(current.right != null) {
                if(current.right.value > current.value) {
                    queue.add(current.right);
                } else return false;
            }

        }
        return true;
    }


    public static TreeNode createTree(HashMap<Integer, int[]> mapping, int headValue) {
        TreeNode head = new TreeNode(headValue, null, null);
        HashMap<Integer, TreeNode> nodes = new HashMap<Integer, TreeNode>();
        nodes.put(headValue, head);
        for(Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            TreeNode leftChild = new TreeNode(value[0], null, null);
            TreeNode rightChild = new TreeNode(value[1], null, null);
            nodes.put(value[0], leftChild);
            nodes.put(value[1], rightChild);
        }
        for(Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            nodes.get(key).left = nodes.get(value[0]);
            nodes.get(key).right = nodes.get(value[1]);
        }
        return head;
    }
    
}


class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
