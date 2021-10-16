import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree(int[] input) {
        this.root = this.fill(new Node(input[0]), 0, input);
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return this.root;
    }

    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ,");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        System.out.print(root.getData() + " ,");
        inOrderTraversal(root.getRight());
    }

    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.print(root.getData() + " ,");
    }

    public void levelOrderTraversal() {
        if (this.root == null) {
            return;
        }

        var queue = new LinkedList<Node>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node visitedNode = queue.poll();
            System.out.print(visitedNode.getData() + " ,");
            if (visitedNode.getLeft() != null) {
                queue.add(visitedNode.getLeft());
            }
            if (visitedNode.getRight() != null) {
                queue.add(visitedNode.getRight());
            }

        }

    }

    public void inOrderIteration() {
        if (this.root == null) {
            return;
        }

        var current = this.root;
        var stack = new Stack<Node>();

        while (!stack.isEmpty() || current != null) {

            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                System.out.print(current.getData() + " ,");
                current = current.getRight();
            }

        }
    }

    public void preOrderIteration() {
        if (this.root == null) {
            return;
        }

        var current = this.root;
        var stack = new Stack<Node>();

        while (!stack.isEmpty() || current != null) {

            if (current != null) {
                stack.push(current);
                System.out.print(stack.peek().getData() + " ,");
                current = current.getLeft();
            } else {
                current = stack.pop();
                current = current.getRight();
            }

        }
    }

    public void postOrderIteration() {
        if (this.root == null) {
            return;
        }

        var current = this.root;
        var stack = new Stack<Node>();

        while (!stack.isEmpty() || current != null) {

            if (current != null) {
                stack.push(current);

                current = current.getLeft();

            } else {
                current = stack.pop();
                System.out.print(current.getData() + " ,");
            }

        }
    }

    public void reverseLevelOrderTraversal() {
        if (this.root == null) {
            return;
        }

        var queue = new LinkedList<Node>();
        var stack = new ArrayDeque<Integer>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node visitedNode = queue.poll();
            stack.push(visitedNode.getData());
            if (visitedNode.getLeft() != null) {
                queue.add(visitedNode.getLeft());
            }
            if (visitedNode.getRight() != null) {
                queue.add(visitedNode.getRight());
            }

        }

        while (!stack.isEmpty()) {
            System.out.print(stack.poll() + " ,");
        }

    }

    public int height() {
        var height = this.heightCounter(this.root);
        System.out.println(height);
        return height;
    }

    public Tree mirror() {
        var root = this.root;

        if (root == null) {
            return null;
        }
        return new Tree(traverse(this.root, null));
    }

    private int heightCounter(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(this.heightCounter(root.getLeft()), this.heightCounter(root.getRight()));
    }

    public void printRightView() {
        maxLevel = 0;
        traverseRightView(this.root, 1);

    }

    public void printLeftView() {
        maxLevel = 0;
        traverseLeftView(this.root, 1);

    }

    static int maxLevel = 0;

    public static void traverseLeftView(Node root, int level) {

        if (root == null)
            return;

        if (level > maxLevel) {
            System.out.print(root.getData() + " ,");
            maxLevel = level;
        }
        traverseLeftView(root.getLeft(), level + 1);
        traverseLeftView(root.getRight(), level + 1);
    }

    public void traverseRightView(Node root, int level) {

        if (root == null)
            return;

        if (level > maxLevel) {
            System.out.print(root.getData() + " ,");
            maxLevel = level;
        }
        traverseRightView(root.getRight(), level + 1);
        traverseRightView(root.getLeft(), level + 1);
    }

    public void printBottomView() {
        if (this.root == null)
            return;

        var stack = new LinkedList<Node>();
        Node current = this.root;
        while (!stack.isEmpty() || current != null) {

            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                if(current.getLeft() == null && current.getRight() == null){
                    System.out.print(current.getData() + " ,");
                }
                current = current.getRight();
            }
        }
    }

    private Node traverse(Node root, Node target) {
        if (root == null)
            return null;
        target = new Node(root.getData());
        target.setLeft(root.getRight());
        target.setRight(root.getLeft());

        traverse(root.getLeft(), target.getRight());
        traverse(root.getRight(), target.getLeft());
        return target;

    }

    private Node fill(Node root, int level, int[] input) {
        boolean inBound = level < input.length;
        int leftNodePosition = 2 * level + 1;
        int rightNodePosition = 2 * level + 2;

        if (inBound) {
            int presentNode = input[level];
            root = new Node(presentNode);
            root.setLeft(this.fill(root.getLeft(), leftNodePosition, input));
            root.setRight(this.fill(root.getRight(), rightNodePosition, input));
        }
        return root;
    }
}

/***
 * 
 * 1
 * 
 * 2 3 4 5
 * 
 * null null
 * 
 * 
 */
/**
 * length 5 1 -> 0 2 -> 1 null -> 5 null -> 6 3 --> 4 null -> 9 null -> 11 4 ->
 * 4 null -> junk null -> junk
 */