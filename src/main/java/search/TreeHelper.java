package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeHelper {

    public static List<Integer> createRandomNumberStore(int n) {
        List<Integer> randomNumberStore = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomInt;
            do {
                randomInt = random.nextInt(n);
            }
            while (randomNumberStore.contains(randomInt));
            randomNumberStore.add(randomInt);
        }
        return randomNumberStore;
    }

    public static BinarySearchTree createBST(List<Integer> randomNumberStore) {
        BinarySearchTree tree = new BinarySearchTree();
        for (Integer integer : randomNumberStore) {
            tree.insert(integer);
        }
        return tree;
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
        do nonExistentValue = random.nextInt(numberStore.size() * 10);
        while (numberStore.contains(nonExistentValue));
        return nonExistentValue;
    }

    public static void printTree(BinaryTree bt) {
        List<List<Node>> lists = bt.levelOrder();

        // TODO format commit
        int nodeWidth = 3;
        String letterSpaceSymbol = " ";
        String lineSpaceSymbol = "\n";

        printTreeWithSpace(lists, nodeWidth, letterSpaceSymbol, lineSpaceSymbol);
    }

    private static void printTreeWithSpace(List<List<Node>> lists, final int NODE_WIDTH, String letterSpaceSymbol, String lineSpaceSymbol) {

        final int TREE_HEIGHT = lists.size();
        final int TREE_WIDTH = lists.get(TREE_HEIGHT - 1).size();
        final int OUTPUT_WIDTH = TREE_WIDTH * NODE_WIDTH;

        StringBuilder buffer = new StringBuilder();
        for (List<Node> line : lists) {
            saveLineToBuffer(line, buffer, OUTPUT_WIDTH, NODE_WIDTH, letterSpaceSymbol, lineSpaceSymbol);
        }
        System.out.println(buffer.toString());
    }

    private static void saveLineToBuffer(List<Node> line, StringBuilder buffer, final int OUTPUT_WIDTH, final int NODE_WIDTH, String letterSpaceSymbol, String lineSpaceSymbol) {
        final int TAKEN_WIDTH = line.size() * NODE_WIDTH;
        final int SPACE_WIDTH = OUTPUT_WIDTH - TAKEN_WIDTH;
        final int SPACE_WIDTH_AVG = SPACE_WIDTH / line.size();
        final int SPACE_WIDTH_TERMINAL = SPACE_WIDTH_AVG / 2;

        buffer.append(letterSpaceSymbol.repeat(SPACE_WIDTH_TERMINAL));
        for (Node node : line) {
            if (node != null) buffer.append(String.format("(%s)", node.value));
            else buffer.append("( )");

            if (isNotLastNode(node, line)) buffer.append(letterSpaceSymbol.repeat(SPACE_WIDTH_AVG));
        }
        buffer.append(lineSpaceSymbol);
    }

    private static boolean isNotLastNode(Node node, List<Node> list) {
        return list.indexOf(node) != list.size() - 1;
    }

    public static void printPath(List<Node> paths) {
        for (Node n : paths) {
            if (paths.indexOf(n) != paths.size() - 1) System.out.print(n.value + " - ");
            else System.out.println(n.value);
        }
    }

}
