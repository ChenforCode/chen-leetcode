package leetcode.editor.cn;

//给你一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 哈希表 动态规划 👍 515 👎 0

/**
 *
 * 这道题的难点就是如何把这道题转换成"打家劫舍"的思路。
 * 首先我们知道，取了点数3，不能取点数2和4，但是可以继续取相同的3，因此我们取一个点的时候
 * 直接把改点的所有值都取走，即有10个3，我们取点数直接就是10 * 3
 *
 * 接下来我们按照这个思路，对给出的nums进行一个桶排序。
 * 例如给出[2,2,3,3,3,4]这样的数组，最大值为4，我们创建一个大小为5的桶，其中index
 * 是元素的值，backet[index]是这个值在数组中的总值（10 * 3）
 * 因此经过桶排序之后 backet[0] = 0, backet[1] = 0, backet[2] = 4
 * backet[3] = 6, backet[4] = 4。
 * 此时我们就可以将这个问题转化成打家劫舍的问题。即：存在五户人家（桶的个数），每户人家是
 * 相连的（01234，桶的index），每户人家有自己的价值（backet[index]），不能连续偷取（偷了
 * 3，就不能偷2和4），每次偷都是直接拿到价值（价值就是backet[index]），求一个偷取的最大价值
 * 即求出dp[4]即可，接下来的思路和打家劫舍完全一样。
 */

class DeleteAndEarn {
    public static void main(String[] args) {
        Solution solution = new DeleteAndEarn().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteAndEarn(int[] nums) {
            //进行一个桶排序，即sum[i]指的是nums中所有i元素的和
            //即选了i就不能选i-1和i+1，此时和打家劫舍的思路就一样了
            int max = 0;
            //这一步的目的是找到nums中的最大值，以此来确定桶的大小
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            int[] sum = new int[max + 1];
            int[] dp = new int[max + 1];
            //这一步的目的是对桶中的元素赋初值，例如3 3，那么backet[3] = 3 * 2 = 6
            for (int i = 0; i < nums.length; i++) {
                sum[nums[i]] += nums[i];
            }
            //打家劫舍的dp过程
            //第一间房子的最优结果一定是偷掉
            dp[0] = sum[0];
            //第二间房子的最优结果一定是第一间房子偷了，和第二间房子偷了的一个最大值
            dp[1] = Math.max(sum[0], sum[1]);
            //i-2 i-1 i，假如i-1偷了，那么i不能再偷，dp[i] = dp[i - 1]
            //加入i-1没偷，那么dp[i]就可以偷，加上dp[i - 2]即可，因为i - 1没偷
            //然后二者取最大值即可
            for (int i = 2; i <= max; i++) {
                dp[i] = Math.max(dp[i - 1], sum[i] + dp[i - 2]);
            }
            return dp[max];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}