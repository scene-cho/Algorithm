package sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {
    int N = 50;
    int BOUND = 50;

    int[] original;
    int[] expected;
    int[] actual;

    @BeforeEach
    void setArrays() {
        original = new int[N];
        expected = new int[N];
        actual = new int[N];
        setRandomElements(original, BOUND);
        copyArray(original, expected);
        copyArray(original, actual);
    }

    @Test
    void bubbleSort() {
        Arrays.sort(expected);
        Sorts.bubble(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void selectionSort() {
        Arrays.sort(expected);
        Sorts.selection(actual);
        assertArrayEquals(expected, actual);
    }

    @AfterEach
    void printArrays() {
        printArray("original", original);
        printArray("expected", expected);
        printArray("actual", actual);
    }

    private void setRandomElements(int[] array, int bound) {
        Random random = new Random();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(bound);
        }
    }

    private void copyArray(int[] source, int[] destination) {
        int n = source.length;
        System.arraycopy(source, 0, destination, 0, n);
    }

    private void printArray(String title, int[] array) {
        System.out.format("%-8s: ", title);
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(array[n - 1]);
    }
}
