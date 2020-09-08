package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree bst;

    @BeforeEach
    void setBst() {
        bst = new BinarySearchTree();
    }

    @Test
    void insert() {
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(6);
        bst.insert(7);
        bst.insert(1);
        bst.insert(5);
        List<List<Node>> lists = bst.levelOrder(bst);
        for (List<Node> list : lists) {
            for (Node node : list) {
                String value;
                if (node == null) value = "n ";
                else value = node.value + " ";
                System.out.print(value);
            }
            System.out.println();
        }

    }

    @Test
    void search() {
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(6);
        bst.insert(7);
        bst.insert(1);
        bst.insert(5);
        Node node = bst.search(3).orElse(null);
        assertNotNull(node);
        assertEquals(3, node.value);
        Node node2 = bst.search(8).orElse(null);
        assertNull(node2);
    }

    @Test
    void delete() {
        // Todo
    }

}