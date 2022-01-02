package leetcode.editor.cn;

//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// Related Topics 递归 数学 👍 508 👎 0

/**
 *
 * 约瑟夫环问题，记住这道题的一个dp答案
 * f(n, m)即n个数字删除m得到的答案可以由前一步递推回来
 * f(n, m) = (f(n-1, m) + m) % n
 * 因此设定dp[i]为i个数字删除m的的结果，dp[1]只有一个数字一定是0
 * 因此dp[i] = (dp[i - 1] + m) % i，迭代计算出来结果即可
 */

class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {
            int[] dp = new int[n + 1];
            dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + m) % i;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}