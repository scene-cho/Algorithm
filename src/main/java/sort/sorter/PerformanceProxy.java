package sort.sorter;

public class PerformanceProxy implements Sorter {

    private static final PerformanceProxy SINGLETON = new PerformanceProxy();
    private final SorterImpl sorter;

    private String lastStrategyName;
    private long lastPerformanceTime;

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
        long start = System.currentTimeMillis();
        sorter.sort(array);
        long end = System.currentTimeMillis();
        long time = end - start;
        saveRecord(sorter.getStrategyName(), time);
    }

    private void saveRecord(String strategyName, long performanceTime) {
        lastStrategyName = strategyName;
        lastPerformanceTime = performanceTime;
    }

    public void printLastRecord() {
        System.out.format("%s - %s ms\n", lastStrategyName, lastPerformanceTime);
    }

    public Long getLastPerformanceTime() {
        return lastPerformanceTime;
    }
}
