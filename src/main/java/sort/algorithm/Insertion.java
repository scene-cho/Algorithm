package sort.algorithm;

public class Insertion extends AbstractAlgorithm {

    private static final Insertion SINGLETON = new Insertion();

    private Insertion() {
    }

    public static Insertion getInstance() {
        return SINGLETON;
    }

    @Override
    public void execute(int[] array) {
        setVariables(array);

        for (int src = first + 1; src <= last; src++) {
            int insertVal = array[src];
            int dest = src;

            for (int candidateDest = src - 1; candidateDest >= first; candidateDest--) {
                if (isSuitableDestination(array, candidateDest, insertVal)) {
                    dest = candidateDest;
                }
            }

            shiftSandwichedElementsToNextIndex(array, dest, src);
            array[dest] = insertVal;
        }

    }

    private boolean isSuitableDestination(int[] array, int candidateDest, int insertVal) {
        return array[candidateDest] > insertVal;
    }

    private void shiftSandwichedElementsToNextIndex(int[] array, int oldIndexOfFirstElement, int newIndexOfLastElement) {
        int numberOfMovers = newIndexOfLastElement - oldIndexOfFirstElement;
        System.arraycopy(array, oldIndexOfFirstElement, array, oldIndexOfFirstElement + 1, numberOfMovers);
    }
}
