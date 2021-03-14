package offer;

import java.util.Arrays;
import java.util.HashSet;

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
class B {
    public static void main(String[] args) {
        System.out.println(new CuttingRope2().cuttingRope(127));
    }
}
class CuttingRope2 {
    private long mod = 1000000007;
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        if (n % 3 == 2) {
            return (int)((quickPow(3, n / 3) * 2) % mod);
        } else if (n % 3 == 0) {
            return (int)(quickPow(3, n / 3) % mod);
        } else {
            return (int)((quickPow(3, n / 3 - 1) * 4) % mod);
        }
    }

    public long quickPow(int x, int n) {
        long b = n;
        long res = 1;
        long base = x;
        if (n < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res *  base) % mod;
            }
            base = (base * base) % mod;
            b >>= 1;
        }
        return res;
    }
}
