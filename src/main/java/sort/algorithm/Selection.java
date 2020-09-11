package sort.algorithm;

public class Selection extends AbstractAlgorithm {

    private static final Selection SINGLETON = new Selection();

    private Selection() {
    }

    public static Selection getInstance() {
        return SINGLETON;
    }

    @Override
    public void execute(int[] array) {
        setVariables(array);

        for (int dest = first; dest < last; dest++) {
            int selectedSrc = dest;

            for (int candidateSrc = dest + 1; candidateSrc <= last; candidateSrc++) {
                if (isSuitableChallenger(array, selectedSrc, candidateSrc)) {
                    selectedSrc = candidateSrc;
                }
            }

            ArrayHelper.swap(array, selectedSrc, dest);
        }

    }

    private boolean isSuitableChallenger(int[] array, int champion, int challenger) {
        return array[challenger] < array[champion];
    }
}
