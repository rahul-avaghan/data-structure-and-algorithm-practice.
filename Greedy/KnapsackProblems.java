import java.util.Arrays;
import java.util.Comparator;

/***
 * 
 * 
 * Fractional Knapsack Problem : Greedy Approach
 * Problem Statement: The weight of N items and their corresponding values are
 * given. We have to put these items in a knapsack of weight W such that the
 * total value obtained is maximized.
 */
public class KnapsackProblems {

    public static class Item {

        private int value;
        private int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static class WeightComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            double r1 = (double) o1.value / (double) o1.weight;
            double r2 = (double) o2.value / (double) o2.weight;

            if (r1 < r2) {
                return 1;
            } else if (r1 > r2) {
                return -1;
            } else
                return 0;

        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        int weight = 50;

        System.out.println("Final value " + getFinalValue(items, weight));
    }

    public static double getFinalValue(Item[] items, int weight) {

        Arrays.sort(items, new WeightComparator());

        int currentWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < items.length; i++) {

            if (currentWeight + items[i].weight <= weight) {
                currentWeight += items[i].weight;
                finalValue += items[i].value;
            } else {
                int remainingWeight = weight - currentWeight;

                finalValue += remainingWeight * ((double) items[i].value / (double) items[i].weight);
                break;
            }

        }
        return finalValue;
    }

}
