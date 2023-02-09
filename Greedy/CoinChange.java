import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        System.out.println("Change for 70 is " + Arrays.toString(getCoinChange(70)));
        System.out.println("Change for 2500 is " + Arrays.toString(getCoinChange(2500)));

    }

    public static int[] getCoinChange(int amount) {
        int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

        int remainingAmount = amount;
        int[] change = new int[coins.length];
        int i = 0;
        for (int j = coins.length - 1; j >= 0; j--) {
            while (coins[j] <= remainingAmount) {
                remainingAmount -= coins[j];
                change[i++] = coins[j];
            }
        }
        return change;
    }
}
