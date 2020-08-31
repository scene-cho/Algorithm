package sort;

public class SorterImpl implements Sorter {

    Strategy strategy;

    public SorterImpl() {
        // TODO change default algorithm to Quick
        this.strategy = Strategy.BUBBLE;
    }

    public SorterImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String getNameOfStrategy() {
        return strategy.name();
    }

    @Override
    public void sort(int[] array) {
        strategy.execute(array);
    }

}