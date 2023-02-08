public class RoatateLinkedList {

    public static void main(String[] args) {
        Node head = LinkedUtilList.toList(new int[] { 1, 2, 3, 4, 5 });
        LinkedUtilList.printList(head);
        head = rotateLinkedListOptimised(head, 2);
        LinkedUtilList.printList(head);
        head = rotateLinkedList(head, 2);
        LinkedUtilList.printList(head);

    }

    private static Node rotateLinkedList(Node head, int k) {

        if (head == null || head.next == null)
            return head;

        for (int i = 0; i < k; i++) {
            Node temp = head;
            while (temp.next.next != null)
                temp = temp.next;

            Node end = temp.next;

            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;

    }

    private static Node rotateLinkedListOptimised(Node head, int k) {
        if (head == null || head.next == null)
            return head;

        int length = 0;
        Node current = head;

        while (current.next != null) {
            length++;
            current = current.next;
        }

        current.next = head;

        int end = k > length ? length - k % length : length - k;

        current = head;

        while (end != 0) {
            current = current.next;
            end--;
        }
        head = current.next;
        current.next = null;
        return head;

    }

}