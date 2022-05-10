package data_structure_implementations;

class Node {

    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {
    Node root;
    public MyLinkedList() {
        root=null;
    }

    public int get(int index) {
        int i=0;
        if(root == null) return -1;
        Node curr = root;
        while(curr != null) {
            if(index == i) {
                return curr.val;
            }
            i++;
            curr = curr.next;
        }
        return -1;
    }

    public void addAtHead(int val) {

        if(root == null) {
            root = new Node(val);
        } else {
            Node n = new Node(val);
            n.next = root;
            root = n;
        }
    }

    public void addAtTail(int val) {

        if(root == null) {
            root = new Node(val);
            return;
        }
        Node curr = root;
        Node prev = null;
        while(curr != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = new Node(val);

    }

    public void addAtIndex(int index, int val) {

        if(index == 0) {
            addAtHead(val);
            return;
        }
        Node curr = root;
        int i=0;
        Node prev = null;
        while(curr != null) {
            if(index == i) {
                Node n = new Node(val);
                n.next = curr;
                prev.next = n;
                return;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }

    }

    public void deleteAtIndex(int index) {
        if(root != null) {
            int i=0;
            Node curr = root;
            Node prev = null;
            while(curr != null) {
                if(index == i) {
                    prev.next = curr.next;
                    return;

                }
                prev = curr;
                curr = curr.next;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.addAtHead(23);
        l.addAtTail(34);


        System.out.println(l.get(1));
    }
}
