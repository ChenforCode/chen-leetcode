package leetcode.editor.cn;

//给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。 
//
// 子数组 定义为原数组中的一个连续子序列。 
//
// 请你返回 arr 中 所有奇数长度子数组的和 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,4,2,5,3]
//输出：58
//解释：所有奇数长度子数组和它们的和为：
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：3
//解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。 
//
// 示例 3： 
//
// 输入：arr = [10,11,12]
//输出：66
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 1000 
// 
// Related Topics 数组 前缀和 
// 👍 123 👎 0

class SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        Solution solution = new SumOfAllOddLengthSubarrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            //处理得到前缀和，sum[i]是代表0——i-1的和
            int len = arr.length;
            int[] sum = new int[len + 1];
            int ans = 0;
            for (int i = 1; i <= len; i++) {
                sum[i] = sum[i - 1] + arr[i - 1];
            }

            //遍历长度
            for (int sl = 1; sl <= len; sl += 2) {
                //遍历起点
                for (int l = 0; l + sl - 1 < len; l++) {
                    //终点为r 例如左为1，len为2，则右为3
                    //需要计算从1 - 3的和，也就是sum[4] - sum[1]
                    int r = l + sl - 1;
                    ans += (sum[r + 1] - sum[l]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}