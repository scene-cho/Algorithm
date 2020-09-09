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
    void insert() {
        List<Integer> expected = new ArrayList<>(List.copyOf(randomNumberStore));
        expected.sort(Comparator.naturalOrder());

        List<Node> ordered = bst.inOrder();
        List<Integer> actual = TreeHelper.convertListNodeToInteger(ordered);

        assertIterableEquals(expected, actual);
    }

    @Test
    void search() {
        int existentValue = TreeHelper.getExistentValue(randomNumberStore);
        Node foundNode = bst.search(existentValue).orElse(null);
        assertNotNull(foundNode);
        assertEquals(existentValue, foundNode.value);

        int nonExistentValue = TreeHelper.getNonExistentValue(randomNumberStore);
        Node nullNode = bst.search(nonExistentValue).orElse(null);
        assertNull(nullNode);
    }

    @Test
    void delete() {
        Random random = new Random();
        int randomIndex = random.nextInt(N);

        int existentValue = 7;
//        randomNumberStore.get(randomIndex);
        Node foundNode = bst.delete(existentValue).orElse(null);
        assertNotNull(foundNode);
        assertEquals(existentValue, foundNode.value);

        int nonExistentValue;
        do nonExistentValue = random.nextInt(N * 10);
        while (randomNumberStore.contains(nonExistentValue));
        Node nullNode = bst.delete(nonExistentValue).orElse(null);
        assertNull(nullNode);
    }

}