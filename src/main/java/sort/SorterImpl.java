package sort;

public class SorterImpl implements Sorter {

    private static final SorterImpl SINGLETON = new SorterImpl();
    private Strategy strategy;

    private SorterImpl() {
        strategy = Strategy.BUBBLE;
    }

    public static SorterImpl getInstance() {
        return SINGLETON;
    }

    public static SorterImpl getInstance(Strategy strategy) {
        SINGLETON.strategy = strategy;
        return SINGLETON;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        SINGLETON.strategy = strategy;
    }

    @Override
    public void sort(int[] array) {
        strategy.execute(array);
    }

    public String getNameOfStrategy() {
        return strategy.name();
    }

}