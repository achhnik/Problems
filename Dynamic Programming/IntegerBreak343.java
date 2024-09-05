public class IntegerBreak {
    public static void main(String args[])
    {
        int n = 10;
        if(n == 2 || n == 3) System.out.println(n-1);
        else System.out.println(helper(n));
    }
    public static int helper(int n)
    {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= n; i++)
        {
            int res = 0;
            for(int j = 1; j < i; j++)
            {
                dp[i] = dp[j] * dp[i-j];
                res = Math.max(res, dp[i]);
                dp[i] = res;
            }
        }
        return dp[n];
        }
}
