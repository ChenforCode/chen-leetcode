package leetcode.editor.cn;

//给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ： 
//
// 
// nums[a] + nums[b] + nums[c] == nums[d] ，且 
// a < b < c < d 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,6]
//输出：1
//解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
// 
//
// 示例 2： 
//
// 输入：nums = [3,3,6,4,5]
//输出：0
//解释：[3,3,6,4,5] 中不存在满足要求的四元组。
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,1,3,5]
//输出：4
//解释：满足要求的 4 个四元组如下：
//- (0, 1, 2, 3): 1 + 1 + 1 == 3
//- (0, 1, 3, 4): 1 + 1 + 3 == 5
//- (0, 2, 3, 4): 1 + 1 + 3 == 5
//- (1, 2, 3, 4): 1 + 1 + 3 == 5
// 
//
// 
//
// 提示： 
//
// 
// 4 <= nums.length <= 50 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 枚举 👍 83 👎 0

/**
 *
 * 题解说用的双指针好像是
 * 这里暂时用暴力搜索
 */

class CountSpecialQuadruplets {
    public static void main(String[] args) {
        Solution solution = new CountSpecialQuadruplets().new Solution();
        solution.countQuadruplets(new int[]{1, 2, 3, 6});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countQuadruplets(int[] nums) {
            int res = 0;
            if (nums.length < 4) {
                return 0;
            }
            for (int i = 0; i < nums.length - 3; i++) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    for (int k = j + 1; k < nums.length - 1; k++) {
                        for (int v = k + 1; v < nums.length; v++) {
                            if (nums[i] + nums[j] + nums[k] == nums[v]) {
                                res++;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}