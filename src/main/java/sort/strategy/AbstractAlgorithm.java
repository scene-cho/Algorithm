package sort.strategy;

import sort.sorter.Algorithm;

public abstract class AbstractAlgorithm implements Algorithm {

    protected int n;
    protected int first;
    protected int last;

    protected void setVariables(int[] array) {
        n = array.length;
        first = 0;
        last = n - 1;
    }
}
