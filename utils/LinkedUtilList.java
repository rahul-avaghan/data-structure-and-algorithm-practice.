public class LinkedUtilList {

    public Node reverseLinkedList(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static Node toList(int[] array) {
        Node head = new Node();

        head.val = array[0];

        for (int i = 1; i < array.length; i++) {
            head.insertNode(head, array[i]);
        }

        return head;
    }

    public static void printList(Node l1) {

        var current = l1;
        while (current != null) {
            System.out.print(current.val + "--> ");
            current = current.next;
        }
        System.out.println();
    }

    public static class NodePair {
        Node t1;
        Node t2;
        Node prevt1;
        Node prevt2;

        public NodePair(Node t1, Node t2, Node prevt1, Node prevt2) {
            this.prevt1 = prevt1;
            this.prevt2 = prevt2;
            this.t2 = t2;
            this.t1 = t1;
        }
    }

    // 1,2,3,4 fast.next.next != null
    // 1,2,3 fast.next != null
    public static Node MiddleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverse(Node head) {
        Node current = head;
        Node prev =  null;
        while(current != null) {

            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static NodePair searchNodePair(Node t1, Node t2, Node head) {

        var current = head;
        Node prevt1 = null, prevt2 = null;

        while (current != null && current.next != t1) {
            current = current.next;
        }
        prevt1 = current;

        current = head;
        while (current != null && current.next != t2) {
            current = current.next;
        }

        return new NodePair(t1, t2, prevt1, prevt2);
    }

    static void createCycle(Node head,int pos) {
        Node ptr = head;
        Node temp = head;
        int cnt = 0;
        while(temp.next != null) {
            if(cnt != pos) {
                ++cnt;
                ptr = ptr.next;
            } 
            temp = temp.next;
        }
        temp.next = ptr;
    }

    public static void swap(Node t1, Node t2, Node prevt1, Node prevt2, Node head) {

        if (t1 == t2) {
            return;
        }

        // 1 --> 2 --> 3 --> 4 --> 5
        if (prevt1 != null) {
            prevt1.next = t2;
        } else {
            head = t2;
        }

        if (prevt2 != null) {
            prevt2.next = t1;
        } else {
            head = t1;
        }

        Node temp = t1.next;
        t1.next = t2.next;
        t2.next = temp.next;
    }

}
