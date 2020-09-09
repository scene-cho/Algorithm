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
        child.parent = parent;
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
        // TODO real
        Node node = search(value).orElse(null);
        if (node == null) return Optional.empty();

        Node successor = successor(node).orElse(null);
        if (successor == null) {
            if (node.left == null) {
                node.parent.right = null;
            } else {
                node.parent.right = node.left;
            }
        } else {
            if (node.parent.left == node) {
                node.parent.left = successor;
            } else {
                node.parent.right = successor;
            }
        }
        return Optional.of(node);
    }
}
