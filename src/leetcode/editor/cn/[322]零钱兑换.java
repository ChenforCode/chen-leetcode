package leetcode.editor.cn;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1639 👎 0

/**
 *
 * dp，设定dp[i]为钱数为i的时候，最少换的硬币个数，则dp[0] = 0
 * 那么对于一个数字i，求dp[i]，需要对所有的coin尝试兑换，如果coin[j] <= i，则可以尝试兑换
 * 兑换产生的结果是 dp[i - coin[j]] + 1，不兑换产生的结果是dp[i]，二者取最小值
 * 上述dp[i - coin[j]] + 1的意思是。例如求dp[100]，那么假如当前遍历coin，找到了
 * coin[j] = 30。即有一张30的钱，那么尝试用30的钱去兑换100，那么dp[100 - 30] = dp[70]
 * 即dp[70] + 1。即把100中的30进行兑换，换成了一张30钱，那么100目前的兑换个数就变成了
 * dp[70]和1张30的。
 */

import java.util.Arrays;

class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{2}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                //对于所有的币值进行尝试兑换
                for (int j = 0; j < coins.length; j++) {
                    //如果币值小于总值，则可以尝试兑换
                    if (coins[j] <= i) {
                        //判断兑换与不兑换谁小，取最小值
                        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}