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
        return Optional.empty();
    }

    @Override
    public Optional<Node> delete(int value) {
        return Optional.empty();
    }
}
