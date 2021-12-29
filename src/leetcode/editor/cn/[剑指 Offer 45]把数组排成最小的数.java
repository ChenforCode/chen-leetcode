package leetcode.editor.cn;

//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 344 👎 0
/**
 *
 * 这里是定义了一个排序规则，我们认为如果 x + "" +  y > y + "" + x
 * 那么认为x比y"大"，也就是x应该放在y的前边，然后基于这个规则对数组进行一个升序排序即可
 *
 * 正常的升序序列，数字交换，就是 如果 x > y就交换x和y
 * 现在的规则判断就是如果x + y > y + x 就交换y
 *
 * 快排的话，应该是类似这样的while (nums[j] + nums[left] > nums[left] + nums[j]) j--
 *
 **/

import java.util.Arrays;

class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution(); 
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        String[] res = new String[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res, (x, y) -> {
            return (x + "" + y).compareTo(y + "" + x);
        });
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < res.length; i++) {
            sb = sb.append(res[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}