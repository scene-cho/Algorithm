package search;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class TraversalTest {

    final int N = 10;

    BinaryTree bt;
    List<Integer> numberStore;

    @BeforeEach
    void setBinaryTree() {
        numberStore = TreeHelper.createFormalNumberStore(N);
        bt = TreeHelper.createBST(numberStore);
    }

    @AfterEach
    void printTree() {
        TreeHelper.printTree(bt);
    }

    @Test
    void inOrder() {
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Node> ordered = bt.inOrder();
        List<Integer> actual = TreeHelper.convertListNodeToInteger(ordered);

        assertIterableEquals(expected, actual);
    }

    @Test
    void preOrder() {
        List<Integer> expected = List.of(4, 1, 0, 2, 3, 7, 5, 6, 8, 9);

        List<Node> ordered = bt.preOrder();
        List<Integer> actual = TreeHelper.convertListNodeToInteger(ordered);

        assertIterableEquals(expected, actual);
    }

    @Test
    void postOrder() {
        List<Integer> expected = List.of(0, 3, 2, 1, 6, 5, 9, 8, 7, 4);

        List<Node> ordered = bt.postOrder();
        List<Integer> actual = TreeHelper.convertListNodeToInteger(ordered);

        assertIterableEquals(expected, actual);
    }

    @Test
    void levelOrder() {
        List<Integer> expected = List.of(4, 1, 7, 0, 2, 5, 8, 3, 6, 9);

        List<List<Node>> levelOrdered = bt.levelOrder();
        List<Node> flat = TreeHelper.flatten(levelOrdered);
        List<Node> extracted = TreeHelper.extractNonNull(flat);
        List<Integer> actual = TreeHelper.convertListNodeToInteger(extracted);

        assertIterableEquals(expected, actual);
    }

}