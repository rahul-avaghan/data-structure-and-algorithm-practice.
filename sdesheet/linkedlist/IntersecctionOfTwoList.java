import java.util.HashSet;

public class IntersecctionOfTwoList {

    static Node intersectionOfTwoList(Node l1, Node l2) {

        HashSet<Node> set = new HashSet<>();

        while (l1 != null) {

            set.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            if (set.contains(l2)) {
                return l2;
            }
            
            l2 = l2.next;
        }
        return null;
    }

}
