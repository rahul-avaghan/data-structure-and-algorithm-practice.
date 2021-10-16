public class AllTree {

    public static void main(String[] args) {

        int[] input = { 1, 2, 3, 4, 5, 6, 7 };
        var tree = new Tree(input);
        //System.out.println("Right view ---------");

        // tree.printRightView();
        // System.out.println();
        // System.out.println("Left view ---------");
        // tree.printLeftView();
        // System.out.println();

        // System.out.println("Bottom view ---------");
         tree.printBottomView();
        
         //tree.inOrderIteration();
        // tree.preOrderIteration();
        // var mirrored = tree.mirror();
        // System.out.println();

        // mirrored.preOrderIteration();
        // System.out.println();

        // tree.reverseLevelOrderTraversal();
        // System.out.println();
        // tree.height();
        // System.out.println();

        // System.out.println();
        // tree.inOrderTraversal(tree.getRoot());
        // System.out.println();
        // tree.postOrderTraversal(tree.getRoot());

    }

    /***
     * 
     *      1
     *    2    3 
     * 4 5    6 7
     * 
     * 
     * 
     * 
     */

}
