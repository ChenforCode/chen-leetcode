package leetcode.editor.cn;

//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1567 👎 0

/**
 *
 * 这道题可以按照思路进行模拟，
 * [2,3,1,1,4]，假如我们在0号位，可以跳跃两格，即到0 + 2位置，此时最远距离为2
 * 接下来遍历1号位，因为1 < 2说明此位置也是可达的，因此对该位置也进行尝试跳跃，发现
 * 1号位的跳跃距离是1 + 3 = 4，比最远距离2要大一些，因此最远距离更新到4，此时发现4
 * 已经>=nums.length-1，即到了末尾，说明可以结束。返回true。如果走完全程，都没有返回
 * true，则说明跳不过去。
 */

class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length < 2) {
                return true;
            }
            //最远距离
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                //如果i在最远距离之内，说明i是可达的，因此可以尝试基于i继续往后跳跃
                //尝试更新最大值
                if (i <= max) {
                    //以i点尝试跳跃，看她是否能够超越最大值
                    max = Math.max(max, i + nums[i]);
                    //如果最大值已经到头了，则说明是可达的，结束。
                    if (max >= nums.length - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}