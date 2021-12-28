package leetcode.editor.cn;

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 470 👎 0


/**
 *
 * 这道题目就是一个搜索的题目，对于char[] chars="abc"这样的一个，a b c各自只能用一次，所以给一个visit数组来标记是否访问
 * 在每次搜索过程中，找到一个没有visit过得字符进行确定，然后把它置为已访问，然后进行下一步搜索，搜索完将标记位恢复
 *
 **/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {

        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] visit;
        Set<String> res = new HashSet<>();

        public String[] permutation(String s) {
            char[] chars = s.toCharArray();
            visit = new int[chars.length];

            dfs(chars, 0, "");

            String[] resStr = new String[res.size()];
            int index = 0;
            for (String str : res) {
                resStr[index++] = str;
            }

            return resStr;
        }

        public void dfs(char[] chars, int step, String curStr) {
            if (step == chars.length) {
                res.add(curStr);
            }

            for (int i = 0; i < chars.length; i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    dfs(chars, step + 1, curStr + chars[i]);
                    visit[i] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}