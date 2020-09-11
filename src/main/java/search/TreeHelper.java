package search;

import java.util.*;

public class TreeHelper {

    public static List<Integer> createFormalNumberStore(int n) {
        List<Integer> formalNumberStore = new ArrayList<>();
        saveMeanInNumberStore(formalNumberStore, 0, n - 1);
        return formalNumberStore;
    }

    private static void saveMeanInNumberStore(List<Integer> formalNumberStore, int min, int max) {
        if (min > max) return;

        int mean = (min + max) / 2;
        formalNumberStore.add(mean);
        saveMeanInNumberStore(formalNumberStore, min, mean - 1);
        saveMeanInNumberStore(formalNumberStore, mean + 1, max);
    }

    public static List<Integer> createUniqueRandomNumberStore(int n) {
        List<Integer> uniqueRandomNumberStore = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomInt;
            do {
                randomInt = random.nextInt(n);
            } while (uniqueRandomNumberStore.contains(randomInt));
            uniqueRandomNumberStore.add(randomInt);
        }
        return uniqueRandomNumberStore;
    }

    public static BinarySearchTree createBST(List<Integer> numberStore) {
        BinarySearchTree tree = new BinarySearchTree();
        for (Integer integer : numberStore) {
            tree.insert(integer);
        }
        return tree;
    }

    public static List<Node> flatten(List<List<Node>> lists) {
        List<Node> flatList = new ArrayList<>();
        for (List<Node> list : lists) {
            flatList.addAll(list);
        }
        return flatList;
    }

    public static List<Node> extractNonNull(List<Node> list) {
        List<Node> extracted = new ArrayList<>();
        for (Node node : list) {
            if (node != null) {
                extracted.add(node);
            }
        }
        return extracted;
    }

    public static List<Integer> convertListNodeToInteger(List<Node> nodeList) {
        List<Integer> integerList = new ArrayList<>();
        for (Node node : nodeList) {
            integerList.add(node.value);
        }
        return integerList;
    }

    public static int getExistentValue(List<Integer> numberStore) {
        Random random = new Random();
        int randomIndex = random.nextInt(numberStore.size());
        return numberStore.get(randomIndex);
    }

    public static int getNonExistentValue(List<Integer> numberStore) {
        Random random = new Random();
        int nonExistentValue;
        do {
            nonExistentValue = random.nextInt();
        } while (numberStore.contains(nonExistentValue));
        return nonExistentValue;
    }

    public static void printTree(BinaryTree bt) {
        List<List<Node>> lists = bt.levelOrder();
        int nodeWidth = getNodeWidth(bt);
        printTreeInShape(lists, nodeWidth);
    }

    private static int getNodeWidth(BinaryTree bt) {
        Integer maxValue = bt.max().value;
        int digit = 1;
        while ((maxValue /= 10) != 0) digit++;
        return digit + 2;
    }

    private static void printTreeInShape(List<List<Node>> lists, final int NODE_WIDTH) {
        final int TREE_HEIGHT = lists.size();
        final int TREE_WIDTH = lists.get(TREE_HEIGHT - 1).size();
        final int OUTPUT_WIDTH = TREE_WIDTH * NODE_WIDTH;

        StringBuilder buffer = new StringBuilder();
        for (List<Node> line : lists)
            saveLineToBuffer(line, buffer, OUTPUT_WIDTH, NODE_WIDTH);
        System.out.println(buffer.toString());
    }

    private static void saveLineToBuffer(List<Node> line, StringBuilder buffer, final int OUTPUT_WIDTH, final int NODE_WIDTH) {
        final int LINE_NODE_COUNT = line.size();
        final int WHITESPACE_WIDTH_AVG = (OUTPUT_WIDTH - (LINE_NODE_COUNT * NODE_WIDTH)) / LINE_NODE_COUNT;

        buffer.append(" ".repeat(WHITESPACE_WIDTH_AVG / 2));
        for (Node node : line) {
            if (node != null) buffer.append(String.format("(%" + (NODE_WIDTH - 2) + "s)", node.value));
            else buffer.append("(").append(" ".repeat(NODE_WIDTH - 2)).append(")");
            buffer.append(" ".repeat(WHITESPACE_WIDTH_AVG));
        }
        buffer.append("\n");
    }
}
