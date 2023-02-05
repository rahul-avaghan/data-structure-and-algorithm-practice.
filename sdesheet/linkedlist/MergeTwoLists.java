public class MergeTwoLists {

    public static void main(String[] args) {
        Node l1 = new Node();
        Node l2 = new Node();
        l1.val = 2;
        l1.insertNode(l1, 3);
        l1.insertNode(l1, 4);
        l1.insertNode(l1, 5);

        l2.val = 3;
        l2.insertNode(l2, 4);
        l2.insertNode(l2, 5);
        l2.insertNode(l2, 7);

        Node mergedNode = mergeTwoLists(l1, l2);

        LinkedUtilList.printList(mergedNode)
;
    }
    // 2 -> 3 -> 4 -> 5

    // 3 -> 4 -> 5 -> 7
    private static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    /***
     * 2 -> 3 -> 4 -> 5 ------ 3 -> 4 -> 5 -> 7 = a
     * 3 -> 4 -> 5 --- 3 -> 4 -> 5 -> 7 b
     * 3 -> 4 -> 5 --- 4 -> 5 -> 7 a
     * 4 -> 5 --- 4 -> 5 -> 7 b
     * 4 -> 5 --- 5 -> 7 b 4 -> 5 -> 7 -> 5-> 7 -> 5 -> 7 -> 5 -> 7
     * 5 --- 5 -> 7 => b 5-> 7 -> 5 -> 7
     * 5 --- 7 => a 5 -> 7
     * null --- 7 => 7
     */
}
