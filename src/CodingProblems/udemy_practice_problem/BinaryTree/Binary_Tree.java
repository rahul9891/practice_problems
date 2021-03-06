package CodingProblems.udemy_practice_problem.BinaryTree;

import java.util.HashMap;

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

        CodingProblems.udemy_practice_problem.BinaryTree.TreeNode head1 = createTree(mapping1, 0);
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

        CodingProblems.udemy_practice_problem.BinaryTree.TreeNode head2 = createTree(mapping2, 3);
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

        CodingProblems.udemy_practice_problem.BinaryTree.TreeNode head3 = createTree(mapping3, 3);
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

        CodingProblems.udemy_practice_problem.BinaryTree.TreeNode head4 = createTree(mapping4, 3);
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


    static Boolean is_binary_search_tree(CodingProblems.udemy_practice_problem.BinaryTree.TreeNode head) {

        return isBST(head, null, null);
    }

    static boolean isBST(CodingProblems.udemy_practice_problem.BinaryTree.TreeNode root, CodingProblems.udemy_practice_problem.BinaryTree.TreeNode left, CodingProblems.udemy_practice_problem.BinaryTree.TreeNode right) {

        if(root == null) return true;

        if(left != null && left.value >= root.value) return false;

        if(right != null && right.value <= root.value) return false;

        return isBST(root.left, left, root) && isBST(root.right, root, right);

    }


    public static CodingProblems.udemy_practice_problem.BinaryTree.TreeNode createTree(HashMap<Integer, int[]> mapping, int headValue) {
        CodingProblems.udemy_practice_problem.BinaryTree.TreeNode head = new CodingProblems.udemy_practice_problem.BinaryTree.TreeNode(headValue, null, null);
        HashMap<Integer, CodingProblems.udemy_practice_problem.BinaryTree.TreeNode> nodes = new HashMap<Integer, CodingProblems.udemy_practice_problem.BinaryTree.TreeNode>();
        nodes.put(headValue, head);
        for(Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            CodingProblems.udemy_practice_problem.BinaryTree.TreeNode leftChild = new CodingProblems.udemy_practice_problem.BinaryTree.TreeNode(value[0], null, null);
            CodingProblems.udemy_practice_problem.BinaryTree.TreeNode rightChild = new CodingProblems.udemy_practice_problem.BinaryTree.TreeNode(value[1], null, null);
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
