package offer;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/3/9 9:53 下午
 * @description 剑指 Offer 10- II. 青蛙跳台阶问题
 */
class NumWays {
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
