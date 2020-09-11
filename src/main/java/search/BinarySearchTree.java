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
        Node target = search(value).orElse(null);
        if (target == null) return Optional.empty();

        if (hasNoChild(target)) {
            replaceNodeInTree(target, null);
        } else if (hasOnlyChild(target)) {
            Node onlyChild = (target.left != null) ? target.left : target.right;
            replaceNodeInTree(target, onlyChild);
        } else {
            Node successor = successor(target).orElseThrow();
            replaceNodeInTree(successor, null);
            replaceNodeInTree(target, successor);
            adoptChildren(target, successor);
        }
        return Optional.of(target);
    }

    private boolean hasNoChild(Node node) {
        return (node.left == null) && (node.right == null);
    }

    private boolean hasTwoChildren(Node node) {
        return (node.left != null) && (node.right != null);
    }

    private boolean hasOnlyChild(Node node) {
        return (!hasNoChild(node)) && (!hasTwoChildren(node));
    }

    private void adoptChildren(Node from, Node to) {
        if (from.left != null) {
            from.left.parent = to;
            to.left = from.left;
        }
        if (from.right != null) {
            from.right.parent = to;
            Node temp = to.right;
            to.right = from.right;
            Node finder = to.right;
            while (finder.left != null)
                finder = finder.left;
            finder.left = temp;
        }
    }

    private void replaceNodeInTree(Node node, Node substitute) {
        if (isRoot(node)) {
            root = substitute;
        } else {
            if (node.parent.left == node) node.parent.left = substitute;
            else node.parent.right = substitute;

            if (substitute != null) substitute.parent = node.parent;
        }
    }

    private boolean isRoot(Node node) {
        return node.parent == null;
    }
}
