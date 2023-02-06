public class AddTwoNumbers {

    public static void main(String[] args) {
        Node l1 = new Node();
        Node l2 = new Node();

        // 5432
        l1.val = 2;
        l1.insertNode(l1, 3);
        l1.insertNode(l1, 4);
        l1.insertNode(l1, 5);
        // 7543
        l2.val = 3;
        l2.insertNode(l2, 4);
        l2.insertNode(l2, 5);
        l2.insertNode(l2, 7);

        Node result = addTwoNumbers(l1, l2);
        // 12975
        LinkedUtilList.printList(ReverseLinkedList.reverseLinkedList(result));

    }

    private static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node();
        Node temp = dummy; 

        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }  

        return dummy.next;

    }
}
