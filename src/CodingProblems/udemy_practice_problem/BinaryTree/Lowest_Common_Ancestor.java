package CodingProblems.udemy_practice_problem.BinaryTree;

import java.util.HashMap;
import java.util.Stack;

public class Lowest_Common_Ancestor {

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
        int[] childrenE = {3, 8};
        int[] childrenF = {9, 2};
        int[] childrenG = {6, 7};
        mapping2.put(5, childrenD);
        mapping2.put(1, childrenE);
        mapping2.put(4, childrenF);
        mapping2.put(3, childrenG);

        TreeNode head2 = createTree(mapping2, 5);
        // This tree is:
        //  head2 = 5
        //        /   \
        //       1     4
        //      /\    / \
        //     3  8  9  2
        //    /\
        //   6  7


        System.out.println("result - " + lca(head2, 1, 5)); //should return 0
        // lca(head1, 3, 1) should return 1
        // lca(head1, 1, 4) should return 1
        // lca(head1, 0, 5) should return 0
        // lca(head2, 4, 7) should return 5
        // lca(head2, 3, 3) should return 3
        // lca(head2, 8, 7) should return 1
        // lca(head2, 3, 0) should return null (0 does not exist in the tree)
    }

    static TreeNode lca(TreeNode root, int x, int y) {

        Stack<TreeNode> leftStack = pathToX(root, x);
        printStack(leftStack);
        Stack<TreeNode> rightStack = pathToX(root, y);
        printStack(rightStack);
        if(leftStack == null || rightStack == null) return null;

        TreeNode nodeToReturn = null;

        while(!leftStack.isEmpty() && !rightStack.isEmpty()) {

            TreeNode leftNode = leftStack.pop();
            TreeNode rightNode = rightStack.pop();

            if(leftNode.value == rightNode.value) {
                nodeToReturn = leftNode;
            } else break;

        }
        return nodeToReturn;
    }

    static Stack<TreeNode> pathToX(TreeNode node, int x) {
        
        if(node == null) return null;
        
        if(node.value == x) {
            Stack<TreeNode> path = new Stack<>();
            path.push(node);
            return path;
        }

        Stack<TreeNode> leftPath = pathToX(node.left, x);
        if(leftPath != null) {
           leftPath.push(node);
            return leftPath;
        }


        Stack<TreeNode> rightPath = pathToX(node.right, x);
        if(rightPath != null) {
            rightPath.push(node);
            return rightPath;
        }
        
        return null;
    }

    static void printStack(Stack<TreeNode> stack) {

        while(!stack.isEmpty()) {
            TreeNode val = stack.pop();
            System.out.println(val);
        }
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



