package sort.algorithm;

import java.util.Random;

public class ArrayHelper {
    public static void swap(int[] array, int i, int j) {
        if (i == j) return;

        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static int[] createRandomArray(int n, int bound) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = random.nextInt(bound);
        return array;
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
