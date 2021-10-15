public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        Node head = buildList(arr);
        Node.printList(head);
        Node reversed = reverse(head);
        Node.printList(reversed);
    }

    private static Node buildList(int[] array) {

        Node node = new Node();
        Node head = node;

        for (int item : array) {
            node.setValue(item);
            node.setNext(new Node());
            node = node.next;
        }
        node.next = null;
        return head;
    }



    private static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node p = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return p;

    }

    // 4 -> 5 -> null
    // 5 -> 4--> null

    public static class Node {
        private int value;
        private Node next;

        public Node getNext() {
            return this.next;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        public static void printList(Node head) {

            do {
                System.out.println(head.value);
                head = head.next;
            } while (head != null);
        }
    }
}
