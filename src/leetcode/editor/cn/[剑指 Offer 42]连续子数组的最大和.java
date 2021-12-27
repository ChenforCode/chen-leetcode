package leetcode.editor.cn;

//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 👍 433 👎 0

/***
 *
 * dp[i]设定为以num[i]结尾的子序列的一个最大长度，dp[0] = nums[0]
 * 如果dp[i-1] < 0，说明以nums[i-1]结尾的子序列最大也是一个负数，所以他帮不了dp[i]
 * 即dp[i−1] + nums[i] 还不如 nums[i] 本身大。所以dp[i] = nums[i]
 * 否则是有贡献的，就加上去。dp[i] = dp[i - 1] + nums[i]
 **/

class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = -Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if (dp[i - 1] < 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (max < dp[i]) {
                    max = dp[i];
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}