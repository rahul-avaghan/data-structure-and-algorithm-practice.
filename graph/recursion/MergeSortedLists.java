public class MergeSortedLists {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 4, 5, 7 };
        int[] arr2 = { 6, 9, 10, 11, 12, 13, 14 };
        Node first = Node.buildList(arr1);
        Node second = Node.buildList(arr2);
        Node merged = merge(first, second);
        Node.printList(merged);
    }

    private static Node merge(Node first, Node second) {

        if (first == null)
            return second;
        if (second == null)
            return first;

        if (first.value < second.value) {
            first.next = merge(first.next, second);
            return first;
        } else {
            second.next = merge(first, second.next);
            return second;
        }

    }

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

            while (head != null) {
                System.out.println(head.value);
                head = head.next;
            };
        }

        public static Node buildList(int[] array) {

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
    }
}
