package leetcode.editor.cn;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 282 👎 0

class PalindromePartitioningIi {
    public static void main(String[] args) {

        Solution solution = new PalindromePartitioningIi().new Solution();
        System.out.println(solution.minCut("aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minCut(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;
            int[][] isPali = new int[len][len];
            //预处理判断是否是回文串。
            for (int j = 0; j < len; j++) {
                for (int i = 0; i <= j; i++) {
                    if (i == j) {
                        isPali[i][j] = 1;
                    } else if (j - i == 1 && chars[i] == chars[j]) {
                        isPali[i][j] = 1;
                    } else if (j - i > 1 && isPali[i + 1][j - 1] == 1 && chars[i] == chars[j]) {
                        isPali[i][j] = 1;
                    }
                }
            }
            
            //计算串的最小分割次数
            int[] dp = new int[len];
            //默认是一个全部切割
            for (int i = 0; i < len; i++) {
                dp[i] = i;
            }
            //dp[0]是不可能变的，从dp1开始计算。从0也可以开始算，只不过会被直接跳过
            for (int i = 0; i < len; i++) {
                //如果这个串是一个回文，那就不用切了
                if (isPali[0][i] == 1) {
                    dp[i] = 0;
                }
                for (int j = 0; j < i; j++) {
                    if(isPali[j + 1][i] == 1) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}