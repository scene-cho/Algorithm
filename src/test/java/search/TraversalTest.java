package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class TraversalTest {

    int n;
    BinarySearchTree bst;
    List<Integer> expected;
    List<Integer> actual;

    @BeforeEach
    void setBST() {
        expected = new ArrayList<>();
        actual = new ArrayList<>();

        bst = new BinarySearchTree();

        n = 7;

        bst.insert(3);

        bst.insert(1);
        bst.insert(5);

        bst.insert(0);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);

        TreeHelper.printTree(bst);
    }

    @Test
    void inOrder() {
        expected = List.of(0, 1, 2, 3, 4, 5, 6);

        List<Node> ordered = bst.inOrder();
        for (int i = 0; i < n; i++)
            actual.add(ordered.get(i).value);

        assertIterableEquals(expected, actual);
    }

    @Test
    void preOrder() {
        expected = List.of(3, 1, 0, 2, 5, 4, 6);

        List<Node> ordered = bst.preOrder();
        for (int i = 0; i < n; i++)
            actual.add(ordered.get(i).value);

        assertIterableEquals(expected, actual);
    }

    @Test
    void postOrder() {
        expected = List.of(0, 2, 1, 4, 6, 5, 3);

        List<Node> ordered = bst.postOrder();
        for (int i = 0; i < n; i++)
            actual.add(ordered.get(i).value);

        assertIterableEquals(expected, actual);
    }

    @Test
    void levelOrder() {
        expected = List.of(3, 1, 5, 0, 2, 4, 6);

        List<List<Node>> levelOrdered = bst.levelOrder();
        for (List<Node> ordered : levelOrdered)
            for (Node node : ordered)
                actual.add(node.value);

        assertIterableEquals(expected, actual);
    }
}