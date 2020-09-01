package sort;

public class PerformanceProxy implements Sorter {

    private static final PerformanceProxy SINGLETON = new PerformanceProxy();
    private final SorterImpl sorter;

    private PerformanceProxy() {
        sorter = SorterImpl.getInstance();
    }

    public static PerformanceProxy getInstance() {
        return SINGLETON;
    }

    public static PerformanceProxy getInstance(Strategy strategy) {
        SINGLETON.sorter.setStrategy(strategy);
        return SINGLETON;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        sorter.setStrategy(strategy);
    }

    @Override
    public void sort(int[] array) {
        String nameOfStrategy = sorter.getNameOfStrategy();
        long start = System.currentTimeMillis();

        sorter.sort(array);

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.format("%s - %s ms\n", nameOfStrategy, time);
    }
}
