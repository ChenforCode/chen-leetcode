package leetcode.editor.cn;

//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 694 👎 0
//题解：最终目的是让整个数组有序，那么我们可以先将数组拷贝一份进行排序，
// 然后使用两个指针 ii 和 jj 分别找到左右两端第一个不同的地方，
// 那么 [i, j][i,j] 这一区间即是答案。
//

import java.util.Arrays;

class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] numsSort = nums.clone();
            Arrays.sort(numsSort);
            int i = 0, j = numsSort.length - 1;
            while (i <= j && numsSort[i] == nums[i]) {
                i++;
            }
            while (j >= i && numsSort[j] == nums[j]) {
                j--;
            }
            return j - i + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}