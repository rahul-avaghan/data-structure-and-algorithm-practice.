public class Node {
    Node next;
    int val;

    Node() {
    }

    Node(Node next, int val) {
        this.next = next;
        this.val = val;
    }

    Node(int val) {
        this.val = val;
    }

    public void insertNode(Node head, int val) {
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node();
        current.next.val = val;
    }

    public void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
