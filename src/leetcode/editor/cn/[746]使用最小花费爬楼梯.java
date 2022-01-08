package leetcode.editor.cn;

//给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。 
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
//
// 请你计算并返回达到楼梯顶部的最低花费。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10,15,20]
//输出：15
//解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//总花费为 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1,100,1,1,1,100,1,1,100,1]
//输出：6
//解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
// Related Topics 数组 动态规划 👍 757 👎 0

/**
 *
 *
 * 这道题和爬楼梯的思路比较像，爬楼梯是当前i层，算有多少种爬上来的可能，就是从i-1层爬上来和从
 * i-2层爬上来，因此dp[i] = dp[i - 1] + dp[i - 2]
 *
 * 这道题是加上了一个限定，从某个楼层爬上来是需要一定的消耗，然后求爬到i层的最少消耗。
 * 因此我们定义dp[i]是爬到i层的最少消耗，因为i层还是由i-1层爬上来和i-2层爬上来。
 * 有i-1层爬上来的总消耗就是dp[i - 1] + cost[i - 1]意思是爬到i-1的消耗+从i-1层爬到i层的消耗
 * i-2层爬上来同理，是dp[i - 2] + cost[i - 2]。然后二者取最小得到dp[i]
 *
 * 基础结果，可以从0层或者1层开始爬，但是二者只是开始，并未开始爬，所以并没有消耗，因此
 * dp[0] = 0，dp[1] = 0。dp[2] = Math.min(dp[0] + cost[0], dp[1] + cost[1])
 */

class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length + 1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= cost.length; i++) {
                dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
            }
            return dp[cost.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}