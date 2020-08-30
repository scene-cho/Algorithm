package sort;

public class Sorts {

    public static void bubble(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    SortHelper.swap(array, i, j);
                }
            }
        }
    }


    public static void selection(int[] array) {

    }
}