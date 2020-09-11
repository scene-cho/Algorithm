package search;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    final int MIN_N = 7;
    final int MAX_N = 15;
    int n;

    BinarySearchTree bst;
    List<Integer> numberStore;

    @BeforeEach
    void setBst() {
        n = MIN_N + new Random().nextInt(MAX_N - MIN_N + 1);
        numberStore = TreeHelper.createUniqueRandomNumberStore(n);
        bst = TreeHelper.createBST(numberStore);
    }

    @AfterEach
    void printTree() {
        TreeHelper.printTree(bst);
    }

    @Test
    void insert() {
        List<Integer> expected = new ArrayList<>(List.copyOf(numberStore));
        expected.sort(Comparator.naturalOrder());

        List<Node> ordered = bst.inOrder();
        List<Integer> actual = TreeHelper.convertListNodeToInteger(ordered);

        assertIterableEquals(expected, actual);
    }

    @Test
    void search() {
        int existentValue = TreeHelper.getExistentValue(numberStore);
        Node foundNode = bst.search(existentValue).orElse(null);
        assertNotNull(foundNode);
        assertEquals(existentValue, foundNode.value);

        int nonExistentValue = TreeHelper.getNonExistentValue(numberStore);
        Node nullNode = bst.search(nonExistentValue).orElse(null);
        assertNull(nullNode);
    }

    @Test
    void delete() {
        int countBefore = bst.count();
        assertEquals(n, countBefore);

        int targetValue = TreeHelper.getExistentValue(numberStore);
        Node deleted = bst.delete(targetValue).orElse(null);
        assertNotNull(deleted);
        assertEquals(targetValue, deleted.value);

        int countAfter = bst.count();
        assertEquals(n - 1, countAfter);
        Node nonExistent = bst.delete(targetValue).orElse(null);
        assertNull(nonExistent);

    }

}