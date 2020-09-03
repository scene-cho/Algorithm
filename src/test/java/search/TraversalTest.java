package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TraversalTest {

    int n = 10;
    BinarySearchTree bst;

    @BeforeEach
    void setBST() {
        bst = new BinarySearchTree();
        int[] randomDataStore = new int[n];
        Random random = new Random();
        // Todo
    }

    @Test
    void inOrder() {
        List<Node> expected = new ArrayList<>();
        // Todo
//        expected.sort();

        List<Node> nodes = bst.inOrder();

//        assertArrayEquals(expected, nodes);
    }

    @Test
    void preOrder() {
        // TODO
    }

    @Test
    void postOrder() {
        // TODO stack calc
    }

}