package sort;

public class PerformanceProxy implements Sorter {

    SorterImpl sorter;

    public PerformanceProxy() {
        sorter = new SorterImpl();
    }

    public PerformanceProxy(SorterImpl sorter) {
        this.sorter = sorter;
    }

    public PerformanceProxy(Strategy strategy) {
        sorter = new SorterImpl(strategy);
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
