package sort.algorithm;

public class Quick extends AbstractAlgorithm {
    @Override
    public void execute(int[] array) {
        setVariables(array);
        quickSort(array, first, last);
    }

    private void quickSort(int[] array, int first, int last) {
        if (first >= last) return;

        int pivot = partition(array, first, last);

        quickSort(array, first, pivot - 1);
        quickSort(array, pivot + 1, last);
    }

    private int partition(int[] array, int first, int last) {
        int pivotValue = array[last];
        int inspector = first - 1;
        int locator = first;

        while (++inspector < last) {
            if (array[inspector] < pivotValue) {
                ArrayHelper.swap(array, inspector, locator++);
            }
        }

        ArrayHelper.swap(array, locator, last);
        return locator;
    }
}
