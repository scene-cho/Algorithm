package sort;

import java.util.Random;

public class ArrayHelper {
    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static int[] createRandomArray(int n, int bound) {
        int[] array = new int[n];
        fillArrayWithRandomElements(array, bound);
        return array;
    }

    public static void fillArrayWithRandomElements(int[] array, int bound) {
        Random random = new Random();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(bound);
        }
    }

    public static void copyArray(int[] source, int[] destination) {
        int n = source.length;
        System.arraycopy(source, 0, destination, 0, n);
    }

    public static void printArray(String title, int[] array) {
        System.out.format("%-8s: ", title);
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(array[n - 1]);
    }
}
