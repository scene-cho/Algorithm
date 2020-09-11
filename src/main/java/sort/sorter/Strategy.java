package sort.sorter;


import sort.algorithm.*;

public enum Strategy {
    BUBBLE(Bubble.getInstance()), SELECTION(Selection.getInstance()), INSERTION(Insertion.getInstance()),
    MERGE(Merge.getInstance()), HEAP(Heap.getInstance()), QUICK(Quick.getInstance());

    private final Algorithm algorithm;

    Strategy(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void execute(int[] array) {
        algorithm.execute(array);
    }

}
