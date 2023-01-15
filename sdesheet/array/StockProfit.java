public class StockProfit {

    public static void main(String[] args) {

        int[] input = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Profit " + profitBruteForce(input));

        System.out.println("Profit " + profitOptimalApproach(input));

    }

    private static int profitBruteForce(int[] input) {
        int maxProfit = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[j] > input[i]) {
                    maxProfit = Math.max(maxProfit, input[j] - input[i]);
                }
            }
        }
        return maxProfit;
    }

    private static int profitOptimalApproach(int[] input) {
        int maxProfit = 0;
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            minimum = Math.min(input[i], minimum);
            maxProfit = Math.max(maxProfit, input[i] - minimum);
        }
        return maxProfit;
    }

}
