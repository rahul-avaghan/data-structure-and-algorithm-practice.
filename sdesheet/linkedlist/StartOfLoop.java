public class StartOfLoop {

    public static void main(String[] args) {

        Node head = LinkedUtilList.toList(new int[] { 1, 2, 3, 4, 5, 6 });

        LinkedUtilList.createCycle(head, 1);

        System.out.println(getEntryPointForTheLoop(head).val);    ;

    }

    public static Node getEntryPointForTheLoop(Node head) {

        Node slow = head;
        Node fast = head;

        do {

            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
