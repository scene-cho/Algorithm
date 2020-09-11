package sort.algorithm;

public class Bubble extends AbstractAlgorithm {

    private static final Bubble SINGLETON = new Bubble();

    private Bubble() {
    }

    public static Bubble getInstance() {
        return SINGLETON;
    }

    @Override
    public void execute(int[] array) {
        setVariables(array);

        for (int dest = first; dest < last; dest++) {

            for (int src = last; src > dest; src--) {
                int front;
                int rear;
                rear = src;
                front = rear - 1;
                if (isNotSorted(array, front, rear)) {
                    ArrayHelper.swap(array, front, rear);
                }
            }

        }

    }

    private boolean isNotSorted(int[] array, int front, int rear) {
        return array[front] > array[rear];
    }
}
