package chapter4;

/**
 * Created by mihai.isaroiu on 7/21/15.
 */
public class DPCChange {


    public final static int run(int sum, Integer[] coins) {
        int[] minNumCoins = new int[sum + 1];
        for (int i = 1; i <= sum; i++) {
            minNumCoins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j])
                    if (minNumCoins[i - coins[j]] + 1 < minNumCoins[i])
                        minNumCoins[i] = minNumCoins[i - coins[j]] + 1;
            }

        }
        return minNumCoins[sum];
    }


}
