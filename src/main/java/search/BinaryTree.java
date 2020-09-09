package search;

import java.util.*;

public abstract class BinaryTree implements Tree {
    Node root;

    List<Node> inOrder() {
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

    List<Node> preOrder() {
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

    List<Node> postOrder() {
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

    List<List<Node>> levelOrder() {
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
        for (Node inLevel : level) {
            Node left = (inLevel != null) ? inLevel.left : null;
            Node right = (inLevel != null) ? inLevel.right : null;
            station.add(left);
            station.add(right);
        }
    }

    Node min() {
        return null;
    }

    Node max() {
        return null;
    }

    Optional<Node> successor(Node standard) {
        if (standard == null) return Optional.empty();

        Node path;
        Node result;

        if (standard.right != null) {
            path = standard.right;
            result = path;

            while (path.left != null) {
                path = path.left;
                result = path;
            }

            return Optional.of(result);
        }

        path = root;
        result = null;

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

    Optional<Node> predecessor(Node standard) {
        return Optional.empty();
    }

}
