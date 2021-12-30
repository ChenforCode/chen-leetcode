package leetcode.editor.cn;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 354 👎 0
/**
 *
 * 滑动窗口，i j代表左右边界，区间内的数字是从[i,j-1]，然后大于target的时候缩小窗口i++，小于target的时候
 * 扩大窗口j++
 *
 * 至于为什么是[i,j-1]而不包括j呢。。举个例子，当前i，j都是初始状态都是1，然后开始扩大窗口，判断sum=0 < target
 * 然后sum+=j j++。我们可以看出来此时窗口变成了[1-2]，但是sum = 1，就是并没有加上去右区间。
 * 因此我们定义此题的滑动窗口是一个左闭右开区间
 *
 * 如果找到了一个序列，左/右边界向右移动即可。要不然会一直死在这个循环里，会一直进入(sum=target)的分支里
 */

import java.util.ArrayList;
import java.util.List;

class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        solution.findContinuousSequence(9);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int sum = 0;
            int i = 1, j = 1;
            List<int[]> res = new ArrayList<>();
            while (i <= (target + 1) / 2) {
                if (sum < target) {
                    sum += j;
                    j++;
                } else if (sum > target) {
                    sum -= i;
                    i++;
                } else {
                    int[] curRes = new int[j - i];
                    for (int k = 0; k < (j - i); k++) {
                        curRes[k] = k + i;
                    }
                    res.add(curRes);
                    sum -= i;
                    i++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}