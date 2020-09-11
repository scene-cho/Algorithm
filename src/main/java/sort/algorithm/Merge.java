package sort.algorithm;

public class Merge extends AbstractAlgorithm {

    private static final Merge SINGLETON = new Merge();

    private Merge() {
    }

    public static Merge getInstance() {
        return SINGLETON;
    }

    @Override
    public void execute(int[] array) {
        setVariables(array);
        mergeSort(array, first, last);
    }

    private void mergeSort(int[] array, int head, int tail) {
        if (isAlone(head, tail)) return;

        int center = (head + tail) / 2;

        mergeSort(array, head, center);
        mergeSort(array, center + 1, tail);

        merge(array, head, center, center + 1, tail);
    }

    private boolean isAlone(int head, int tail) {
        return head >= tail;
    }

    private void merge(int[] array, int firstHead, int firstTail, int secondHead, int secondTail) {
        int tempN = secondTail - firstHead + 1;
        int[] tempArray = new int[tempN];
        int tempPtr = 0;

        int firstPtr = firstHead;
        int secondPtr = secondHead;

        while (hasFreeSpace(firstPtr, firstTail, secondPtr, secondTail)) {
            tempArray[tempPtr++] = (array[firstPtr] < array[secondPtr]) ? array[firstPtr++] : array[secondPtr++];
        }

        while (tempPtr < tempN) {
            tempArray[tempPtr++] = hasFreeSpace(firstPtr, firstTail) ? array[firstPtr++] : array[secondPtr++];
        }

        System.arraycopy(tempArray, 0, array, firstHead, tempN);
    }

    private boolean hasFreeSpace(int ptr, int tail) {
        return ptr <= tail;
    }

    private boolean hasFreeSpace(int firstPtr, int firstTail, int secondPtr, int secondTail) {
        return (hasFreeSpace(firstPtr, firstTail)) && (hasFreeSpace(secondPtr, secondTail));
    }
}
