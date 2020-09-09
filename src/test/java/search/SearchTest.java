package search;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    final int N = 10;

    BinarySearchTree bst;
    List<Integer> randomNumberStore;

    @BeforeEach
    void setBst() {
        randomNumberStore = TreeHelper.createRandomNumberStore(N);
        bst = TreeHelper.createBST(randomNumberStore);
    }

    @AfterEach
    void printTree() {
        TreeHelper.printTree(bst);
    }

    @Test
    void min() {
        // TODO
    }

    @Test
    void max() {
        // TODO
    }

    @Test
    void successor() {
        int standard = TreeHelper.getExistentValue(randomNumberStore);

        Node standardNode = bst.search(standard).orElse(null);
        Node successor = bst.successor(standardNode).orElse(null);

        if (isMax(standard, randomNumberStore)) {
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

    private boolean isMax(int standard, List<Integer> numberStore) {
        Integer max = numberStore.stream().max(Comparator.naturalOrder()).orElse(null);
        if (max == null) return false;
        return max.equals(standard);
    }

    @Test
    void predecessor() {
        // TODO
    }

}
