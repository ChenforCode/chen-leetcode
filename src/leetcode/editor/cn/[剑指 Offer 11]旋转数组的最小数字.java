package leetcode.editor.cn;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 
//输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 456 👎 0

/* 举几个例子就可以了；3 4 5 6 1 2 3，旋转点为1
 * left = 3  right = 3  mid = 6。因为mid（6）是大于right（3）的，所以答案一定在右方
 * 并且答案不会是mid，因为mid已经比别人大了，不可能是最小的。这时i = mid + 1
 *
 * 第二个例子；5 1 2 3 4，旋转点为1
 * left = 5 right = 4 mid = 2。因为mid（2）是小于right（4）的，所以答案一定在左边，
 * 并且答案有可能就是mid，因为目前并没有表明有值比mid小，所以这个时候j = mid
 *
 * 第三个例子就是，当mid和right相等，这个时候是判断不出来答案在左还是在右
 * 例如1 0 1 1 1 和 1 1 1 0 1。此时只需j--，缩小右端点范围就可以了，因为把j删除，剩余
 * 数组里还有有一个和j一样的值（如果就是答案，那么会在接下来的搜索中找到）
 *
 * 总结一下，记住原数组是，左大右小。如果m > right，那么最小值一定在右方，i = m + 1
 * 如果m < right，那么最小值一定在左方，j = m。
 */

class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {
            int j = numbers.length - 1;
            int i = 0;
            while (i < j) {
                int mid = (i + j) / 2;
                if (numbers[mid] > numbers[j]) {
                    i = mid + 1;
                } else if (numbers[mid] < numbers[j]) {
                    j = mid;
                } else {
                    j--;
                }
            }
            return numbers[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}