public class CoinChangeProblem518 {
    public static void main(String args[])
    {
        int coins[] = {1, 2, 5};
        int amount = 5;
        System.out.println(changeOpt(amount,coins));
    }
    public static int change(int[] coins, int n, int amount, int count)
    {
        if(n == 0)
        {
            if(amount == 0)
            {
                return count + 1;
            }
            return count;
        }
        int take = 0;
        int nottake = 0;
        if(coins[n-1] <= amount)
        {
            take = change(coins, n, amount - coins[n-1], count);
        }
        nottake = change(coins, n-1, amount, count);
        return take + nottake;
    }

    public static int changeOpt(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
