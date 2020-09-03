package sort.sorter;


import sort.algorithm.*;

public enum Strategy {
    // TODO make Singleton
    BUBBLE(new Bubble()), SELECTION(new Selection()), INSERTION(new Insertion()), MERGE(new Merge()), HEAP(new Heap()), Quick(new Quick());

    private final Algorithm algorithm;

    Strategy(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void execute(int[] array) {
        algorithm.execute(array);
    }

}
