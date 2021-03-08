package leetcode.editor.cn;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 592 👎 0

/**
 def backtrack(未探索区域, res, path):
    if 未探索区域满足结束条件:
        res.add(path) # 深度拷贝
        return
    for 选择 in 未探索区域当前可能的选择:
        if 当前选择符合要求:
            path.add(当前选择)
            backtrack(新的未探索区域, res, path)
            path.pop()

 **/

import java.util.*;

class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[] chars;
        private int len;
        private Deque<String> curRes = new ArrayDeque<>();
        private List<List<String>> res = new ArrayList<>();

        public List<List<String>> partition(String s) {
            chars = s.toCharArray();
            len = chars.length;
            //从第一个字母开始搜索
            dfs(0);
            return res;
        }

        public void dfs(int index) {
            //index已经越界了，说明已经遍历完了
            if (index == len) {
                res.add(new ArrayList<>(curRes));
            }
            //从当前的index开始切，例如abc，a的index是0，可以切a,ab,abc
            for (int i = index; i < len; i++) {
                //当前切出来的范围是index~i，判断这个切分出来的字符串是否合法
                if (!isPalindrome(index, i)) {
                    continue;
                }
                //如果合法就加入当前的集合。这个的意思是从index开始，切出来count个
                curRes.addLast(new String(chars, index, i + 1 - index));

                //暂时先不看下边的代码，光看上边，那就是对一个字符串abc，尝试切了a,ab,abc
                //接下来，这个的意思是对当前切分的结果，进行继续切分
                //例如abc当前切出来了a，那么下一步需要对bc进行和abc同样的操作。即i + 1
                dfs(i + 1);
                //当前的这个这个字符串切分的所有工作都做完了。需要把它扔掉。例如
                //类似于迷宫问题里，走完了之后，将标志位恢复
                curRes.removeLast();
            }
        }

        public boolean isPalindrome(int left, int right) {
            while (left < right) {
                if (chars[left] != chars[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}