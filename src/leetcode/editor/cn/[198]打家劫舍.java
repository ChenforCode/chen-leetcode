package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 👍 1823 👎 0

import java.util.Arrays;

/**
 *
 * 这道题直接根据题意，理解，然后得到dp
 *
 * 加入dp[i]设定成为前i间房子能够得到的最大偷盗钱数。根据平时的经验，可以得到i间房偷or不偷是两种方案
 * 但是i偷不偷其实是决定于i-1偷不偷的（因为相邻是不能偷的），因此分为两种情况
 * 1、i-1偷了，i-1偷了，根据相邻原则，那么i就不能偷了，因此i的结果和i-1保持一致，即dp[i] = dp[i - 1]
 * 2、i-1没偷，那么i就可以偷了，因为i-1没偷，所以我们采用i-2的结果+nums[i]，即dp[i] = dp[i - 2] + nums[i]
 *
 * 但是这里给出了nums[i]，其实nums[0]是第一间房子。因此我们的dp保持一致。new dp[length]
 * dp[0] 代表第一间房的最优结果 = nums[i]
 * dp[1] 代表前两间房子的最优结果 = Math.max(nums[0], nums[1])
 */

class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            }

            int[] dp = new int[nums.length];
            //i-2  i-1 i
            //i-1偷了，i不能投 dp[i] = dp[i - 1]
            //i-1没偷，i能偷   dp[i] = dp[i - 2] + nums[i]
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
            return dp[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}