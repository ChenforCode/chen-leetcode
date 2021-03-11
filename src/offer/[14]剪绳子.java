package offer;

/**
 * @author <a href="http://blog.chenforcode.cn">PKUCoder</a>
 * @date 2021/3/11 2:30 下午
 * @description 剑指 Offer 14- I. 剪绳子
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 *
 * 对于i长度的绳子尝试切出一个j长度的绳子，这时剩下的i - j如果不切，那么乘积为j * (i * j)
 * 如果i-j也切，那么乘积变成 j * dp[i - j]，对于当前长度的j，得到的最大值就是
 * Math.max(j * (i - j), j * dp[i - j]);
 *
 * 然后j是一个变值，可以从2切分到(i - 1)。切1代表没切，切i也代表没切。
 * 所以需要求出所有j的最大值。。就是当前最大值为curMax
 * 最终的最大值就是 max = Max.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
 * 然后更新 dp[i] = max;
 *
 * 或者直接简写更新dp[i] = Max.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
 *
 */
class CuttingRope {
    public int cuttingRope(int n) {
        //dp[i]代表i长度的绳子的最大的切割乘积，我们只需要求出dp[n]即可，dp[0]dp[1]
        //根据题意都是0，dp[2]只能切成1 * 1，所以dp[2] = 1
        int []dp = new int[n + 1];
        dp[2] = 1;
        //从3开始计算
        for (int i = 3; i <= n; i++) {
            int maxJ = 0;
            //尝试切出来一个j长度，然后求出切出的最大值为Math.max(j * (i - j), j * dp[i - j])
            //接下来用这个值和dp[i]比大小更新，或者是求出所有这个值得最大值，再和dp[i]比大小，都可以
            //就是说  1 2 3 4 5和 3更新最大值。。。可以一个一个比，也可以求出12345的最大
            //再和3比
            for (int j = 2; j < i; j++) {
                maxJ = Math.max(maxJ, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = maxJ;
        }
        return dp[n];
    }
}
