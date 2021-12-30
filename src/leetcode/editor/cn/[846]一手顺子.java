package leetcode.editor.cn;

//Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。 
//
// 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，
//返回 false 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//输出：true
//解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。 
//
// 示例 2： 
//
// 
//输入：hand = [1,2,3,4,5], groupSize = 4
//输出：false
//解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。 
//
// 
//
// 提示： 
//
// 
// 1 <= hand.length <= 10⁴ 
// 0 <= hand[i] <= 10⁹ 
// 1 <= groupSize <= hand.length 
// 
//
// 
//
// 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-
//consecutive-numbers/ 
// Related Topics 贪心 数组 哈希表 排序 👍 188 👎 0
/**
 *
 * 是一道模拟题，看题目new int[]{1, 2, 3, 4, 5}, 4，就是从数组中出n个大小为4的顺子
 * 如果能全部顺完就是true，不能就是false，例如这里只能顺1234，5丢下或者2345，1丢下
 * 因此我们规定都从最小的开始顺。即对数组进行排序，然后从头开始顺，顺的大小是4
 * 每顺走一个，该数字的数量就减一。如果顺的结果为0，说明顺失败了，返回false。
 * 可以用一个map记录每个数字的个数。
 *
 * 具体流程是如此，遍历nums，得到nums[i]，如果nums[i]在map中的个数不为0
 * 因为为0不能从他开始顺。从他开始顺，加入顺的大小为4，那么
 * 接下来我们就要判断nums[i] + 0， nums[i] + 1.... nums[i] + 3四个数字
 * 是否能顺利的从map中扣减1，也就是说在扣减之前，他们任意一个是0（也就是用完了）就失败
 *
 * 还有一种失败是，map中根本没有nums[i] + 1这个数字。所以就是判断个数为0或者根本没有用数字就是失败的
 *
 *
 * */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class HandOfStraights {
    public static void main(String[] args) {
        Solution solution = new HandOfStraights().new Solution();
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int i = 0; i < hand.length; i++) {
                counts.put(hand[i], counts.getOrDefault(hand[i], 0) + 1);
            }
            Arrays.sort(hand);
            for (int i = 0; i < hand.length; i++) {
                if (counts.get(hand[i]) > 0) {
                    for (int j = 0; j < groupSize; j++) {
                        if (!counts.containsKey(hand[i] + j) || counts.get(hand[i] + j) == 0) {
                            return false;
                        }
                        counts.put(hand[i] + j, counts.get(hand[i] + j) - 1);
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}