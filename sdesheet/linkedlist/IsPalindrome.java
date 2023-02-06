public class IsPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(LinkedUtilList.toList(new int[] { 1, 2, 3, 2, 1 })));

        System.out.println(isPalindrome(LinkedUtilList.toList(new int[] { 1, 2, 3, 3, 2, 1 })));

        System.out.println(isPalindrome(LinkedUtilList.toList(new int[] { 1, 2, 3, 4, 5, 6 })));


    }

    // 1 ,2, 3, 2, 1
    // 1,2,3,1,2,3
    // 1,2, 1,2
    public static boolean isPalindrome(Node head) {

        Node middleNode = LinkedUtilList.MiddleNode(head);
        Node lastNode = LinkedUtilList.reverse(middleNode.next);

        middleNode.next = lastNode;
        middleNode = middleNode.next;

        Node slow = middleNode;
        Node dummy = head;
        while (slow != null) {

            if (dummy.val != slow.val) {
                return false;
            }
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }
}
