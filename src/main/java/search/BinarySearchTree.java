package search;

import java.util.Optional;

public class BinarySearchTree extends BinaryTree {

    @Override
    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) root = node;
        findPlace(root, node);
    }

    private void findPlace(Node tree, Node node) {
        if (tree == node) return;

        Node dest = (node.value < tree.value) ? tree.left : tree.right;
        if (isTaken(dest)) findPlace(dest, node);
        else setChild(tree, node);
    }

    private void setChild(Node parent, Node child) {
        if (child.value < parent.value) parent.left = child;
        else parent.right = child;
    }

    private boolean isTaken(Node node) {
        return node != null;
    }

    @Override
    public Optional<Node> search(int value) {
        if (root == null) return Optional.empty();
        return searchNode(root, value);
    }

    private Optional<Node> searchNode(Node root, int value) {
        if (root == null) return Optional.empty();
        if (value == root.value) return Optional.of(root);

        Optional<Node> node;
        if (value < root.value) node = searchNode(root.left, value);
        else node = searchNode(root.right, value);

        return node;
    }

    @Override
    public Optional<Node> delete(int value) {
        return Optional.empty();
    }
}
