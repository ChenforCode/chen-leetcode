package _2020._20200613;

/**
 * @author <a href="http://www.chenforcode.cn">PKUCoder</a>
 * @date 2020/6/13 11:43 上午
 * @description 70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 标签：动态规划
 * 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
 * <p>
 * 爬上 n-1n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
 * 爬上 n-2n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
//    private int sum = 0;
//    public int climbStairs(int n) {
//        depth(n, 0);
//        return sum;
//    }
//
//    public void depth(int n, int step) {
//        if (step == n) {
//            sum++;
//            return;
//        }
//        //走一步
//        depth(n, step + 1);
//        //走两步
//        depth(n, step + 2);
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int result = solution.climbStairs(3);
//        System.out.println(result);
//    }


    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
    }
}
