package udemy_practice_problem.BinaryTree;

public class Node {

    int value;
    Node child;


    public Node(int value, Node child) {
        this.value = value;
        this.child = child;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}