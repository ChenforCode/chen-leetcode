package leetcode.editor.cn;

//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 186 👎 0
/**
 *
 * 这道题也是比较巧，判断5个数字是否能练成顺子，其实只要有两个条件。
 * 1、数字不重复
 * 2、数字的最大值和最小值的差值不超过5。
 *
 * 遍历用set判重，然后取最大最小值即可
 * 记得0要跳过不处理，因为大小王可以变成任意一个数字
 */

import java.util.HashSet;
import java.util.Set;

class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int min = 100;
            int max = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                if (set.contains(nums[i])) {
                    return false;
                }
                set.add(nums[i]);
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
            }
            return max - min < 5;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}