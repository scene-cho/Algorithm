package search;

import java.util.*;

public abstract class BinaryTree implements Tree {
    Node root;

    List<Node> inOrder() {
        return null;
    }

    List<Node> preOrder() {
        return null;
    }

    List<Node> postOrder() {
        return null;
    }

    List<List<Node>> levelOrder(BinaryTree bt) {
        List<List<Node>> tree = new ArrayList<>();

        Queue<Node> station = new LinkedList<>();
        station.add(bt.root);

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

    Node successor(Node current) {
        return null;
    }

    Node predecessor(Node current) {
        return null;
    }

}
