package search;

import java.util.*;

public abstract class BinaryTree implements Tree {

    Node root;

    public List<Node> inOrder() {
        List<Node> ordered = new ArrayList<>();
        inOrderNode(root, ordered);
        return ordered;
    }

    private void inOrderNode(Node root, List<Node> ordered) {
        if (root == null) return;

        inOrderNode(root.left, ordered);
        ordered.add(root);
        inOrderNode(root.right, ordered);
    }

    public List<Node> preOrder() {
        List<Node> ordered = new ArrayList<>();
        preOrderNode(root, ordered);
        return ordered;
    }

    private void preOrderNode(Node root, List<Node> ordered) {
        if (root == null) return;

        ordered.add(root);
        preOrderNode(root.left, ordered);
        preOrderNode(root.right, ordered);
    }

    public List<Node> postOrder() {
        List<Node> ordered = new ArrayList<>();
        postOrderNode(root, ordered);
        return ordered;
    }

    private void postOrderNode(Node root, List<Node> ordered) {
        if (root == null) return;

        postOrderNode(root.left, ordered);
        postOrderNode(root.right, ordered);
        ordered.add(root);
    }

    public List<List<Node>> levelOrder() {
        List<List<Node>> tree = new ArrayList<>();

        Queue<Node> station = new LinkedList<>();
        station.add(root);

        while (hasNestLevel(station)) {
            List<Node> level = fillLevel(station);
            tree.add(level);
            fillStationWithChildren(station, level);
        }

        return tree;
    }

    private boolean hasNestLevel(Queue<Node> station) {
        return station.stream().anyMatch(Objects::nonNull);
    }

    private List<Node> fillLevel(Queue<Node> station) {
        List<Node> level = new ArrayList<>();
        while (!station.isEmpty()) {
            Node node = station.poll();
            level.add(node);
        }
        return level;
    }

    private void fillStationWithChildren(Queue<Node> station, List<Node> level) {
        for (Node node : level) {
            Node left = (node != null) ? node.left : null;
            Node right = (node != null) ? node.right : null;
            station.add(left);
            station.add(right);
        }
    }

    public int count() {
        return inOrder().size();
    }

    public Node min() {
        Node finder = root;
        while (finder.left != null) {
            finder = finder.left;
        }
        return finder;
    }

    public Node max() {
        Node finder = root;
        while (finder.right != null) {
            finder = finder.right;
        }
        return finder;
    }

    public Optional<Node> successor(Node standard) {
        if (standard == null) throw new IllegalArgumentException();

        if (standard.right != null)
            return findSuccessorInSubTree(standard);
        else
            return findSuccessorFromRoot(standard);
    }

    private Optional<Node> findSuccessorInSubTree(Node standard) {
        Node successor = standard.right;
        while (successor.left != null)
            successor = successor.left;
        return Optional.of(successor);
    }

    private Optional<Node> findSuccessorFromRoot(Node standard) {
        Node result = null;
        Node path = root;

        while (!path.equals(standard)) {
            while (path.value > standard.value) {
                result = path;
                path = path.left;
            }
            while (path.value < standard.value) {
                path = path.right;
            }
        }
        return Optional.ofNullable(result);
    }

}
