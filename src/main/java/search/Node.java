package search;

public class Node {
    private final int value;
    Node parent;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
