public class FindMiddleElement {

    public Node findMiddleElement(Node head) {

        Node slow = head, fast = head;
        // [2,3,4,5,6,9]
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}