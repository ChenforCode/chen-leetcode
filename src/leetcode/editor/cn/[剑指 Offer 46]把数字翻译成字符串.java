package leetcode.editor.cn;

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 342 👎 0

/**
 *
 * 一个dp问题，我们定义dp[i]代表以第i位数字结尾的方案个数。类似于123
 * dp[0] = 1 dp[1]是1的方案。dp[2]是12的方案，dp[3]是123的方案
 * 转移方程：对于123的方案，即dp[3]，分类讨论：
 * 1、"3"只能单独编码，不能和"23"一起编码，那么123的方案就是12的方案（即12的每一个方案，最后都补上去一个3即可），即dp[i] = dp[i-1]
 * 2、"3"可以单独编码也可以和"23"一起编码，那么123的方案啊就是1的方案+12的方案，即dp[i] = dp[i-1] + dp[i-2]
 *
 * 那么23两个数字如何能一起编码呢？那就是ab两个数在10-25之间，也就是在字符的编码之间。那么01 02 03这样的算吗，
 * 答案是不算，因为题目明确要求b的编码是1，不是01，01无法完成编码
 */

class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            String str = num + "";
            int len = str.length();
            int[] dp = new int[len + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= len; i++) {
                //判断最后两位能否单独翻译
                String last = str.substring(i - 2, i);
                //这个地方不能任务"05"能翻译成f，因为题目明确说明了只有5能翻译成f，所以05不行，因此只有两位数的才可以翻译
                if (last.compareTo("10") >= 0 && last.compareTo("25") <= 0) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[len];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}