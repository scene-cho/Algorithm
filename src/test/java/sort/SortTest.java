package sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.sorter.PerformanceProxy;
import sort.sorter.Sorter;
import sort.sorter.Strategy;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    int N = 10000;
    int BOUND = 10000;
    Sorter sorter = PerformanceProxy.getInstance();
    boolean printArrays = true;

    int[] original;
    int[] expected;
    int[] actual;

    @BeforeEach
    void setArrays() {
        original = new int[N];
        ArrayHelper.fillArrayWithRandomElements(original, BOUND);

        expected = new int[N];
        ArrayHelper.copyArray(original, expected);
        Arrays.sort(expected);

        actual = new int[N];
        ArrayHelper.copyArray(original, actual);
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
