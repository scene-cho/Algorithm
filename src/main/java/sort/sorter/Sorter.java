package sort.sorter;

public interface Sorter {

    void setStrategy(Strategy strategy);

    void sort(int[] array);

}
