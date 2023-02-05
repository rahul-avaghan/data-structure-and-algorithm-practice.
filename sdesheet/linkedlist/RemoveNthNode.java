public class RemoveNthNode {

    public static void main(String[] args) {

        int input[] = { 1, 4, 7, 8, 10 };

        Node head = LinkedUtilList.toList(input);
        LinkedUtilList.printList(head);
        Node modified = removeNthNode(head, 2);
        System.out.println();
        LinkedUtilList.printList(modified);

    }

    /****
     * 
     * 2 -> 3 -> 4-> 5 -> 6
     * 
     * Remove 2 nd node from the last
     * 
     * 
     * location of the node = total - n
     */

    public static Node removeNthNode(Node head, int k) {

        Node start = new Node();
        start.next = head;

        Node slow = start;
        Node fast = start;

        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }
}
