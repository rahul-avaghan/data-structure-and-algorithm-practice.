import java.util.HashSet;

public class DetectCycle {

    // two pointer approach
    static boolean isCycleTwoPointer(Node head) {

        // 2 -> 3 -> 4 -> 5 -> 6 -> 4
        Node slow = head;
        Node fast = head;

        while (slow != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    static boolean isCycleHashApproach(Node head) {
        HashSet<Node> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

}
