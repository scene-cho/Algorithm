package sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.algorithm.ArrayHelper;
import sort.sorter.PerformanceProxy;
import sort.sorter.Sorter;
import sort.sorter.Strategy;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    int N = 10_000;
    int BOUND = N;
    Sorter sorter = PerformanceProxy.getInstance();
    boolean printArrays = true;

    int[] original;
    int[] expected;
    int[] actual;

    @BeforeEach
    void setArrays() {
        original = ArrayHelper.createRandomArray(N, BOUND);
        expected = Arrays.copyOf(original, N);
        actual = Arrays.copyOf(original, N);

        Arrays.sort(expected);
    }


    @Test
    void bubbleSort() {
        sorter.setStrategy(Strategy.BUBBLE);
        sorter.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void selectionSort() {
        sorter.setStrategy(Strategy.SELECTION);
        sorter.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void insertionSort() {
        sorter.setStrategy(Strategy.INSERTION);
        sorter.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void mergeSort() {
        sorter.setStrategy(Strategy.MERGE);
        sorter.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void heapSort() {
        sorter.setStrategy(Strategy.HEAP);
        sorter.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void quickSort() {
        sorter.setStrategy(Strategy.Quick);
        sorter.sort(actual);
        assertArrayEquals(expected, actual);
    }


    @AfterEach
    void printArrays() {
        if (sorter instanceof PerformanceProxy) {
            PerformanceProxy performanceProxy = (PerformanceProxy) sorter;
            performanceProxy.printLastRecord();
        }

        if (printArrays) {
            ArrayHelper.printArray("original", original);
            ArrayHelper.printArray("expected", expected);
            ArrayHelper.printArray("actual", actual);
        }
    }

}
