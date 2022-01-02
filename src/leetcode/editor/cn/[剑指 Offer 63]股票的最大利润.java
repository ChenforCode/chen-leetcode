package leetcode.editor.cn;

//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-
//stock/ 
// Related Topics 数组 动态规划 👍 200 👎 0

/**
 * 股票的最大利润，直接dp，设定dp[i]是以i为结尾的数组（i+1）个数字，得到的最大利润
 * dp[0] = 0，即在第一天买了，直接卖了，就是获利0
 * dp[i] = Math.max(dp[i-1], 第i这一天卖的最大利润)
 * =>dp[i] = Math.max(dp[i-1], price[i] - min(0-i))
 * min(0-i)代表找到0-i天之内的最低价格，那么在i卖掉能得到最大利润
 * 因此我们需要实现一个getMin(0,i)函数来遍历的得到0-i之间的一个最小利润
 * 但是我们可以看到，i是一直在往右移动的，0是不变的，因此我们可以在计算dp的同时
 * 维护一个min值，然后直接用即可。。不需要每次都遍历。
 * <p>
 * 先看第一个版本的代码
 * class Solution {
 *  public int maxProfit(int[] prices) {
 *      if (prices.length == 0) {
 *          return 0;
 *      }
 *      int []dp = new int[prices.length];
 *      dp[0] = 0;
 *      for (int i = 1; i < prices.length; i++) {
 *          //min是由一个单独的函数计算出来的。
 *          dp[i] = Math.max(dp[i - 1], prices[i] - getMin(0, i, prices));
 *      }
 *      return dp[prices.length - 1];
 * }
 * public int getMin(int start, int end, int[] prices) {
 *      int min = Integer.MAX_VALUE;
 *      for (int i = start; i <= end; i++) {
 *          min = Math.min(min, prices[i]);
 *      }
 *      return min;
 * }
 * }
 * <p>
 * 第二个版本的代码
 */

class GuPiaoDeZuiDaLiRunLcof {
    public static void main(String[] args) {
        Solution solution = new GuPiaoDeZuiDaLiRunLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int[] dp = new int[prices.length];
            dp[0] = 0;
            //这里默认最小值就是第一天的，因为我们要从第二天开始算。
            //到了第二天会更新最小值。
            int curMin = prices[0];
            for (int i = 1; i < prices.length; i++) {
                //先更新到i为止的一个最低价格
                curMin = Math.min(curMin, prices[i]);
                //min直接用了更新的结果。上边已经得到了0-i的一个最小价格，在这里直接用即可。
                dp[i] = Math.max(dp[i - 1], prices[i] - curMin);
            }
            return dp[prices.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}