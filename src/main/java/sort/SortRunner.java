package sort;

import sort.sorter.PerformanceProxy;
import sort.sorter.Strategy;

import java.text.DecimalFormat;
import java.util.*;

import static java.util.Map.Entry;

public class SortRunner {
    public static void main(String[] args) {
        comparePerformance(8, 10_000_000, 1000L);
    }

    public static void comparePerformance(int startN, int endN, long threshold) {
        PerformanceProxy sorter = PerformanceProxy.getInstance();
        List<Strategy> allStrategies = Arrays.asList(Strategy.values());
        List<Strategy> survivors = new ArrayList<>(allStrategies);

        for (int n = startN; n < endN; n *= 2) {
            Map<String, Long> recordsOfThisN = new HashMap<>();
            List<Strategy> dropouts = new ArrayList<>();

            for (Strategy strategy : survivors) {
                int[] array = ArrayHelper.createRandomArray(n, n);

                sorter.setStrategy(strategy);
                sorter.sort(array);

                long performanceTime = sorter.getLastPerformanceTime();
                recordsOfThisN.put(strategy.name(), performanceTime);

                if (performanceTime > threshold) dropouts.add(strategy);
            }

            List<Entry<String, Long>> sortedRecords = sortRecords(recordsOfThisN);
            printRecord(n, sortedRecords);

            for (Strategy dropout : dropouts) survivors.remove(dropout);
        }
    }

    private static List<Entry<String, Long>> sortRecords(Map<String, Long> records) {
        List<Entry<String, Long>> entries = new ArrayList<>(records.entrySet());
        entries.sort(Entry.comparingByValue());
        return entries;
    }

    private static void printRecord(int n, List<Entry<String, Long>> entries) {
        String formattedN = new DecimalFormat("#,##0").format(n);
        System.out.format("n = %10s   -   ", formattedN);
        for (Entry<String, Long> entry : entries) {
            String key = entry.getKey();
            String formattedKey = (key.length() > 6) ? key.substring(0, 6) : key;
            System.out.format("[ %-6s : %4s ms ]    ", formattedKey, entry.getValue());
        }
        System.out.println();
    }

}
