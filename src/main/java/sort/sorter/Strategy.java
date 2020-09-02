package sort.sorter;

import sort.strategy.*;

public enum Strategy {
    // TODO make Singleton
    BUBBLE(new Bubble()), SELECTION(new Selection()), INSERTION(new Insertion()), MERGE(new Merge()), HEAP(new Heap());

    private final Algorithm algorithm;

    Strategy(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void execute(int[] array) {
        algorithm.execute(array);
    }

}
