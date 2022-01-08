package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 880 👎 0

/**
 *
 * 这道题相比于I题目，就是多了一个限定，即头和尾巴不能同时偷。因此我们可以分为如下两种情况进行讨论
 * 1、不偷头，那么就相当于只在nums[1->nums.length - 1]中偷
 * 2、不偷尾巴，那么就相当于只在nums[0->nums.length - 2]中偷
 *
 * 即对这两个数组分别用dp求一下最大值，然后二者取最大值即可。
 * 可以将求dp的过程封装出来，即传入一个nums[]数组，给出一个该数组的最大值。
 * 然后用Arrays.copyOfRange(nums, 0, nums.length - 1)
 * 和Arrays.copyOfRange(nums, 1, nums.length)将两个数组截取出来。求出最大值
 */

import java.util.Arrays;

class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            } else if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            //不偷第一个房子 dp[1 -> nums.length - 1]
            //不偷最后一个房子 d[0 -> nums.length - 2];
            int res1 = getDPRob(Arrays.copyOfRange(nums, 0, nums.length - 1));
            int res2 = getDPRob(Arrays.copyOfRange(nums, 1, nums.length));
            return Math.max(res1, res2);
        }

        int getDPRob(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}