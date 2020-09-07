package search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void insert() {
        BinarySearchTree bst = new BinarySearchTree();
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
        // Todo
    }

    @Test
    void delete() {
        // Todo
    }

}