package search;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    final int MIN_N = 7;
    final int MAX_N = 15;
    int n;

    BinaryTree bt;
    List<Integer> numberStore;

    @BeforeEach
    void setBinaryTree() {
        n = MIN_N + new Random().nextInt(MAX_N - MIN_N + 1);
        numberStore = TreeHelper.createUniqueRandomNumberStore(n);
        bt = TreeHelper.createBST(numberStore);
    }

    @AfterEach
    void printTree() {
        TreeHelper.printTree(bt);
    }

    @Test
    void min() {
        Node min = bt.min();
        assertEquals(0, min.value);
    }

    @Test
    void max() {
        Node max = bt.max();
        assertEquals(n - 1, max.value);
    }

    @Test
    void successor() {
        int standard = TreeHelper.getExistentValue(numberStore);

        Node standardNode = bt.search(standard).orElse(null);
        Node successor = bt.successor(standardNode).orElse(null);

        if (isMaxValueInNumberStore(standard, numberStore)) {
            assertNotNull(standardNode);
            assertNull(successor);
            return;
        }

        assertNotNull(standardNode);
        assertNotNull(successor);

        int expected = standard + 1;
        int actual = successor.value;
        assertEquals(expected, actual);
    }

    private boolean isMaxValueInNumberStore(int standard, List<Integer> numberStore) {
        Integer max = numberStore.stream().max(Comparator.naturalOrder()).orElseThrow();
        return max.equals(standard);
    }
}
