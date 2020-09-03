package search;

import java.util.Optional;

public class BinarySearchTree extends BinaryTree {
    Node root;

    @Override
    public Node insert(int value) {
        Node newNode = new Node(value);

        if (root == null) root = newNode;

        return null;
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
